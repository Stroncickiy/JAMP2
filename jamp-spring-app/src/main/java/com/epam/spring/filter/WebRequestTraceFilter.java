package com.epam.spring.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.spring.jms.Destinations;
import com.epam.spring.jms.JMSService;
import com.epam.spring.model.RequestEntry;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebRequestTraceFilter implements Filter {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    @Autowired
    private JMSService jmsService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // do nothing
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        LoggingHttpServletRequestWrapper requestWrapper = new LoggingHttpServletRequestWrapper(httpRequest);
        LoggingHttpServletResponseWrapper responseWrapper = new LoggingHttpServletResponseWrapper(httpResponse);

        String requestDescription = getRequestDescription(requestWrapper);
        filterChain.doFilter(requestWrapper, responseWrapper);
        String responseDescription = getResponseDescription(responseWrapper);
        httpResponse.getOutputStream().write(responseWrapper.getContentAsBytes());

        jmsService.sendMessageToQueue(new ActiveMQQueue(Destinations.REQUESTS_TRACKING_DESTINATION), RequestEntry.builder()
                .request(requestDescription)
                .response(responseDescription)
                .build());
    }

    protected String getRequestDescription(LoggingHttpServletRequestWrapper requestWrapper) {
        LoggingRequest loggingRequest = new LoggingRequest();
        loggingRequest.setSender(requestWrapper.getLocalAddr());
        loggingRequest.setMethod(requestWrapper.getMethod());
        loggingRequest.setPath(requestWrapper.getRequestURI());
        loggingRequest.setParams(requestWrapper.isFormPost() ? null : requestWrapper.getParameters());
        loggingRequest.setHeaders(requestWrapper.getHeaders());
        String content = requestWrapper.getContent();
        loggingRequest.setBody(content);


        try {
            return OBJECT_MAPPER.writeValueAsString(loggingRequest);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    protected String getResponseDescription(LoggingHttpServletResponseWrapper responseWrapper) {
        LoggingResponse loggingResponse = new LoggingResponse();
        loggingResponse.setStatus(responseWrapper.getStatus());
        loggingResponse.setHeaders(responseWrapper.getHeaders());
        String content = responseWrapper.getContent();
        loggingResponse.setBody(content);

        try {
            return OBJECT_MAPPER.writeValueAsString(loggingResponse);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public void destroy() {
        // do nothing
    }
}
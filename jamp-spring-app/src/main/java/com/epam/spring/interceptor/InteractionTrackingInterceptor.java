package com.epam.spring.interceptor;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import com.epam.spring.jms.Destinations;
import com.epam.spring.jms.JMSService;
import com.epam.spring.model.InteractionEntry;
import com.epam.spring.model.InteractionEntry.InteractionEntryBuilder;

@Component
public class InteractionTrackingInterceptor extends AbstractRequestLoggingFilter {
	@Autowired
	private JMSService jmsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		RequestLoggingWrapper requestLoggingWrapper = new RequestLoggingWrapper(request);
		LoggingHttpServletRequestWrapper requestWrapper = new LoggingHttpServletRequestWrapper(request);

		
		InteractionEntry.InteractionEntryBuilder interactionEntryBuilder = InteractionEntry.builder()
				.ip(requestWrapper.getLocalAddr())
				.method(requestWrapper.getMethod())
				.path(requestWrapper.getRequestURI())
				.requestParams(requestWrapper.isFormPost() ? null : requestWrapper.getParameters().toString())
				.requestHeaders(requestWrapper.getHeaders().toString())
				.requestBody(requestLoggingWrapper.getRequestBody());

		ResponseLoggingWrapper responseLoggingWrapper = new ResponseLoggingWrapper(response,new InteractionMessageSender(jmsService, interactionEntryBuilder));
		super.doFilterInternal(requestLoggingWrapper, responseLoggingWrapper, filterChain);
	}

	@Override
	protected void afterRequest(HttpServletRequest arg0, String arg1) {

	}

	@Override
	protected void beforeRequest(HttpServletRequest arg0, String arg1) {

	}

	public static class InteractionMessageSender {
		private JMSService jmsService;
		private InteractionEntryBuilder interactionEntryBuilder;

		public InteractionMessageSender(JMSService jmsService,
				InteractionEntry.InteractionEntryBuilder interactionEntryBuilder) {
			this.jmsService = jmsService;
			this.interactionEntryBuilder = interactionEntryBuilder;
		}

		public void sendMessage(String responseBody, int responseStatus) {
			jmsService.sendMessageToQueue(new ActiveMQQueue(Destinations.REQUESTS_TRACKING_DESTINATION),
					interactionEntryBuilder.responseStatus(responseStatus).responseBody(responseBody).build());
		}
	}

}
package com.epam.spring.interceptor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.io.output.TeeOutputStream;

import com.epam.spring.interceptor.InteractionTrackingInterceptor.InteractionMessageSender;

public class ResponseLoggingWrapper extends HttpServletResponseWrapper {
	private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
	private InteractionMessageSender interactionMessageSender;

	public ResponseLoggingWrapper(HttpServletResponse response, InteractionMessageSender interactionMessageSender) {
		super(response);
		this.interactionMessageSender = interactionMessageSender;

	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		final ServletOutputStream servletOutputStream = ResponseLoggingWrapper.super.getOutputStream();
		return new ServletOutputStream() {
			private TeeOutputStream tee = new TeeOutputStream(servletOutputStream, bos);

			@Override
			public void write(byte[] b) throws IOException {
				tee.write(b);
			}

			@Override
			public void write(byte[] b, int off, int len) throws IOException {
				tee.write(b, off, len);
			}

			@Override
			public void flush() throws IOException {
				tee.flush();
				interactionMessageSender.sendMessage(getResponseBody(), getStatus());
			}

			@Override
			public void write(int b) throws IOException {
				tee.write(b);
			}

			@Override
			public boolean isReady() {
				return servletOutputStream.isReady();
			}

			@Override
			public void setWriteListener(WriteListener writeListener) {
				servletOutputStream.setWriteListener(writeListener);
			}

			@Override
			public void close() throws IOException {
				super.close();
				interactionMessageSender.sendMessage(getResponseBody(), getStatus());
			}
		};
	}

	public String getResponseBody() {
		byte[] toLog = toByteArray();
		if (toLog != null && toLog.length > 0)
			return new String(toLog);
		return null;
	}

	public byte[] toByteArray() {
		byte[] ret = bos.toByteArray();
		bos.reset();
		return ret;
	}

}
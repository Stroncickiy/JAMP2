package com.epam.spring.interceptor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.input.TeeInputStream;

/**
 * Request logging wrapper using proxy split stream to extract request body
 */
public class RequestLoggingWrapper extends HttpServletRequestWrapper {
	private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

	/**
	 * @param requestId
	 *            and id which gets logged to output file. It's used to bind
	 *            request with response
	 * @param request
	 *            request from which we want to extract post data
	 */
	public RequestLoggingWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		final ServletInputStream servletInputStream = RequestLoggingWrapper.super.getInputStream();
		return new ServletInputStream() {
			private TeeInputStream tee = new TeeInputStream(servletInputStream, bos);

			@Override
			public int read() throws IOException {
				return tee.read();
			}

			@Override
			public int read(byte[] b, int off, int len) throws IOException {
				return tee.read(b, off, len);
			}

			@Override
			public int read(byte[] b) throws IOException {
				return tee.read(b);
			}

			@Override
			public boolean isFinished() {
				return servletInputStream.isFinished();
			}

			@Override
			public boolean isReady() {
				return servletInputStream.isReady();
			}

			@Override
			public void setReadListener(ReadListener readListener) {
				servletInputStream.setReadListener(readListener);
			}

			@Override
			public void close() throws IOException {
				super.close();
			}
		};
	}

	public String getRequestBody() {
		return new String(toByteArray());
	}

	public byte[] toByteArray() {
		return bos.toByteArray();
	}

}
package com.epam.decorator;

import java.io.IOException;
import java.io.Writer;

public class ConsoleWriter extends Writer {

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		System.out.println(new String(cbuf));

	}

	@Override
	public void flush() throws IOException {

	}

	@Override
	public void close() throws IOException {

	}

}

package com.epam.decorator;

import java.io.IOException;
import java.io.Writer;

public class SmileWriter {
	private Writer writer;

	public SmileWriter(Writer writer) {
		this.writer = writer;
	}

	public void write(String string) {
		String stringWithSmile = string += " :)";
		try {
			writer.write(stringWithSmile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

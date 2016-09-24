package com.epam.decorator;

public class SmileWriter implements Writer {
	private Writer decoratedWriter;

	public SmileWriter(Writer writer) {
		this.decoratedWriter = writer;
	}

	public void writeString(String string) {

		String stringWithSmile = string += " :)";
		decoratedWriter.writeString(stringWithSmile);

	}
}

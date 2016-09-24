package com.epam.decorator;

public class CommaSeparatorWriter implements Writer {
	private Writer decoratedWriter;

	public CommaSeparatorWriter(Writer writer) {
		this.decoratedWriter = writer;
	}

	public void writeString(String string) {

		String stringWithCommas = string.replace(" ", ",");
		decoratedWriter.writeString(stringWithCommas);

	}
}

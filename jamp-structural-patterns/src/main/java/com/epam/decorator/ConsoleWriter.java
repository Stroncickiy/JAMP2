package com.epam.decorator;

public class ConsoleWriter implements Writer {

	@Override
	public void writeString(String string) {
		System.out.println(string);

	}

}

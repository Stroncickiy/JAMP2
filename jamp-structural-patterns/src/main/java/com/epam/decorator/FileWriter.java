package com.epam.decorator;

import java.io.File;
import java.io.IOException;

public class FileWriter extends java.io.FileWriter implements Writer {

	public FileWriter(File file) throws IOException {
		super(file);
	}

	@Override
	public void writeString(String string) {
		try {
			write(string.toCharArray(), 0, string.length());
			flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

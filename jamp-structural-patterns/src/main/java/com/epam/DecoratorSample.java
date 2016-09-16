package com.epam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.epam.decorator.ConsoleWriter;
import com.epam.decorator.SmileWriter;

public class DecoratorSample {
	public static void exec() throws IOException {
		SmileWriter smileWriter = new SmileWriter(new FileWriter(new File("fileWithSmiles.txt")));
		smileWriter.write(" [FILE] Life is good!!! ");

		SmileWriter smileWriter2 = new SmileWriter(new ConsoleWriter());
		smileWriter2.write(" [CONSOLE] Life is good !!! ");
	}
}

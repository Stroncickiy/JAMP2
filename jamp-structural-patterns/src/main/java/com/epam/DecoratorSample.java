package com.epam;

import java.io.File;
import java.io.IOException;

import com.epam.decorator.CommaSeparatorWriter;
import com.epam.decorator.ConsoleWriter;
import com.epam.decorator.FileWriter;
import com.epam.decorator.SmileWriter;
import com.epam.decorator.Writer;

public class DecoratorSample {
	public static void exec() throws IOException {
		Writer simpleConsoleWriter = new ConsoleWriter();
		simpleConsoleWriter.writeString(" [SIMPLE-CONSOLE-WRITER] Life is good! ");

		Writer smileWriter = new SmileWriter(simpleConsoleWriter);
		smileWriter.writeString(" [SMILE-CONSOLE-WRITER] Life is good! ");

		Writer commaSeparatedWriter = new CommaSeparatorWriter(smileWriter);
		commaSeparatedWriter.writeString(" [SMILE-COMMA-SEPARATED-CONSOLE-WRITER] Life is good! ");

		Writer fileWriter = new CommaSeparatorWriter(new SmileWriter(new FileWriter(new File("result.txt"))));
		fileWriter.writeString(" [SMILE-COMMA-SEPARATED-FILE-WRITER] Life is good! ");
		
	}
}

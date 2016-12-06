package com.epam.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeCommunicationDemo {
	public void run() throws IOException {

		final PipedOutputStream output = new PipedOutputStream();
		final PipedInputStream input = new PipedInputStream(output);

		startPipedWriter(output);
		startPipedReader(input);

	}

	private void startPipedReader(final PipedInputStream input) {
		new Thread(() -> {
			try {
				int data = input.read();
				// while data available
				while (data != -1) {
					System.out.print((char) data); // Converting it to character
													// and write to system
													// output
					data = input.read(); // refresh data variable for loop
				}

			} catch (IOException e) {
				System.out.println("IO Error occured while reading bytes from piped stream...");
			}
		});
	}

	private void startPipedWriter(final PipedOutputStream output) {
		new Thread(() -> {
			try {
				output.write("Hello world, pipe!".getBytes());
			} catch (IOException e) {
				System.out.println("IO Error occured while writing bytes to piped stream...");
			}
		});
	}
}

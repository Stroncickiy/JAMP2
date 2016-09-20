package com.epam.command;

public class RemoteController {

	public void performAction(Command command) {
		command.execute();
	}
}

package com.epam.command;

public class RemoteController {

	private void performAction(Command command) {
		command.execute();
	}

	public void turnOnTV() {
		performAction(new TurnOnTVCommand());
	}

	public void turnOnLights() {
		performAction(new TurnOnLightCommand());
	}
}

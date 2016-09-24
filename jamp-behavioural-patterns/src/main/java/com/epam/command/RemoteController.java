package com.epam.command;

public class RemoteController {

	private void performAction(Command command) {
		command.execute();
	}

	public void turnOnTVCommand() {
		performAction(new TurnOnTVCommand());
	}

	public void turnOnLightsCommand() {
		performAction(new TurnOnLightCommand());
	}
	
	public void turnOffLightsCommand(){
		performAction(new TurnOffLightCommand());
	}
	
	public void turnOffTVCommand(){
		performAction(new TurnOffTVCommand());
	}
}

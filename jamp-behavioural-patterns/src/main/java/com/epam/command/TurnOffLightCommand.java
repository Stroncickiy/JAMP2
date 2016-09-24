package com.epam.command;

public class TurnOffLightCommand implements Command {

	@Override
	public void execute() {
		System.out.println(" TV was turned OFF ");

	}

}

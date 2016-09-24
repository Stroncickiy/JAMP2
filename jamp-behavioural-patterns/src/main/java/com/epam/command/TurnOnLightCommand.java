package com.epam.command;

public class TurnOnLightCommand implements Command {

	@Override
	public void execute() {
		System.out.println(" Light was turned ON ");

	}

}

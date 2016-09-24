package com.epam.command;

public class TurnOffTVCommand implements Command {

	@Override
	public void execute() {
		System.out.println(" Light was turned OFF");
		
	}

}

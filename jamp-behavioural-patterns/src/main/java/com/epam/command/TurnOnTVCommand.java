package com.epam.command;

public class TurnOnTVCommand implements Command {

	@Override
	public void execute() {
		System.out.println(" TV was turned on ");

	}

}

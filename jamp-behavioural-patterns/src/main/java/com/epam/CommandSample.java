package com.epam;

import com.epam.command.RemoteController;
import com.epam.command.TurnOnLightCommand;
import com.epam.command.TurnOnTVCommand;

public class CommandSample {
	public static void exec() {
		RemoteController controller = new RemoteController();
		controller.performAction(new TurnOnLightCommand());
		controller.performAction(new TurnOnTVCommand());

	}
}

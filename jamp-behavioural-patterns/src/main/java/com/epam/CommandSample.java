package com.epam;

import com.epam.command.RemoteController;

public class CommandSample {
	public static void exec() {
		RemoteController controller = new RemoteController();

		controller.turnOnLightsCommand();
		controller.turnOnTVCommand();
		controller.turnOffTVCommand();
		controller.turnOffLightsCommand();

	}
}

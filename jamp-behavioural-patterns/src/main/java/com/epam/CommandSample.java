package com.epam;

import com.epam.command.RemoteController;

public class CommandSample {
	public static void exec() {
		RemoteController controller = new RemoteController();

		controller.turnOnLights();
		controller.turnOnTV();

	}
}

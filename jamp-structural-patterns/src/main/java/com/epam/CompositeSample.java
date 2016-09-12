package com.epam;

import com.epam.composite.Chemomile;
import com.epam.composite.Flowerbed;
import com.epam.composite.Garden;
import com.epam.composite.GardenPart;
import com.epam.composite.Rose;

public class CompositeSample {
	public static void exec() {
		GardenPart garden = new Garden();
		GardenPart flowebed = new Flowerbed();
		flowebed.add(new Rose());
		flowebed.add(new Chemomile());
		garden.add(flowebed);
		garden.plant();
	}
}

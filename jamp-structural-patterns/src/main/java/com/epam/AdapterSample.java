package com.epam;

import com.epam.transmission.AutomaticTransmission;
import com.epam.transmission.ManualToAutomaticAdapter;
import com.epam.transmission.ManualTransmission;
import com.epam.transmission.ManualTransmissionImpl;

public class AdapterSample {
	public static void exec() {
		ManualTransmission manualTransmission = new ManualTransmissionImpl();
		ManualToAutomaticAdapter adapter = new ManualToAutomaticAdapter(manualTransmission);
		AutomaticTransmission automaticTransmission = adapter;

		automaticTransmission.gearUp();
		automaticTransmission.gearUp();
		automaticTransmission.gearUp();
		automaticTransmission.gearDown();
		automaticTransmission.gearDown();
		automaticTransmission.gearDown();

	}
}

package com.epam;

import com.epam.adapter.AutomaticTransmission;
import com.epam.adapter.ManualToAutomaticAdapter;
import com.epam.adapter.ManualTransmission;
import com.epam.adapter.ManualTransmissionImpl;

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

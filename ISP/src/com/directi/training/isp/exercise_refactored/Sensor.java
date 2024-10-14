package com.directi.training.isp.exercise_refactored;

import java.util.Random;

public class Sensor {

	public void register(SensorDoor sensorDoor)
    {
        while (true) {
            if (isPersonClose()) {
            	sensorDoor.proximityCallback();
                break;
            }
        }
    }

    private boolean isPersonClose()
    {
        return new Random().nextBoolean();
    }

}

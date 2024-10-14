package com.directi.training.isp.exercise_refactored;

import java.util.TimerTask;

public class Timer {

	public void register(long timeOut, final TimeoutDoor timeoutDoor)
    {
        java.util.Timer timerUtility = new java.util.Timer();
        timerUtility.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
            	timeoutDoor.timeOutCallback();
            }
        }, timeOut);
    }
	
}

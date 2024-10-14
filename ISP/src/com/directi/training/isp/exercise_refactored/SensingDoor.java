package com.directi.training.isp.exercise_refactored;

public class SensingDoor implements SensorDoor {

	private boolean _locked;
    private boolean _opened;

    public SensingDoor(Sensor sensor) {
        sensor.register(this);
    }

    public void lock() {
        _locked = true;
    }

    public void unlock() {
        _locked = false;
    }

    public void open() {
        if (!_locked) {
            set_opened(true);
        }
    }

    public void close() {
        set_opened(false);
    }

    @Override
    public void proximityCallback() {
        if (!_locked) {
            set_opened(true);
        }
    }

	public boolean is_opened() {
		return _opened;
	}

	public void set_opened(boolean _opened) {
		this._opened = _opened;
	}
}

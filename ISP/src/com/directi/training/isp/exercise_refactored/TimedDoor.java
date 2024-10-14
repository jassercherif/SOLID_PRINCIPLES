package com.directi.training.isp.exercise_refactored;

public class TimedDoor implements TimeoutDoor{

	private static final int TIME_OUT = 100;
    private boolean _locked;
    private boolean _opened;

    public TimedDoor(Timer timer) {
        timer.register(TIME_OUT, this);
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
    public void timeOutCallback() {
        _locked = true;
    }

	public boolean is_opened() {
		return _opened;
	}

	public void set_opened(boolean _opened) {
		this._opened = _opened;
	}

}

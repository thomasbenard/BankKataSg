package com.kata.sg;

public class FakeClock implements Clock {
    private Date now;

    public FakeClock(final Date date) {
        super();
        now = date;
    }

    @Override
    public Date now() {
        return now;
    }

    public void set(final Date date) {
        now = date;
    }
}

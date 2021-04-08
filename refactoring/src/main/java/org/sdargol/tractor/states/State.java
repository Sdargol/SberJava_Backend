package org.sdargol.tractor.states;

import org.sdargol.tractor.Tractor;

public abstract class State {
    protected final Tractor tractor;

    public State(Tractor tractor){
        this.tractor = tractor;
    }

    protected final void checkPosition() {
        if ((tractor.getPosition()[0] >= tractor.getField()[0])
                || (tractor.getPosition()[1] >= tractor.getField()[1])) {
            throw new RuntimeException("Че то там с трактором...");
        }
    }

    public abstract void moveForwards();

    public abstract void turnClockwise();
}

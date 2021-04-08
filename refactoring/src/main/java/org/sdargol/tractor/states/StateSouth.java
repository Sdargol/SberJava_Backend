package org.sdargol.tractor.states;

import org.sdargol.tractor.Orientation;
import org.sdargol.tractor.Tractor;

public class StateSouth extends State{
    public StateSouth(Tractor tractor) {
        super(tractor);
        tractor.setOrientation(Orientation.SOUTH);
    }

    @Override
    public void moveForwards() {
        checkPosition();
        tractor.setPosition(new int[] { tractor.getPosition()[0], tractor.getPosition()[1] - 1 });
    }

    @Override
    public void turnClockwise() {
        tractor.setState(new StateWest(tractor));
    }
}

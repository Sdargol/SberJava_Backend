package org.sdargol.tractor.states;

import org.sdargol.tractor.Orientation;
import org.sdargol.tractor.Tractor;

public class StateWest extends State{
    public StateWest(Tractor tractor) {
        super(tractor);
        tractor.setOrientation(Orientation.WEST);
    }

    @Override
    public void moveForwards() {
        checkPosition();
        tractor.setPosition(new int[] { tractor.getPosition()[0] - 1, tractor.getPosition()[1] });
    }

    @Override
    public void turnClockwise() {
        tractor.setState(new StateNorth(tractor));
    }
}

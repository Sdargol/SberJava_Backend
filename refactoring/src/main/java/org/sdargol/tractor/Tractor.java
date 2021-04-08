package org.sdargol.tractor;

import org.sdargol.tractor.states.State;
import org.sdargol.tractor.states.StateNorth;

public class Tractor {
    State state;
    Orientation orientation;
    int[] position;
    int[] field;

    public Tractor(){
        state = new StateNorth(this);
        position = new int[] { 0, 0 };
        field = new int[] { 5, 5 };
    }

    public void setState(State state){
        this.state = state;
    }

    public void moveForwards() {
        state.moveForwards();
    }

    public void turnClockwise() {
        state.turnClockwise();
    }

    public void setOrientation(Orientation orientation){
        this.orientation = orientation;
    }

    public void setPosition(int[] position){
        this.position = position;
    }

    public int[] getPosition() {
        return position;
    }

    public int[] getField() {
        return field;
    }
}

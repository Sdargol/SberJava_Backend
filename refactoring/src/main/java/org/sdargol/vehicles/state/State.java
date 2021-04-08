package org.sdargol.vehicles.state;

import org.sdargol.tractor.Orientation;
import org.sdargol.vehicles.IOrientationManager;
import org.sdargol.vehicles.Vehicles;
import org.sdargol.vehicles.manager.IManager;
import org.sdargol.vehicles.manager.IStatePositionManager;

import java.util.Arrays;

public abstract class State<T extends IManager> implements IStatePositionManager<T> {
    public State(IOrientationManager orientationManager, Orientation orientation){
        orientationManager.setOrientation(orientation);
    }

    private void printState(Vehicles vehicles){
        System.out.println("[" + vehicles.getTitle() +"]: orientation = " + vehicles.getOrientation());
        System.out.println("[" + vehicles.getTitle() +"]: position = " + Arrays.toString(vehicles.getPosition()));
        System.out.println("[" + vehicles.getTitle() +"]: field = " + Arrays.toString(vehicles.getField()));
        System.out.print("\n");
    }

    protected final void checkPosition(Vehicles vehicles) {
        printState(vehicles);
        if ((vehicles.getPosition()[0] >= vehicles.getField()[0])
                || (vehicles.getPosition()[1] >= vehicles.getField()[1])) {
            throw new RuntimeException("Че то там с " + vehicles.getTitle());
        }
    }

}

package org.sdargol.vehicles.state;

import org.sdargol.tractor.Orientation;
import org.sdargol.vehicles.IOrientationManager;
import org.sdargol.vehicles.manager.IManager;
import org.sdargol.vehicles.Vehicles;

public class StateEast<T extends IManager> extends State<T>{

    public StateEast(IOrientationManager orientationManager) {
        super(orientationManager, Orientation.EAST);
    }

    @Override
    public void moveForwards(Vehicles vehicles) {
        checkPosition(vehicles);
        vehicles.setPosition(new int[] { vehicles.getPosition()[0] + 1, vehicles.getPosition()[1]});
    }

    @Override
    public void turnClockwise(IOrientationManager tractor, T manager) {
        manager.setState(new StateSouth<>(tractor));
    }
}

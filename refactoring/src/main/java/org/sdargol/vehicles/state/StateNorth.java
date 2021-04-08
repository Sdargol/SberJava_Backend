package org.sdargol.vehicles.state;

import org.sdargol.tractor.Orientation;
import org.sdargol.vehicles.IOrientationManager;
import org.sdargol.vehicles.Vehicles;
import org.sdargol.vehicles.manager.IManager;

public class StateNorth<T extends IManager> extends State<T>{

    public StateNorth(IOrientationManager orientationManager) {
        super(orientationManager, Orientation.NORTH);
    }

    @Override
    public void moveForwards(Vehicles vehicles) {
        checkPosition(vehicles);
        vehicles.setPosition(new int[] { vehicles.getPosition()[0], vehicles.getPosition()[1] + 1 });
    }

    @Override
    public void turnClockwise(IOrientationManager tractor, T manager) {
        manager.setState(new StateEast<>(tractor));
    }
}

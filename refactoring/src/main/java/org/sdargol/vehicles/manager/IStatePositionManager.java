package org.sdargol.vehicles.manager;

import org.sdargol.vehicles.IOrientationManager;
import org.sdargol.vehicles.Vehicles;

public interface IStatePositionManager<T extends IManager> {
    void moveForwards(Vehicles vehicles);
    void turnClockwise(IOrientationManager tractor, T manager);
}

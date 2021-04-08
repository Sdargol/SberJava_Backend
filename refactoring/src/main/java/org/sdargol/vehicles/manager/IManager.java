package org.sdargol.vehicles.manager;

import org.sdargol.vehicles.state.State;

public interface IManager {
    void moveForwards();
    void turnClockwise();
    void setState(State<IManager> state);
}

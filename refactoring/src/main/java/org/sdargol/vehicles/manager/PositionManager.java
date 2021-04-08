package org.sdargol.vehicles.manager;

import org.sdargol.vehicles.Vehicles;
import org.sdargol.vehicles.state.State;
import org.sdargol.vehicles.state.StateNorth;

public class PositionManager implements IManager {
    private final Vehicles vehicles;
    private State<IManager> state;

    public PositionManager(Vehicles vehicles) {
        this.vehicles = vehicles;
        this.state = new StateNorth<>(this.vehicles);
    }

    @Override
    public void moveForwards() {
        state.moveForwards(vehicles);
    }

    @Override
    public void turnClockwise() {
        state.turnClockwise(vehicles, this);
    }

    @Override
    public void setState(State<IManager> state) {
        this.state = state;
    }

    public void command(ICommand command){
        command.execute(this);
    }

}

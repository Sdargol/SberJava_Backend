package org.sdargol.vehicles;

import org.sdargol.vehicles.manager.ICommand;
import org.sdargol.vehicles.manager.PositionManager;

import java.util.HashMap;

public class VehiclesControl {
    private final HashMap<String, ICommand> commands;
    private final PositionManager positionManager;

    public VehiclesControl(PositionManager positionManager){
        commands = new HashMap<>();
        this.positionManager = positionManager;
    }

    public void addCommand(String name, ICommand command){
        commands.put(name, command);
    }

    public void move(String command){
        if(commands.containsKey(command)){
            positionManager.command(commands.get(command));
        }
    }
}

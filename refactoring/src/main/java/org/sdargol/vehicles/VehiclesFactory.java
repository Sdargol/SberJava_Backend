package org.sdargol.vehicles;

import org.sdargol.vehicles.manager.IManager;
import org.sdargol.vehicles.manager.PositionManager;

public class VehiclesFactory {
    private static PositionManager getTractorManager(){
        return new PositionManager(new Tractor());
    }

    public static VehiclesControl getTractorControl(){
        VehiclesControl vc = new VehiclesControl(getTractorManager());
        vc.addCommand("Forward", IManager::moveForwards);
        vc.addCommand("Turn", IManager::turnClockwise);
        return vc;
    }
}

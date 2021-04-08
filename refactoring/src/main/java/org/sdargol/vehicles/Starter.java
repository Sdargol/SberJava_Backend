package org.sdargol.vehicles;

public class Starter {
    public static void main(String[] args) {
        VehiclesControl tractor = VehiclesFactory.getTractorControl();

        for (int i = 0; i < 5; i++) {
            tractor.move("Forward");
            tractor.move("Turn");
        }
    }
}

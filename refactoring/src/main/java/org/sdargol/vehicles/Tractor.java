package org.sdargol.vehicles;

import org.sdargol.tractor.Orientation;

public class Tractor extends Vehicles{
    public Tractor() {
        super("Трактор МТЗ-80", new int[]{5,5});
    }

    @Override
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}

package org.sdargol.vehicles;

import org.sdargol.tractor.Orientation;

public abstract class Vehicles implements IOrientationManager {
    protected Orientation orientation;
    private final String title;
    private int[] position;
    private final int[] field;

    public Vehicles(String title, int[] field){
        this.title = title;
        this.field = field;
        this.position = new int[]{0,0};
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public String getTitle() {
        return title;
    }

    public void setPosition(int[] position){
        this.position = position;
    }

    public int[] getPosition() {
        return position;
    }

    public int[] getField() {
        return field;
    }
}

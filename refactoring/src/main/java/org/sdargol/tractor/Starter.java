package org.sdargol.tractor;

import java.util.Arrays;

public class Starter {

    public static void main(String[] args) {
        Tractor tractor = new Tractor();

        for (int i = 0; i < 5; i++) {
            tractor.moveForwards();
            System.out.println(Arrays.toString(tractor.getPosition()));
        }
    }

}

package org.vodka.demo.domain;

/**
 * Class used for storing Fluid strength in percents.
 */
public class Fluid {

    private int strength;

    public Fluid(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}

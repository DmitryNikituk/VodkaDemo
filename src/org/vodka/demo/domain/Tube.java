package org.vodka.demo.domain;


/**
 * This Class represent Reservoir with unlimited amount of Fluid.
 * Some methods should not be used for this implementations because it doesn't make sense.
 * In those cases UnsupportedOperationException will be thrown.
 */
public class Tube implements Reservoir{

    private Fluid fluid;
    private String name;

    public Tube(Fluid fluid, String name) {
        this.fluid = fluid;
        this.name = name;
    }

    @Override
    public Fluid getFluid() {
        return fluid;
    }

    @Override
    public int getMaxAmount() {
        return -1;
    }

    @Override
    public int getCurrentAmount() {
        return -1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int fill(Fluid anotherFluid, int size) {
        throw new UnsupportedOperationException();
    }
}

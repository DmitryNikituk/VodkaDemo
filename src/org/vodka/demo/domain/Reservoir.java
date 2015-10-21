package org.vodka.demo.domain;


/**
 * Generic interface for representing Reservoir for different Fluids.
 */
public interface Reservoir {

    /**
     * @return fluid in reservoir;
     */
    Fluid getFluid();

    /**
     * @return max amount of fluide in reservoir.
     */
    int getMaxAmount();

    /**
     * @return current amount of fluide in reservoir.
     */
    int getCurrentAmount();

    /**
     * @return reservoir name (state).
     */
    String getName();

    /**
     * Transfer specified size of fluid into Reservoir
     * @param anotherFluid - fluid to transfer
     * @param size - amount of fluid to transfer
     * @return amount of transferred fluids.
     */
    int fill(Fluid anotherFluid, int size);

}

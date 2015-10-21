package org.vodka.demo.domain;


import java.text.MessageFormat;

/**
 * This Class represent Reservoir with limited amount of Fluid available.
 */
public class Canister implements Reservoir{

    private static final String CANISTER_STATE_MESSAGE = "{0} = {1}, ({2}%)";

    private int maxAmount;
    private int currentAmount;
    private Fluid fluid;
    private String name;

    public Canister(int volume, String name) {
        this.maxAmount = volume;
        this.name = name;
        currentAmount = 0;
        fluid = new Fluid(0);
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    @Override
    public Fluid getFluid() {
        return fluid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int fill(Fluid anotherFluid, int availableFluidSize) {
        int transferSize = calculateTransferAmount(availableFluidSize);

        if(transferSize > 0) {
            fluid = Canister.mixFluids(fluid, anotherFluid, currentAmount, transferSize);
            currentAmount = currentAmount + transferSize;
        }

        return transferSize;
    }

    public void decreaseCurrentVolume(int amount) {
        currentAmount = currentAmount - amount;
        if(currentAmount == 0) {
            fluid.setStrength(0);
        }
    }

    @Override
    public String toString() {
        String currentState = (currentAmount == 0) ? "Empty" : "" + currentAmount + "L";
        return MessageFormat.format(CANISTER_STATE_MESSAGE, name, currentState, fluid.getStrength());
    }

    private int calculateTransferAmount(int availableFluidSize) {
        int transferSize = 0;
        int emptySize = maxAmount - currentAmount;
        if(emptySize > 0) {
            transferSize = availableFluidSize;
            if (transferSize > emptySize) {
                transferSize = emptySize;
            }
        }

        return transferSize;
    }

    private static Fluid mixFluids(Fluid a1, Fluid a2, int sizeA1, int sizeA2) {
        int strength = (sizeA1*a1.getStrength() + sizeA2*a2.getStrength())/(sizeA1+sizeA2);
        return new Fluid(strength);
    }

}

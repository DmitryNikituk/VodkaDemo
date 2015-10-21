package org.vodka.demo.utils;

import org.vodka.demo.domain.*;

import java.text.MessageFormat;

/**
 * Utility Class for making different operations with Reservoirs.
 */
public final class CanisterUtil {

    private static final String FILL_CANISTER_MESSAGE = "Fill {0} with {1}.";
    private static final String TRANSFER_CANISTER_MESSAGE = "Transfer {0} content to {1}.";
    private static final String PURGE_CANISTER_MESSAGE = "Purge {0}";

    private CanisterUtil() {}

    /**
     * Fill target Reservoir with fluids from source reservoir.
     *
     * @param source
     * @param target
     * @return Action information message.
     */
    public static String fillCanister(Reservoir source, Reservoir target) {
        int fillSize = (source.getCurrentAmount() == -1) ? target.getMaxAmount() : source.getMaxAmount();
        target.fill(source.getFluid(), fillSize);

        return MessageFormat.format(FILL_CANISTER_MESSAGE, target.getName(), source.getName());
    }

    /**
     * Transfer fluid from source Canister into target Canister
     * @param source Canister
     * @param target Canister
     * @return Action information message.
     */
    public static String transferFluidBetweenCanisters(Canister source, Canister target) {
        int transferredSize = target.fill(source.getFluid(), source.getCurrentAmount());
        source.decreaseCurrentVolume(transferredSize);

        return MessageFormat.format(TRANSFER_CANISTER_MESSAGE, target.getName(), source.getName());
    }

    /**
     * Remove fluid from Canister.
     *
     * @param canister
     * @return
     */
    public static String purgeCanister(Canister canister) {
        canister.decreaseCurrentVolume(canister.getCurrentAmount());
        return MessageFormat.format(PURGE_CANISTER_MESSAGE, canister.getName());
    }

}

package org.vodka.demo;

import org.vodka.demo.domain.Canister;
import org.vodka.demo.domain.Fluid;
import org.vodka.demo.domain.Tube;
import org.vodka.demo.utils.CanisterUtil;

public class Main {

    public static void main(String[] args) {
        Tube v1 = new Tube(new Fluid(100), "V1");
        Tube v2 = new Tube(new Fluid(0), "V2");

        Canister c1 = new Canister(3, "C1");
        Canister c2 = new Canister(5, "C2");

        logTableHeaders();

        generateOneLitreOfVodka(v1, v2, c1, c2);
    }

    private static void generateOneLitreOfVodka(Tube spirtSource, Tube waterSource, Canister firstCanister, Canister secondCanister) {
        String operationMessage = CanisterUtil.fillCanister(spirtSource, firstCanister);
        logMessage(operationMessage, firstCanister, secondCanister);

        operationMessage = CanisterUtil.transferFluidBetweenCanisters(firstCanister, secondCanister);
        logMessage(operationMessage, firstCanister, secondCanister);

        operationMessage = CanisterUtil.fillCanister(waterSource, firstCanister);
        logMessage(operationMessage, firstCanister, secondCanister);

        operationMessage = CanisterUtil.transferFluidBetweenCanisters(firstCanister, secondCanister);
        logMessage(operationMessage, firstCanister, secondCanister);

        operationMessage = CanisterUtil.transferFluidBetweenCanisters(secondCanister, firstCanister);
        logMessage(operationMessage, firstCanister, secondCanister);

        operationMessage = CanisterUtil.transferFluidBetweenCanisters(firstCanister, secondCanister);
        logMessage(operationMessage, firstCanister, secondCanister);

        operationMessage = CanisterUtil.purgeCanister(secondCanister);
        logMessage(operationMessage, firstCanister, secondCanister);
    }

    private static void logTableHeaders() {
        System.out.format("%30s | %20s | %20s%n", "Action", "C1 (state)", "C2 (state)");
        System.out.println("----------------------------------------------------------------------------");
    }

    private static void logMessage(String operationMessage, Canister firstCanister, Canister secondCanister) {
        System.out.format("%30s | %20s | %20s%n", operationMessage, firstCanister, secondCanister);
    }
}

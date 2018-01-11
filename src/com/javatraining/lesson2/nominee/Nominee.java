/**
 * Represents a recipient of the award.
 *
 * @author Iryna_Yeutushenka
 */


package com.javatraining.lesson2.nominee;

import com.javatraining.lesson2.award.Award;

public class Nominee {

    {
        System.out.println("Nominee class is initialized - info from instance initialization block");
    }

    static {
        System.out.println("Nominee class is initialized - info from static initialization block");
    }

    private final String name;
    private int nomineeAwardQuantityLimit;
    private double nomineeAwardAmountLimit;
    private double nomineeReceivedAwardAmount;
    private int nomineeReceivedAwardQuantity;

    public Nominee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNomineeAwardQuantityLimit() {
        return nomineeAwardQuantityLimit;
    }

    public void setNomineeAwardQuantityLimit(int nomineeAwardQuantityLimit) {
        this.nomineeAwardQuantityLimit = nomineeAwardQuantityLimit;
    }

    public double getNomineeAwardAmountLimit() {
        return nomineeAwardAmountLimit;
    }

    public void setNomineeAwardAmountLimit(double nomineeAwardAmountLimit) {
        this.nomineeAwardAmountLimit = nomineeAwardAmountLimit;
    }

    public double getNomineeReceivedAwardAmount() {
        return nomineeReceivedAwardAmount;
    }

    public void setNomineeReceivedAwardAmount(double nomineeReceivedAwardAmount) {
        this.nomineeReceivedAwardAmount = nomineeReceivedAwardAmount;
    }

    public int getNomineeReceivedAwardQuantity() {
        return nomineeReceivedAwardQuantity;
    }

    public void setNomineeReceivedAwardQuantity(int nomineeReceivedAwardQuantity) {
        this.nomineeReceivedAwardQuantity = nomineeReceivedAwardQuantity;
    }

    /**
     * Method provides information about award to be received by the recipient and applied soli.
     *
     * @param award - chosen award for nomination
     */
    public void receiveAward(Award award) {
        float awardValueWithSoli = award.getValue() * award.getSoli();
        if (award.getSoli() == 0.0f) {
            System.out.println(String.format("Award Details for Recipient: Award Value - %s, Award Currency - %s. No SOLI applied",
                    award.getValue(), award.getCurrency()));
        } else if (award.getSoli() < 1.0f) {
            System.out.println(String.format("Award Details for Recipient: Award Value with SOLI - %s, Award Currency - %s, SOLI value - %s, Gone - %s.",
                    awardValueWithSoli, award.getCurrency(), award.getSoli(), (100 - (award.getSoli() * 100) + "%")));
        } else if (award.getSoli() > 1.0f) {
            System.out.println(String.format("Award Details for Recipient: Award Value with SOLI - %s, Award Currency - %s, SOLI value - %s, Added - %s.",
                    awardValueWithSoli, award.getCurrency(), award.getSoli(), ((award.getSoli() * 100 - 100) + "%")));
        } else {
            System.out.println(String.format("Award Details for Recipient: Award Value with SOLI - %s, Award Currency - %s, SOLI value - %s, Award value hasn't changed.",
                    awardValueWithSoli, award.getCurrency(), award.getSoli()));
        }
    }
}
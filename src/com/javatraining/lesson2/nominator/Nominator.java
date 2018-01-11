/**
 * Represents a nominator of the award.
 *
 * @author Iryna_Yeutushenka
 */

package com.javatraining.lesson2.nominator;

import com.javatraining.lesson2.award.Award;
import com.javatraining.lesson2.nominee.Nominee;


public class Nominator {

    static {
        System.out.println("Nominator class is initialized - info from static initialization block");
    }

    private String name;
    private int nominatorAwardQuantityLimit;
    private double nominatorAwardAmountLimit;
    private double nominatorGivenAwardAmount;
    private int nominatorGivenAwardQuantity;

    public Nominator() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNominatorAwardQuantityLimit() {
        return nominatorAwardQuantityLimit;
    }

    public void setNominatorAwardQuantityLimit(int nominatorAwardQuantityLimit) {
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
    }

    public double getNominatorAwardAmountLimit() {
        return nominatorAwardAmountLimit;
    }

    public void setNominatorAwardAmountLimit(double nominatorAwardAmountLimit) {
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
    }

    public double getNominatorGivenAwardAmount() {
        return nominatorGivenAwardAmount;
    }

    public void setNominatorGivenAwardAmount(double nominatorGivenAwardAmount) {
        this.nominatorGivenAwardAmount = nominatorGivenAwardAmount;
    }

    public int getNominatorGivenAwardQuantity() {
        return nominatorGivenAwardQuantity;
    }

    public void setNominatorGivenAwardQuantity(int nominatorGivenAwardQuantity) {
        this.nominatorGivenAwardQuantity = nominatorGivenAwardQuantity;
    }

    /**
     * Method creates nomination for one nominee and provides information about it's values
     *
     * @param nominee - the award recipient
     * @param award   - chosen award for nomination
     */
    public void nominate(Nominee nominee, Award award) {
        nominee.receiveAward(award);
        System.out.println(String.format("Award details for Nominator: Award value - %s, Award Currency - %s, Nominee - %s",
                award.getValue(), award.getCurrency(), nominee.getName()));
    }

    /**
     * Method creates nomination for several nominees and provides information about it's values
     *
     * @param nominees - list of the award recipients
     * @param award    - chosen award for nomination
     */
    public void nominate(Nominee[] nominees, Award award) {
        for (Nominee n : nominees) {
            n.receiveAward(award);
            System.out.println(String.format("Award details for Nominator: Award value - %s, Award Currency - %s, Nominee - %s",
                    award.getValue(), award.getCurrency(), n.getName()));
        }
    }

    /**
     * Method creates several nominations for one nominee and provides information about it's values
     *
     * @param nominee - the award recipient
     * @param awardList - list of the awards
     */
    public void nominate(Nominee nominee, Award[] awardList) {
        for (Award award : awardList) {
            nominee.receiveAward(award);
            System.out.println(String.format("Award details for Nominator: Award value - %s, Award Currency - %s, Nominee - %s",
                    award.getValue(), award.getCurrency(), nominee.getName()));
        }
    }
}
/**
 * Represents a user.
 *
 * @author Iryna_Yeutushenka
 */

package com.javatraining.lesson2.person;

import com.javatraining.lesson2.language.Language;
import com.javatraining.lesson2.operationsWithLimit.OperationsWithLimit;

public abstract class Person implements OperationsWithLimit {

    private String name;
    private static Role defaultRole = Role.AUTHORIZED;
    private int awardQuantityLimit;
    private double awardAmountLimit;
    private int currentAwardQuantity;
    private double currentAwardAmount;

    /**
     * Default Person constructor without parameters
     */
    protected Person() {
    }

    /**
     * Person constructor with name parameter
     *
     * @param name - user name
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Getter for Name
     *
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for Name
     *
     * @param name - user name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for AwardQuantityLimit
     *
     * @return user limit for award quantity
     */
    public int getAwardQuantityLimit() {
        return awardQuantityLimit;
    }

    /**
     * Setter for AwardQuantityLimit
     *
     * @param awardQuantityLimit user limit for award quantity to set
     */
    public void setAwardQuantityLimit(int awardQuantityLimit) {
        this.awardQuantityLimit = awardQuantityLimit;
    }

    /**
     * Getter for AwardAmountLimit
     *
     * @return user limit for award amount
     */
    public double getAwardAmountLimit() {
        return awardAmountLimit;
    }

    /**
     * Setter for AwardAmountLimit
     *
     * @param awardAmountLimit user limit for award amount to set
     */
    public void setAwardAmountLimit(double awardAmountLimit) {
        this.awardAmountLimit = awardAmountLimit;
    }

    /**
     * Getter for CurrentAwardQuantity;
     *
     * @return current quantity of awards user received
     */
    public int getCurrentAwardQuantity() {
        return currentAwardQuantity;
    }

    /**
     * Setter for CurrentAwardQuantity;
     *
     * @param currentAwardQuantity current quantity of awards user received to set
     */
    public void setCurrentAwardQuantity(int currentAwardQuantity) {
        this.currentAwardQuantity = currentAwardQuantity;
    }

    /**
     * Getter for CurrentAwardAmount
     *
     * @return current amount of awards user received
     */
    public double getCurrentAwardAmount() {
        return currentAwardAmount;
    }

    /**
     * Setter for CurrentAwardAmount
     *
     * @param currentAwardAmount current amount of awards user received to set
     */
    public void setCurrentAwardAmount(double currentAwardAmount) {
        this.currentAwardAmount = currentAwardAmount;
    }

    /**
     * Method checks if Award Quantity Limit is reached
     *
     * @param currentAmount limit to be reached after chosen award is given
     * @param limit         established limit
     * @return true if limit is reached and false otherwise
     */
    public boolean isAwardQuantityLimitReached(int currentAmount, int limit) {
        return currentAmount > limit;
    }

    /**
     * Method checks if Award Amount Limit is reached
     *
     * @param currentAmount limit to be reached after chosen award is given
     * @param limit         established limit
     * @return true if limit is reached and false otherwise
     */
    public boolean isAwardAmountLimitReached(double currentAmount, double limit) {
        return currentAmount > limit;
    }

    /**
     * Method that provides information about user
     */
    public void displayPersonInformation() {
        System.out.println(String.format("Role: %s", defaultRole));
    }

    public void displayPersonInformation(Language lang) {
        System.out.println(String.format("Role: %s, language: %s", defaultRole, lang.getRepresentation()));
    }
}

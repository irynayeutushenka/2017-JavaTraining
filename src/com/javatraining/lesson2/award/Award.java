/**
 * Represents an award.
 *
 * @author Iryna_Yeutushenka
 */

package com.javatraining.lesson2.award;

import java.util.Random;

public class Award {

    static { //Static initialization block - runs once when the class is initialized;
        System.out.println("Award class is initialized - info from static initialization block");
    }

    { //Instance initialization block - runs each time you instantiate an object
        System.out.println("Award class is initialized - info from instance initialization block");
    }

    private final int value;
    private String currency;
    private float soli;

    /**
     * Creates an award with the specified value and default currency 'USD'.
     *
     * @param value - award value
     */
    public Award(int value) {
        this.value = value;
        this.currency = "USD";
    }

    /**
     * Creates an award with the specified value currency.
     *
     * @param value    - award value
     * @param currency - award currency
     */
    public Award(int value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    /**
     * Creates an award with the specified value and default currency 'USD'.     *
     * Specified soli is applied to the award.
     *
     * @param value -  award value
     * @param soli  - value of the soli
     */
    public Award(int value, float soli) {
        this.value = value;
        this.currency = "USD";
        this.soli = soli;
    }

    public int getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public float getSoli() {
        return soli;
    }

    public void setSoli(float soli) {
        this.soli = soli;
    }

}
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

    /**
     * Method to calculate quantity parameter for each award without soli of each recipients using the formula:
     * quantity = ((Z^2*(P)*(1-P))/(C^2)) / (1 + ((((Z^2*(P)*(1-P ))/(C^2))-1)/population))
     * where:
     * C = a random decimal i.e. 5% = 0.05
     * population = total count of employee's awards without soli
     * Z = a random whole number i.e. 3
     * P = award value;
     *
     * @param population - total count of employee's awards without soli
     * @return quantity parameter
     */
    public double calculateQuantity(int population) {

        Random rand = new Random();
        double c = rand.nextDouble(); // a random decimal i.e. 5% = 0.05
        int z = rand.nextInt(10) + 1; // a random whole number i.e. 3
        int power = 2; //возведение в степень 2
        double v = getValue(); //award value
        double pz = Math.pow(z, power); // (Z^2)
        double d = pz * v * (1 - v); // (Z^2*(P)*(1-P))
        double pc = Math.pow(c, power); ///(C^2)
        double m = d / pc;
        double n = (1 + (((m - 1) / population)));
        double quantity = m / n;
        System.out.println(String.format("Award Value - %s, Population - %s, Calculated Quantity - %s", getValue(), population, quantity));
        return quantity;
    }
}
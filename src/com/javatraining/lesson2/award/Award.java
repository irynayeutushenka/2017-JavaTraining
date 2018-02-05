/**
 * Represents an award.
 *
 * @author Iryna_Yeutushenka
 */

package com.javatraining.lesson2.award;

import java.util.Objects;

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
    private Enum type;
    private long id;

    /**
     * Constructor. Creates an award with the specified value and default currency 'USD'.
     *
     * @param value - award value
     */
    public Award(int value) {
        this.value = value;
        this.currency = "USD";
    }

    /**
     * Constructor. Creates an award with the specified value and currency.
     *
     * @param value    - award value
     * @param currency - award currency
     */
    public Award(int value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    /**
     * Constructor. Creates an award with the specified value and default currency 'USD'.     *
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

    /**
     * Constructor. Creates an award with the specified value, currency, type and id.
     *
     * @param value    -  award value
     * @param currency - award currency
     * @param type     - award type from the fixed list of AwardTypes
     * @param id       -  - award id
     */
    public Award(int value, String currency, Enum type, long id) {
        this.value = value;
        this.currency = currency;
        this.type = type;
        this.id = id;
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

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Award award = (Award) o;
        return value == award.value &&
                Float.compare(award.soli, soli) == 0 &&
                id == award.id &&
                Objects.equals(currency, award.currency) &&
                Objects.equals(type, award.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, currency, soli, type);
    }
}
/**
 * Nominee:
 * приватное строковое поле name, которое инициализируется из конструктора
 * публичный метод receiveAward, принимающий объект класса Award. Метод должен выводить значение аварды на консоль
 * Каждый класс должен содержать статические блоки инициализации, в которых выводится на консоль информации об инициализации класса
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
    private double nomineeAwardAmount;
    private int nomineeAwardQuantity;

    public double getNomineeAwardAmount() {
        return nomineeAwardAmount;
    }

    public void setNomineeAwardAmount(double nomineeAwardAmount) {
        this.nomineeAwardAmount = nomineeAwardAmount;
    }

    public int getNomineeAwardQuantity() {
        return nomineeAwardQuantity;
    }

    public void setNomineeAwardQuantity(int nomineeAwardQuantity) {
        this.nomineeAwardQuantity = nomineeAwardQuantity;
    }

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

    public void receiveAward(Award award) {
        if (award.getSoli() == 0.0f) {
            System.out.println(String.format("Award Details for Recipient: Award Value - %s, Award Currency - %s. No SOLI applied", award.getValue(), award.getCurrency()));
        } else if (award.getSoli() < 1.0f) {
            System.out.println(String.format("Award Details for Recipient: Award Value with SOLI - %s, Award Currency - %s, SOLI value - %s, Gone - %s.", (award.getValue() * award.getSoli()), award.getCurrency(), award.getSoli(), (100 - (award.getSoli() * 100) + "%")));
        } else if (award.getSoli() > 1.0f) {
            System.out.println(String.format("Award Details for Recipient: Award Value with SOLI - %s, Award Currency - %s, SOLI value - %s, Added - %s.", (award.getValue() * award.getSoli()), award.getCurrency(), award.getSoli(), ((award.getSoli() * 100 - 100) + "%")));
        }
    }
}
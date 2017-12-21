/**
 * Lesson 2
 * Award:
 * приватное финальное целочисленное поле value, которое инициализируется из конструктора
 * публичный геттер для поля value
 * Каждый класс должен содержать статические блоки инициализации, в которых выводится на консоль информации об инициализации класса

 * Lesson 3
 * Для каждого из 3 сотрудников, для каждой аварды без соли рассчитать по формуле
 * quantity = ((Z^2*(P)*(1-P))/(C^2)) / (1 + ((((Z^2*(P)*(1-P ))/(C^2))-1)/population))
 * <p>
 * где:
 * C = a random decimal i.e. 5% = 0.05
 * population = total count of employee's awards without soli
 * Z = a random whole number i.e. 3
 * P = award value;
 */

package com.javatraining.lesson2.award;

import com.javatraining.lesson2.nominee.Nominee;

import java.util.Random;

public class Award {

    static { //TODO Static initialization block - runs once when the class is initialized;
        System.out.println("Award class is initialized - info from static initialization block");
    }

    { //TODO Instance initialization block - runs each time you instantiate an object
        System.out.println("Award class is initialized - info from instance initialization block");
    }

    private final int value;
    private String currency;
    private double soli;

    public Award(int value) {
        this.value = value;
        this.currency = "USD";
    }

    public Award(int value, double soli) {
        this.value = value;
        this.currency = "USD";
        this.soli = soli;
    }

    public Award(int value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public int getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public double getSoli() {
        return soli;
    }

    public void setSoli(double soli) {
        this.soli = soli;
    }

    private int countPopulation(Award awardArrayPerRecipient[]) {
        int count = 0;//population = total count of employee's awards without soli;
        for (Award a : awardArrayPerRecipient) {
            if (a.getSoli() != 0.0f) {
                count++;
            }
        }
        return count;
    }

    public void calculateQuantity(Nominee nominee, Award[] awardArrayPerRecipients) {

        Random rand1 = new Random();
        double c = (rand1.nextInt(21) - 10) / 10.0; // a random decimal i.e. 5% = 0.05

        Random rand2 = new Random();
        int z = rand2.nextInt(40) + 1; // a random whole number i.e. 3

        int power = 2; //возведение в степень 2

        for (Award a : awardArrayPerRecipients) {

            double population = a.countPopulation(awardArrayPerRecipients);

            double v = a.getValue(); //award value
            double m = (Math.pow(z, power) * v * (1 - v)) / Math.pow(c, power); //(Z^2*(P)*(1-P))/(C^2)

            double quantity = m /  (1 + (((m-1)/population)));
            System.out.println(String.format("Recipient: %s, Award Value - %s, Population - %s, Calculated Quantity - %s", nominee.getName(), a.getValue(), population, quantity));
        }
    }
}


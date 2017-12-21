/**
 * Nominator:
 * приватное строковое поле name, которое инициализируется из конструктора
 * публичный метод nominate, принимающий объекты классов Nominee и Award.
 * Метод должен выводить на консоль кому и какого размера выдана аварда
 */

package com.javatraining.lesson2.nominator;

        import com.javatraining.lesson2.award.Award;
        import com.javatraining.lesson2.nominee.Nominee;


public class Nominator {

    static {
        System.out.println("Nominator class is initialized - info from static initialization block");
    }

    private String name;

    public Nominator() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void nominate(Award award, Nominee[] nominees) {
        for (Nominee n : nominees) {
            n.receiveAward(award);
            System.out.println(String.format("Award details for Nominator: Award value - %s, Award Currency - %s, Nominee - %s", award.getValue(), award.getCurrency(), n.getName()));
        }
    }
}
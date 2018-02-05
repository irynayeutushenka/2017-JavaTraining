/**
 * Represents a nominator of the award.
 *
 * @author Iryna_Yeutushenka
 */

package com.javatraining.lesson2.nominator;

import com.javatraining.lesson2.award.Award;
import com.javatraining.lesson2.nominee.Nominee;
import com.javatraining.lesson2.person.Person;
import com.javatraining.lesson2.person.Role;

public class Nominator extends Person {

    private static Role nominatorRole;

    static {
        nominatorRole = Role.NOMINATOR;
        System.out.println("Nominator class is initialized - info from static initialization block");
    }

    /**
     * Nominator constructor without parameters
     */
    public Nominator() {
    }

    /**
     * Nominator constructor with name parameter
     *
     * @param name - user name
     */
    public Nominator(String name) {
        super(name);
    }

    /**
     * Method that provides information about user recipient role and his name
     */
    @Override
    public void displayPersonInformation() {
        String returnName = "unknown";
        if (getName() != null) {
            returnName = getName();
        }
        System.out.println(String.format("Role: %s, name: %s", nominatorRole, returnName));
    }

    /**
     * Method that provides additional information about nominator
     */
    public void infoNominator() {
        System.out.println("I'm a nominator and I proud of it");
    }

    /**
     * Method creates nomination for one nominee and provides information about it's values
     *
     * @param nominee - the award recipient
     * @param award   - chosen award for nomination
     */
    public void nominate(Nominee nominee, Award award) {
        nominee.receiveAward(award);
        System.out.println(String.format("Award details for %s: Award value - %s, Award Currency - %s, Nominee - %s",
                nominatorRole, award.getValue(), award.getCurrency(), nominee.getName()));
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
            System.out.println(String.format("Award details for %s: Award value - %s, Award Currency - %s, Nominee - %s",
                    nominatorRole, award.getValue(), award.getCurrency(), n.getName()));
        }
    }

    /**
     * Method creates several nominations for one nominee and provides information about it's values
     *
     * @param nominee   - the award recipient
     * @param awardList - list of the awards
     */
    public void nominate(Nominee nominee, Award[] awardList) {
        for (Award award : awardList) {
            nominee.receiveAward(award);
            System.out.println(String.format("Award details for %s: Award value - %s, Award Currency - %s, Nominee - %s",
                    nominatorRole, award.getValue(), award.getCurrency(), nominee.getName()));
        }
    }
}
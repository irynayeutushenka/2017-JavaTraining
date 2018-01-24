/**
 * Represents a recipient of the award.
 *
 * @author Iryna_Yeutushenka
 */


package com.javatraining.lesson2.nominee;

import com.javatraining.lesson2.award.Award;
import com.javatraining.lesson2.person.Person;
import com.javatraining.lesson2.person.Role;

public class Nominee extends Person {

    private static Role recipientRole;

    {
        System.out.println("Nominee class is initialized - info from instance initialization block");
    }

    static {
        recipientRole = Role.RECIPIENT;
        System.out.println("Nominee class is initialized - info from static initialization block");
    }

    public Nominee(String name) {
        super(name);
    }

    /**
     * Method that returns information about user recipient role and his name
     */
    @Override
    public void displayPersonInformation() {
        String returnName = "unknown";
        if (getName() != null) {
            returnName = getName();
        }
        System.out.println(String.format("Role: %s, name: %s", recipientRole, returnName));
    }

    /**
     * Additional information about recipient
     */
    public void infoRecipient(){
        System.out.println("I'm a recipient and I proud of it");
    }

    /**
     * Method provides information about award to be received by the recipient and applied soli.
     *
     * @param award - chosen award for nomination
     */
    public void receiveAward(Award award) {
        float awardValueWithSoli = award.getValue() * award.getSoli();
        if (award.getSoli() == 0.0f) {
            System.out.println(String.format("Award Details for %s: Award Value - %s, Award Currency - %s. No SOLI applied",
                    recipientRole, award.getValue(), award.getCurrency()));
        } else if (award.getSoli() < 1.0f) {
            System.out.println(String.format("Award Details for %s: Award Value with SOLI - %s, Award Currency - %s, SOLI value - %s, Gone - %s.",
                    recipientRole, awardValueWithSoli, award.getCurrency(), award.getSoli(), (100 - (award.getSoli() * 100) + "%")));
        } else if (award.getSoli() > 1.0f) {
            System.out.println(String.format("Award Details for %s: Award Value with SOLI - %s, Award Currency - %s, SOLI value - %s, Added - %s.",
                    recipientRole, awardValueWithSoli, award.getCurrency(), award.getSoli(), ((award.getSoli() * 100 - 100) + "%")));
        } else {
            System.out.println(String.format("Award Details for %s: Award Value with SOLI - %s, Award Currency - %s, SOLI value - %s, Award value hasn't changed.",
                    recipientRole, awardValueWithSoli, award.getCurrency(), award.getSoli()));
        }
    }
}
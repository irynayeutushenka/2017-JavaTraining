/**
 * Helper to display information about bulk of users
 *
 * @author Iryna_Yeutushenka
 */

package com.javatraining.lesson2.utils;

import com.javatraining.lesson2.nominator.Nominator;
import com.javatraining.lesson2.nominee.Nominee;
import com.javatraining.lesson2.person.Person;

import java.util.List;

public class DisplayUserInfoHelper {


    /**
     * Method to display information about bulk of users
     *
     * @param personList list of person
     */
    public static void displayUserInfo(List<Person> personList) {
        for (Person p : personList) {
            p.displayPersonInformation();
            if (p instanceof Nominator){
                Nominator n = (Nominator) p;
                n.infoNominator();
            }
            else if (p instanceof Nominee){
                Nominee n = (Nominee) p;
                n.infoRecipient();
            }
            else {
                System.out.println("Who I am?");
            }
        }
    }
}

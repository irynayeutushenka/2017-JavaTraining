/**
 * Runner for creation nominations and calculations of soli Quantity
 *
 * @author Iryna_Yeutushenka
 */

package com.javatraining.lesson2;

import com.javatraining.lesson2.award.Award;
import com.javatraining.lesson2.language.Language;
import com.javatraining.lesson2.nominator.Nominator;
import com.javatraining.lesson2.nominee.Nominee;
import com.javatraining.lesson2.person.Person;
import com.javatraining.lesson2.utils.DisplayUserInfoHelper;
import com.javatraining.lesson2.utils.NominationHelper;

import java.util.ArrayList;

public class NominationCreationAndQuantityCalculation {
    public static void main(String[] args) {

        Award award1 = new Award(100); //award with default currency without SOLI
        Award award2 = new Award(100, "EUR"); //award with specified currency without SOLI
        Award award3 = new Award(50, 5); //award without SOLI
        Award award4 = new Award(500, 0.7f); //award with default currency with SOLI for 2 recipients
        Award award5 = new Award(200, 1.2f); //award with default currency with SOLI
        Award award6 = new Award(500, 10f); //award with default currency with SOLI

        Nominee nominee1 = new Nominee("Pete");
        nominee1.displayPersonInformation();
        nominee1.displayPersonInformation(Language.ENGLISH);
        Nominee nominee2 = new Nominee("Mike");
        nominee2.displayPersonInformation();
        Nominee nominee3 = new Nominee("Adam");
        nominee3.displayPersonInformation();

        Nominee[] nomineesArray1 = new Nominee[]{nominee1}; //awards 1 and 4 (1 with SOLI)
        Nominee[] nomineesArray2 = new Nominee[]{nominee2}; //awards 2 and 4 (1 with SOLI)
        Nominee[] nomineesArray3 = new Nominee[]{nominee3}; //awards 3 and 6 (2 with SOLI)
        Nominee[] nomineesArray4 = new Nominee[]{nominee1, nominee2};
        Nominee[] nomineesArray5 = new Nominee[]{new Nominee("John"), new Nominee("Dave")};

        Nominator nominator1 = new Nominator("Alan");
        nominator1.displayPersonInformation();

        Nominator nominator2 = new Nominator();
        nominator2.displayPersonInformation();

        Person nominee4 = new Nominee("Bob");
        Person nominator3 = new Nominator("David");
        nominee4.displayPersonInformation();
        nominator3.displayPersonInformation();

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(nominator1);
        personList.add(nominee1);
        DisplayUserInfoHelper.displayUserInfo(personList);


        nominator1.nominate(nomineesArray1, award1);
        nominator1.nominate(nomineesArray2, award2);
        nominator1.nominate(nomineesArray3, award3);
        nominator1.nominate(nomineesArray4, award4);
        nominator1.nominate(nomineesArray5, award5);
        nominator1.nominate(nomineesArray5, award6);

        Award[] awardArrayPerRecipient1 = new Award[]{award1, award4};
        Award[] awardArrayPerRecipient2 = new Award[]{award2, award4};
        Award[] awardArrayPerRecipient3 = new Award[]{award3, award6};

        int populationForRecipient1 = NominationHelper.countPopulation(awardArrayPerRecipient1);
        double quantityAward1Recipient1 = NominationHelper.calculateQuantity(award1, populationForRecipient1);
        double quantityAward4Recipient1 = NominationHelper.calculateQuantity(award4, populationForRecipient1);

        int populationForRecipient2 = NominationHelper.countPopulation(awardArrayPerRecipient2);
        double quantityAward2Recipient2 = NominationHelper.calculateQuantity(award2, populationForRecipient2);
        double quantityAward4Recipient2 = NominationHelper.calculateQuantity(award4, populationForRecipient2);

        int populationForRecipient3 = NominationHelper.countPopulation(awardArrayPerRecipient3);
        double quantityAward3Recipient3 = NominationHelper.calculateQuantity(award3, populationForRecipient3);
        double quantityAward6Recipient3 = NominationHelper.calculateQuantity(award6, populationForRecipient3);


        /**
         * Comparison of quantities of the awards for the same recipient
         */
        if (quantityAward1Recipient1 > quantityAward4Recipient1) {
            System.out.println(String.format("Quantity of award1 of the Recipient 1 (%s) is greater than quantity of award4 of the Recipient 1 (%s)",
                    quantityAward1Recipient1, quantityAward4Recipient1));
        } else if (quantityAward1Recipient1 < quantityAward4Recipient1) {
            System.out.println(String.format("Quantity of award1 of the Recipient 1 (%s) is less than quantity of award4 of the Recipient 1 (%s)",
                    quantityAward1Recipient1, quantityAward4Recipient1));
        } else if (quantityAward1Recipient1 == quantityAward4Recipient1) {
            System.out.println(String.format("Quantity of award1 of the Recipient 1 (%s) is equal to quantity of award4 of the Recipient 1 (%s)",
                    quantityAward1Recipient1, quantityAward4Recipient1));
        }

        /**
         * Comparison of quantities of the awards for the different recipients
         */
        if (quantityAward2Recipient2 >= quantityAward3Recipient3) {
            System.out.println(String.format("Quantity of award2 of the Recipient 2 (%s) is greater or equal than quantity of award3 of the Recipient 3 (%s)",
                    quantityAward2Recipient2, quantityAward3Recipient3));
        } else if (quantityAward2Recipient2 <= quantityAward3Recipient3) {
            System.out.println(String.format("Quantity of award2 of the Recipient 2 (%s) is less or equal than quantity of award3 of the Recipient 3 (%s)",
                    quantityAward2Recipient2, quantityAward3Recipient3));
        } else if (quantityAward2Recipient2 != quantityAward3Recipient3) {
            System.out.println(String.format("Quantity of award2 of the Recipient 2 (%s) is not equal than quantity of award3 of the Recipient 3 (%s)",
                    quantityAward2Recipient2, quantityAward3Recipient3));
        }

        /**
         * Comparison of quantities of the awards for the different recipients
         */
        if ((quantityAward1Recipient1 == quantityAward4Recipient2) && (quantityAward1Recipient1 == quantityAward3Recipient3)) {
            System.out.println(String.format("Quantity of award1 of the Recipient 1 (%s), quantity of the award4 of the Recipient 2 (%s) and quantity of the award3 of the Recipient 3 (%s) are equal",
                    quantityAward1Recipient1, quantityAward4Recipient2, quantityAward3Recipient3));
        } else if ((quantityAward1Recipient1 == quantityAward4Recipient2) || (quantityAward1Recipient1 == quantityAward3Recipient3)) {
            System.out.println(String.format("Quantity of award1 of the Recipient 1 (%s) is equal to quantity of award4 of the Recipient 2 (%s) or to quantity of the award3 of the Recipient 3 (%s)",
                    quantityAward1Recipient1, quantityAward4Recipient2, quantityAward3Recipient3));
        }
    }
}

/**
 * Runner for creation nominations and calculations of soli Quantity
 *
 * @author Iryna_Yeutushenka
 */

package com.javatraining.lesson2;

import com.javatraining.lesson2.award.Award;
import com.javatraining.lesson2.nominator.Nominator;
import com.javatraining.lesson2.nominee.Nominee;

public class NominationCreation {
    public static void main(String[] args) {

        Award award1 = new Award(100); //award with default currency without SOLI
        Award award2 = new Award(100, "EUR"); //award with specified currency without SOLI
        Award award3 = new Award(50, 5); //award without SOLI
        Award award4 = new Award(500, 0.7f); //award with default currency with SOLI for 2 recipients
        Award award5 = new Award(200, 1.2f); //award with default currency with SOLI
        Award award6 = new Award(500, 10f); //award with default currency with SOLI


        Nominee nominee1 = new Nominee("Pete");
        Nominee nominee2 = new Nominee("Mike");
        Nominee nominee3 = new Nominee("Adam");

        Nominee[] nomineesArray1 = new Nominee[]{nominee1}; //awards 1 and 4 (1 with SOLI)
        Nominee[] nomineesArray2 = new Nominee[]{nominee2}; //awards 2 and 4 (1 with SOLI)
        Nominee[] nomineesArray3 = new Nominee[]{nominee3}; //awards 3 and 6 (2 with SOLI)
        Nominee[] nomineesArray4 = new Nominee[]{nominee1, nominee2};
        Nominee[] nomineesArray5 = new Nominee[]{new Nominee("John"), new Nominee("Dave")};

        Nominator nominator1 = new Nominator();
        nominator1.setName("Alan");

        nominator1.nominate(award1, nomineesArray1);
        nominator1.nominate(award2, nomineesArray2);
        nominator1.nominate(award3, nomineesArray3);
        nominator1.nominate(award4, nomineesArray4);
        nominator1.nominate(award5, nomineesArray5);
        nominator1.nominate(award6, nomineesArray5);

        Award[] awardArrayPerRecipient1 = new Award[]{award1, award4};
        Award[] awardArrayPerRecipient2 = new Award[]{award2, award4};
        Award[] awardArrayPerRecipient3 = new Award[]{award3, award6};


        int populationForRecipient1 = countPopulation(awardArrayPerRecipient1);
        double quantity1 = award1.calculateQuantity(populationForRecipient1);
        double quantity2 = award4.calculateQuantity(populationForRecipient1);

        int populationForRecipient2 = countPopulation(awardArrayPerRecipient2);
        double quantity3 = award2.calculateQuantity(populationForRecipient2);
        double quantity4 = award4.calculateQuantity(populationForRecipient2);

        int populationForRecipient3 = countPopulation(awardArrayPerRecipient3);
        double quantity5 = award3.calculateQuantity(populationForRecipient3);
        double quantity6 = award6.calculateQuantity(populationForRecipient3);


        /**
         * Comparison of quantities of the awards for the same recipient
         */
        if (quantity1 > quantity2) {
            System.out.println(String.format("Quantity of award1 of the Recipient 1 (%s) is greater than quantity of award4 of the Recipient 1 (%s)", quantity1, quantity2));
        } else if (quantity1 < quantity2) {
            System.out.println(String.format("Quantity of award1 of the Recipient 1 (%s) is less than quantity of award4 of the Recipient 1 (%s)", quantity1, quantity2));
        } else if (quantity1 == quantity2) {
            System.out.println(String.format("Quantity of award1 of the Recipient 1 (%s) is equal to quantity of award4 of the Recipient 1 (%s)", quantity1, quantity2));
        }

        /**
         * Comparison of quantities of the awards for the different recipients
         */
        if (quantity3 >= quantity5) {
            System.out.println(String.format("Quantity of award2 of the Recipient 2 (%s) is greater or equal than quantity of award3 of the Recipient 3 (%s)", quantity3, quantity5));
        } else if (quantity3 <= quantity5) {
            System.out.println(String.format("Quantity of award2 of the Recipient 2 (%s) is less or equal than quantity of award3 of the Recipient 3 (%s)", quantity3, quantity5));
        }else if (quantity3 != quantity5) {
            System.out.println(String.format("Quantity of award2 of the Recipient 2 (%s) is not equal than quantity of award3 of the Recipient 3 (%s)", quantity3, quantity5));
        }

        /**
         * Comparison of quantities of the awards for the different recipients
         */
        if ((quantity1 == quantity4) && (quantity1 == quantity5)) {
            System.out.println(String.format("Quantity of award1 of the Recipient 1 (%s), quantity of the award4 of the Recipient 2 (%s) and quantity of the award3 of the Recipient 3 (%s) are equal", quantity1, quantity4, quantity5));
        } else if ((quantity1 == quantity4) || (quantity1 == quantity5)) {
            System.out.println(String.format("Quantity of award1 of the Recipient 1 (%s) is equal to quantity of award4 of the Recipient 2 (%s) or to quantity of the award3 of the Recipient 3 (%s)", quantity1, quantity4, quantity5));
        }

    }

    /**
     * Method to calculate population to be used in calculateQuantity method
     *
     * @param awardArrayPerRecipient - list of awards received by the recipient
     * @return population - total count of employee's awards without soli
     */
    private static int countPopulation(Award awardArrayPerRecipient[]) {
        int count = 0;
        for (Award a : awardArrayPerRecipient) {
            if (a.getSoli() != 0.0f) {
                count++;
            }
        }
        return count;
    }
        }

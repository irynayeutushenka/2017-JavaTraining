/**
 * Calculates limits and provides a decision whether to create an award
 *
 * @author Iryna_Yeutushenka
 */

package com.javatraining.lesson2.award;

import com.javatraining.lesson2.nominator.Nominator;
import com.javatraining.lesson2.nominee.Nominee;

public class LimitCalculation {

    /**
     * Nominator дает авадру Nominee пока не достигнет nominatorAwardQuantityLimit
     * IF - ELSE; FOR
     *
     * @param award         - chosen award for nomination
     * @param nominator     - nominator of the award
     * @param nomineesArray - list of the award recipients
     */
    public static void useNominatorAwardQuantityLimit(Award award, Nominator nominator, Nominee[] nomineesArray) {
        int nominatorAwardQuantity = 0;
        String NominatorAwardQuantityLimit = "NominatorAwardQuantityLimit";
        for (int i = 0; i < 100; i++) {
            if (nominatorAwardQuantity < nominator.getNominatorAwardQuantityLimit()) {
                nominator.nominate(award, nomineesArray);
                nominatorAwardQuantity++;
                System.out.println("Nomination created " + (nominatorAwardQuantity));
            } else {
                limitMessage(NominatorAwardQuantityLimit);
                break;
            }
        }
    }

    /**
     * Nominator дает авадру Nominee пока не достигнет nominatorAwardAmountLimit
     * WHILE
     *
     * @param award         - chosen award for nomination
     * @param nominator     - nominator of the award
     * @param nomineesArray - list of the award recipients
     */
    public static void useNominatorAwardAmountLimit(Award award, Nominator nominator, Nominee[] nomineesArray) {
        int nominatorAmount = 0;
        String NominatorAwardAmountLimit = "NominatorAwardAmountLimit";
        while (nominatorAmount + award.getValue() < nominator.getNominatorAwardAmountLimit()) {
            nominator.nominate(award, nomineesArray);
            nominatorAmount = nominatorAmount + award.getValue();
            System.out.println("Nomination created");
        }
        limitMessage(NominatorAwardAmountLimit);
    }

    /**
     * Nominator дает авадру Nominee пока не достигнет nomineeAwardQuantityLimit
     * DO - WHILE
     *
     * @param award         - chosen award for nomination
     * @param nominator     - nominator of the award
     * @param nomineesArray - list of the award recipients
     */
    public static void useNomineeAwardQuantityLimit(Award award, Nominator nominator, Nominee[] nomineesArray) {
        String NomineeAwardQuantityLimit = "NomineeAwardQuantityLimit";
        for (Nominee nominee : nomineesArray) {
            int count = 0;
            do {
                count++;
                nominator.nominate(award, nomineesArray);
                System.out.println("Nomination created " + count);
            } while (count < nominee.getNomineeAwardQuantityLimit());
            limitMessage(NomineeAwardQuantityLimit);
        }
    }

    /**
     * Nominator дает авадру Nominee пока не достигнет nomineeAwardAmountLimit
     * IF - IF, FOR
     *
     * @param award         - chosen award for nomination
     * @param nominator     - nominator of the award
     * @param nomineesArray - list of the award recipients
     */
    public static void useNomineeAwardAmountLimit(Award award, Nominator nominator, Nominee[] nomineesArray) {
        String NomineeAwardAmountLimit = "NomineeAwardAmountLimit";
        for (Nominee nominee : nomineesArray) {
            int nomineeAmount = 0;
            for (int i = 0; i < 100; i++) {
                if (nomineeAmount + award.getValue() <= nominee.getNomineeAwardAmountLimit()) {
                    nominator.nominate(award, nomineesArray);
                    System.out.println("Nomination created " + (i + 1));
                    nomineeAmount += award.getValue();
                }
                if (nomineeAmount > nominee.getNomineeAwardAmountLimit()) {
                    break;
                }
            }
            limitMessage(NomineeAwardAmountLimit);
        }
    }

    /**
     * Returns appropriate message on limit reaching
     *
     * @param limitString - string specifying the limit type
     */
    private static void limitMessage(String limitString) {
        switch (limitString) {
            case "NominatorAwardQuantityLimit":
                System.out.println("Award Quantity Limit for Nominator is reached" + "\n");
                break;
            case "NominatorAwardAmountLimit":
                System.out.println("Award Amount Limit for Nominator is reached" + "\n");
                break;
            case "NomineeAwardQuantityLimit":
                System.out.println("Award Quantity Limit for Recipient is reached" + "\n");
                break;
            case "NomineeAwardAmountLimit":
                System.out.println("Award Amount Limit for Recipient is reached" + "\n");
                break;
            default:
                System.out.println("Unknown Limit" + "\n");
                break;
        }
    }

    /**
     * Starting point for the All Limits check process
     *
     * @param award         - chosen award for nomination
     * @param nominator     - nominator of the award
     * @param nomineesArray - list of the award recipients
     */
    public static void checkAllLimits(Award award, Nominator nominator, Nominee[] nomineesArray) {
        checkNominatorAwardAmountLimit(award, nominator, nomineesArray);
    }

    /**
     * Part of checkAllLimits method
     * Checks if Award amount limit is reached for the nominator
     * if yes - moves to the checkNominatorAwardQuantityLimit method
     * if no - provides an information about limit     *
     *
     * @param award         - chosen award for nomination
     * @param nominator     - nominator of the award
     * @param nomineesArray - list of the award recipients
     */
    private static void checkNominatorAwardAmountLimit(Award award, Nominator nominator, Nominee[] nomineesArray) {
        double nominatorAmount = nominator.getNominatorGivenAwardAmount() + award.getValue();
        if (nominatorAmount <= nominator.getNominatorAwardAmountLimit()) {
            checkNominatorAwardQuantityLimit(award, nominator, nomineesArray);
        } else {
            System.out.println(String.format("AwardAmountLimit for nominator is reached, Award Amount Received by Nominator - %s" + "\n", nominator.getNominatorGivenAwardAmount()));
        }
    }

    /**
     * Part of checkAllLimits method
     * Checks if Award quantity limit is reached for the nominator
     * if yes - moves to the checkNomineeAwardAmountLimit method
     * if no - provides an information about limit     *
     *
     * @param award         - chosen award for nomination
     * @param nominator     - nominator of the award
     * @param nomineesArray - list of the award recipients
     */
    private static void checkNominatorAwardQuantityLimit(Award award, Nominator nominator, Nominee[] nomineesArray) {
        int nominatorAwardQuantity = nominator.getNominatorGivenAwardQuantity() + 1;
        if (nominatorAwardQuantity <= nominator.getNominatorAwardQuantityLimit()) {
            checkNomineeAwardAmountLimit(award, nominator, nomineesArray);
        } else {
            System.out.println(String.format("AwardQuantityLimit for nominator is reached, Award Quantity Received by Nominator - %s" + "\n", nominator.getNominatorGivenAwardQuantity()));
        }
    }


    /**
     * Part of checkAllLimits method
     * Checks if Award amount limit is reached for the recipient
     * if yes - moves to the checkNomineeAwardQuantityLimit method
     * if no - provides an information about limit     *
     *
     * @param award         - chosen award for nomination
     * @param nominator     - nominator of the award
     * @param nomineesArray - list of the award recipients
     */
    private static void checkNomineeAwardAmountLimit(Award award, Nominator nominator, Nominee[] nomineesArray) {
        for (Nominee nominee : nomineesArray) {
            double nomineeAmount = nominee.getNomineeReceivedAwardAmount() + award.getValue();
            if (nomineeAmount <= nominee.getNomineeAwardAmountLimit()) {
                checkNomineeAwardQuantityLimit(award, nominator, nomineesArray);
            } else {
                System.out.println(String.format("AwardAmountLimit for recipient is reached, Award Amount Received by Recipient - %s" + "\n", nominee.getNomineeReceivedAwardAmount()));
            }
        }
    }

    /**
     * Part of checkAllLimits method
     * Checks if Award quantity limit is reached for the recipient
     * if yes - creates an award, updates information about received and provided awards for recipient and nominator
     * if no - provides an information about limit     *
     *
     * @param award         - chosen award for nomination
     * @param nominator     - nominator of the award
     * @param nomineesArray - list of the award recipients
     */
    private static void checkNomineeAwardQuantityLimit(Award award, Nominator nominator, Nominee[] nomineesArray) {
        for (Nominee nominee : nomineesArray) {
            int nomineeAwardQuantity = nominee.getNomineeReceivedAwardQuantity() + 1;
            if ((nomineeAwardQuantity) <= nominee.getNomineeAwardQuantityLimit()) {
                nominator.nominate(award, nomineesArray);
                nominator.setNominatorGivenAwardAmount(nominator.getNominatorGivenAwardAmount() + award.getValue());
                nominator.setNominatorGivenAwardQuantity(nominator.getNominatorGivenAwardQuantity() + 1);
                nominee.setNomineeReceivedAwardAmount(nominee.getNomineeReceivedAwardAmount() + award.getValue());
                nominee.setNomineeReceivedAwardQuantity(nominee.getNomineeReceivedAwardQuantity() + 1);
                System.out.println(String.format("Nominator AwardAmount - %s, AwardQuantity - %s; Recipient AwardAmount - %s, Recipient AwardQuantity - %s" + "\n",
                        nominator.getNominatorGivenAwardAmount(), nominator.getNominatorGivenAwardQuantity(), nominee.getNomineeReceivedAwardAmount(), nominee.getNomineeReceivedAwardQuantity()));
            } else {
                System.out.println(String.format("AwardQuantityLimit for recipient is reached, Award Quantity Received by Recipient - %s" + "\n", nominee.getNomineeReceivedAwardQuantity()));
            }
        }
    }
}
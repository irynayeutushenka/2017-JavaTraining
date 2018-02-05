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
     * Fixed list of award limit types
     */
    private enum LimitType {
        NOMINATOR_AWARD_QUANTITY_LIMIT,
        NOMINATOR_AWARD_AMOUNT_LIMIT,
        NOMINEE_AWARD_QUANTITY_LIMIT,
        NOMINEE_AWARD_AMOUNT_LIMIT
    }

    /**
     * Nominator дает авадру Nominee пока не достигнет nominatorAwardQuantityLimit
     * Method checks if limit to be reached after chosen award is given:
     * if not a new award is created,
     * if yes - the corresponding message is displayed
     * IF - ELSE; FOR
     *
     * @param nominator     - nominator of the award
     * @param award         - chosen award for nomination
     * @param nomineesArray - list of the award recipients
     */
    public static void useNominatorAwardQuantityLimit(Nominator nominator, Award award, Nominee[] nomineesArray) {
        int maxAllowedAwardQuantity = 100;
        for (int i = 0; i < maxAllowedAwardQuantity; i++) {
            int futureQuantity = nominator.getCurrentAwardQuantity() + 1;
            if (!nominator.isAwardQuantityLimitReached(futureQuantity, nominator.getAwardQuantityLimit())) {
                nominator.nominate(nomineesArray, award);
                nominator.setCurrentAwardQuantity(nominator.getCurrentAwardQuantity() + 1);
                System.out.println(String.format("Total amount of given nominations - %s", nominator.getCurrentAwardQuantity()));
            } else {
                limitMessage(LimitType.NOMINATOR_AWARD_QUANTITY_LIMIT);
                break;
            }
        }
    }

    /**
     * Nominator дает авадру Nominee пока не достигнет nominatorAwardAmountLimit
     * Method checks if limit to be reached after chosen award is given:
     * if not a new award is created,
     * if yes - the corresponding message is displayed
     * WHILE
     *
     * @param nominator     - nominator of the award
     * @param award         - chosen award for nomination
     * @param nomineesArray - list of the award recipients
     */
    public static void useNominatorAwardAmountLimit(Nominator nominator, Award award, Nominee[] nomineesArray) {
        while (!nominator.isAwardAmountLimitReached(nominator.getCurrentAwardAmount() + award.getValue(), nominator.getAwardAmountLimit())) {
            nominator.nominate(nomineesArray, award);
            nominator.setCurrentAwardAmount(nominator.getCurrentAwardAmount() + award.getValue());
            System.out.println(String.format("Total value of given nominations - %s", nominator.getCurrentAwardAmount()));
        }
        limitMessage(LimitType.NOMINATOR_AWARD_AMOUNT_LIMIT);
    }

    /**
     * Nominator дает авадру Nominee пока не достигнет nomineeAwardQuantityLimit
     * Method checks if limit to be reached after chosen award is given:
     * if not a new award is created,
     * if yes - the corresponding message is displayed
     * *
     *
     * @param nominee    - award recipient
     * @param awardsList - chosen award for nomination
     * @param nominator  - nominator of the award
     */
    public static void useNomineeAwardQuantityLimit(Nominee nominee, Award[] awardsList, Nominator nominator) {
        for (int i = 0; i < awardsList.length; i++) {
            int futureQuantity = nominee.getCurrentAwardQuantity() + 1;
            if (!nominee.isAwardQuantityLimitReached(futureQuantity, nominee.getAwardQuantityLimit())) {
                nominator.nominate(nominee, awardsList[i]);
                nominee.setCurrentAwardQuantity(nominee.getCurrentAwardQuantity() + 1);
                System.out.println(String.format("Total amount of received nominations - %s", nominee.getCurrentAwardQuantity()));
            } else {
                limitMessage(LimitType.NOMINEE_AWARD_QUANTITY_LIMIT);
                break;
            }
        }
    }

    /**
     * Nominator дает авадру Nominee пока не достигнет nomineeAwardAmountLimit
     * Method checks if limit to be reached after chosen award is given:
     * if not a new award is created,
     * if yes - the corresponding message is displayed
     * IF - ELSE, FOREACH
     *
     * @param nominee   - award recipient
     * @param awardList - chosen award for nomination
     * @param nominator - nominator of the award
     */
    public static void useNomineeAwardAmountLimit(Nominee nominee, Award[] awardList, Nominator nominator) {
        for (Award award : awardList) {
            double futureAmount = nominee.getCurrentAwardAmount() + award.getValue();
            if (!nominee.isAwardAmountLimitReached(futureAmount, nominee.getAwardAmountLimit())) {
                nominator.nominate(nominee, award);
                nominee.setCurrentAwardAmount(nominee.getCurrentAwardAmount() + award.getValue());
                System.out.println(String.format("Total value of received nominations - %s", nominee.getCurrentAwardAmount()));
            } else {
                limitMessage(LimitType.NOMINEE_AWARD_AMOUNT_LIMIT);
                break;
            }
        }
    }

    /**
     * Returns appropriate message on specific limit type reaching
     *
     * @param limit type of limit
     */
    private static void limitMessage(LimitType limit) {
        switch (limit) {
            case NOMINATOR_AWARD_QUANTITY_LIMIT:
                System.out.println("Award Quantity Limit for Nominator is reached");
                break;
            case NOMINATOR_AWARD_AMOUNT_LIMIT:
                System.out.println("Award Amount Limit for Nominator is reached");
                break;
            case NOMINEE_AWARD_QUANTITY_LIMIT:
                System.out.println("Award Quantity Limit for Recipient is reached");
                break;
            case NOMINEE_AWARD_AMOUNT_LIMIT:
                System.out.println("Award Amount Limit for Recipient is reached");
                break;
            default:
                System.out.println("Unknown Limit");
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
        double nominatorAmount = nominator.getCurrentAwardAmount() + award.getValue();
        if (nominatorAmount <= nominator.getAwardAmountLimit()) {
            checkNominatorAwardQuantityLimit(award, nominator, nomineesArray);
        } else {
            System.out.println(String.format("AwardAmountLimit for nominator is reached, Award Amount Received by Nominator - %s",
                    nominator.getCurrentAwardAmount()));
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
        int nominatorAwardQuantity = nominator.getCurrentAwardQuantity() + 1;
        if (nominatorAwardQuantity <= nominator.getAwardQuantityLimit()) {
            checkNomineeAwardAmountLimit(award, nominator, nomineesArray);
        } else {
            System.out.println(String.format("AwardQuantityLimit for nominator is reached, Award Quantity Received by Nominator - %s",
                    nominator.getCurrentAwardQuantity()));
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
            double nomineeAmount = nominee.getCurrentAwardAmount() + award.getValue();
            if (nomineeAmount <= nominee.getAwardAmountLimit()) {
                checkNomineeAwardQuantityLimit(award, nominator, nomineesArray);
            } else {
                System.out.println(String.format("AwardAmountLimit for recipient is reached, Award Amount Received by Recipient - %s",
                        nominee.getCurrentAwardAmount()));
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
            int nomineeAwardQuantity = nominee.getCurrentAwardQuantity() + 1;
            if ((nomineeAwardQuantity) <= nominee.getAwardQuantityLimit()) {
                nominator.nominate(nomineesArray, award);
                nominator.setCurrentAwardAmount(nominator.getCurrentAwardAmount() + award.getValue());
                nominator.setCurrentAwardQuantity(nominator.getCurrentAwardQuantity() + 1);
                nominee.setCurrentAwardAmount(nominee.getCurrentAwardAmount() + award.getValue());
                nominee.setCurrentAwardQuantity(nominee.getCurrentAwardQuantity() + 1);
                System.out.println(String.format("Nominator AwardAmount - %s, AwardQuantity - %s; Recipient AwardAmount - %s, Recipient AwardQuantity - %s",
                        nominator.getCurrentAwardAmount(), nominator.getCurrentAwardQuantity(),
                        nominee.getCurrentAwardAmount(), nominee.getCurrentAwardQuantity()));
            } else {
                System.out.println(String.format("AwardQuantityLimit for recipient is reached, Award Quantity Received by Recipient - %s",
                        nominee.getCurrentAwardQuantity()));
            }
        }
    }
}
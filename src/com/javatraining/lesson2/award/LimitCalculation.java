/**
 * Calculates limits and provides a decision whether to create an award
 *
 * @author Iryna_Yeutushenka
 */

package com.javatraining.lesson2.award;

import com.javatraining.lesson2.nominator.Nominator;
import com.javatraining.lesson2.nominee.Nominee;

public class LimitCalculation {

    public enum LimitType {
        NOMINATOR_AWARD_QUANTITY_LIMIT,
        NOMINATOR_AWARD_AMOUNT_LIMIT,
        NOMINEE_AWARD_QUANTITY_LIMIT,
        NOMINEE_AWARD_AMOUNT_LIMIT
    }

    /**
     * Nominator дает авадру Nominee пока не достигнет nominatorAwardQuantityLimit
     * IF - ELSE; FOR
     *
     * @param nominator     - nominator of the award
     * @param award         - chosen award for nomination
     * @param nomineesArray - list of the award recipients
     */
    public static void useNominatorAwardQuantityLimit(Nominator nominator, Award award, Nominee[] nomineesArray) {
        int nominatorAwardQuantity = 0;
        int maxAllowedAwardQuantity = 100;
        for (int i = 0; i < maxAllowedAwardQuantity; i++) {
            if (nominatorAwardQuantity + 1 <= nominator.getNominatorAwardQuantityLimit()) {
                nominator.nominate(nomineesArray, award);
                nominatorAwardQuantity++;
                System.out.println(String.format("Total amount of given nominations - %s", nominatorAwardQuantity));
            } else {
                LimitType limitType = LimitType.NOMINATOR_AWARD_QUANTITY_LIMIT;
                limitMessage(limitType);
                break;
            }
        }
    }

    /**
     * Nominator дает авадру Nominee пока не достигнет nominatorAwardAmountLimit
     * WHILE
     *
     * @param nominator     - nominator of the award
     * @param award         - chosen award for nomination
     * @param nomineesArray - list of the award recipients
     */
    public static void useNominatorAwardAmountLimit(Nominator nominator, Award award, Nominee[] nomineesArray) {
        int nominatorAwardAmount = 0;
        while (nominatorAwardAmount + award.getValue() <= nominator.getNominatorAwardAmountLimit()) {
            nominator.nominate(nomineesArray, award);
            nominatorAwardAmount += award.getValue();
            System.out.println(String.format("Total value of given nominations - %s", nominatorAwardAmount));
        }
        LimitType limitType = LimitType.NOMINATOR_AWARD_AMOUNT_LIMIT;
        limitMessage(limitType);
    }

    /**
     * Nominator дает авадру Nominee пока не достигнет nomineeAwardQuantityLimit
     * *
     *
     * @param nominee    - award recipient
     * @param awardsList - chosen award for nomination
     * @param nominator  - nominator of the award
     */
    public static void useNomineeAwardQuantityLimit(Nominee nominee, Award[] awardsList, Nominator nominator) {
        int recipientAwardQuantity = 0;
        for (int i = 0; i < awardsList.length; i++) {
            if (recipientAwardQuantity + 1 <= nominee.getNomineeAwardQuantityLimit()) {
                nominator.nominate(nominee, awardsList[i]);
                recipientAwardQuantity++;
                System.out.println(String.format("Total amount of received nominations - %s", recipientAwardQuantity));
            } else {
                LimitType limitType = LimitType.NOMINEE_AWARD_QUANTITY_LIMIT;
                limitMessage(limitType);
                break;
            }
        }
    }

    /**
     * Nominator дает авадру Nominee пока не достигнет nomineeAwardAmountLimit
     * IF - ELSE, FOREACH
     *
     * @param nominee   - award recipient
     * @param awardList - chosen award for nomination
     * @param nominator - nominator of the award
     */
    public static void useNomineeAwardAmountLimit(Nominee nominee, Award[] awardList, Nominator nominator) {
        int nomineeAwardAmount = 0;
        for (Award award : awardList) {
            if (nomineeAwardAmount + award.getValue() <= nominee.getNomineeAwardAmountLimit()) {
                nominator.nominate(nominee, award);
                nomineeAwardAmount += award.getValue();
                System.out.println(String.format("Total value of received nominations - %s", nomineeAwardAmount));
            } else {
                LimitType limitType = LimitType.NOMINEE_AWARD_AMOUNT_LIMIT;
                limitMessage(limitType);
                break;
            }
        }
    }

    /**
     * Returns appropriate message on specific limit type reaching
     *
     * @param limitType - the limit type
     */
    private static void limitMessage(LimitType limitType) {
        switch (limitType) {
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
        double nominatorAmount = nominator.getNominatorGivenAwardAmount() + award.getValue();
        if (nominatorAmount <= nominator.getNominatorAwardAmountLimit()) {
            checkNominatorAwardQuantityLimit(award, nominator, nomineesArray);
        } else {
            System.out.println(String.format("AwardAmountLimit for nominator is reached, Award Amount Received by Nominator - %s",
                    nominator.getNominatorGivenAwardAmount()));
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
            System.out.println(String.format("AwardQuantityLimit for nominator is reached, Award Quantity Received by Nominator - %s",
                    nominator.getNominatorGivenAwardQuantity()));
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
                System.out.println(String.format("AwardAmountLimit for recipient is reached, Award Amount Received by Recipient - %s",
                        nominee.getNomineeReceivedAwardAmount()));
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
                nominator.nominate(nomineesArray, award);
                nominator.setNominatorGivenAwardAmount(nominator.getNominatorGivenAwardAmount() + award.getValue());
                nominator.setNominatorGivenAwardQuantity(nominator.getNominatorGivenAwardQuantity() + 1);
                nominee.setNomineeReceivedAwardAmount(nominee.getNomineeReceivedAwardAmount() + award.getValue());
                nominee.setNomineeReceivedAwardQuantity(nominee.getNomineeReceivedAwardQuantity() + 1);
                System.out.println(String.format("Nominator AwardAmount - %s, AwardQuantity - %s; Recipient AwardAmount - %s, Recipient AwardQuantity - %s",
                        nominator.getNominatorGivenAwardAmount(), nominator.getNominatorGivenAwardQuantity(),
                        nominee.getNomineeReceivedAwardAmount(), nominee.getNomineeReceivedAwardQuantity()));
            } else {
                System.out.println(String.format("AwardQuantityLimit for recipient is reached, Award Quantity Received by Recipient - %s",
                        nominee.getNomineeReceivedAwardQuantity()));
            }
        }
    }
}
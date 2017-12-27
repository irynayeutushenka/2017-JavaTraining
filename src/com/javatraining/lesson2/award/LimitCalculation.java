package com.javatraining.lesson2.award;

import com.javatraining.lesson2.nominator.Nominator;
import com.javatraining.lesson2.nominee.Nominee;

public class LimitCalculation {

    // Nominator дает авадру Nominee пока не достигнет nominatorAwardAmountLimit
    public void checkNominatorAwardAmountLimit(Award award, Nominator nominator, Nominee[] nomineesArray) {
        double nominatorAmount = nominator.getNominatorAwardAmount();
        if ((nominatorAmount + award.getValue()) <= nominator.getNominatorAwardAmountLimit()) {
            checkNominatorAwardQuantityLimit(award, nominator, nomineesArray);
        } else {
            System.out.println(String.format("AwardAmountLimit for nominator is reached, Award Amount Received by Nominator - %s", nominatorAmount));
        }
    }

    // Nominator дает авадру Nominee пока не достигнет nominatorAwardQuantityLimit
    public void checkNominatorAwardQuantityLimit(Award award, Nominator nominator, Nominee[] nomineesArray) {
        int nominatorAwardQuantity = nominator.getNominatorAwardQuantity();
        if ((nominatorAwardQuantity + 1) <= nominator.getNominatorAwardQuantityLimit()) {
            checkNomineeAwardAmountLimit(award, nominator, nomineesArray);
            //nominatorAwardQuantity++;
        } else {
            System.out.println(String.format("AwardQuantityLimit for nominator is reached, Award Quantity Received by Nominator - %s", nominatorAwardQuantity));
        }
    }

    // Nominator дает авадру Nominee пока не достигнет nomineeAwardAmountLimit
    public void checkNomineeAwardAmountLimit(Award award, Nominator nominator, Nominee[] nomineesArray) {
        for (Nominee n : nomineesArray) {
            double nomineeAmount = n.getNomineeAwardAmount();
            if ((nomineeAmount + award.getValue()) <= n.getNomineeAwardAmountLimit()) {
                checkNomineeAwardQuantityLimit(award, nominator, nomineesArray);
                //nomineeAmount += award.getValue();
            } else {
                System.out.println(String.format("AwardAmountLimit for recipient is reached, Award Amount Received by Recipient - %s", nomineeAmount));
            }
        }
    }

    // Nominator дает авадру Nominee пока не достигнет nomineeAwardQuantityLimit
    public void checkNomineeAwardQuantityLimit(Award award, Nominator nominator, Nominee[] nomineesArray) {
        for (Nominee n : nomineesArray) {
            int nomineeAwardQuantity = n.getNomineeAwardQuantity();
            if ((nomineeAwardQuantity + 1) <= n.getNomineeAwardQuantityLimit()) {
                n.receiveAward(award);
                nominator.setNominatorAwardAmount(nominator.getNominatorAwardAmount() + award.getValue());
                nominator.setNominatorAwardQuantity(nominator.getNominatorAwardQuantity() + 1);
                n.setNomineeAwardAmount(n.getNomineeAwardAmount() + award.getValue());
                n.setNomineeAwardQuantity(n.getNomineeAwardQuantity() + 1);
                System.out.println(String.format("Nominator AwardAmount - %s, AwardQuantity - %s; Recipient AwardAmount - %s, Recipient AwardQuantity - %s",
                        nominator.getNominatorAwardAmount(), nominator.getNominatorAwardQuantity(), n.getNomineeAwardAmount(), n.getNomineeAwardQuantity()));
            } else {
                System.out.println(String.format("AwardQuantityLimit for recipient is reached, Award Quantity Received by Recipient - %s", nomineeAwardQuantity));
            }
        }
    }
}
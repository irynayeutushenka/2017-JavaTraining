/**
 * Runner for creation nominations taking into account limits
 *
 * @author Iryna_Yeutushenka
 */

package com.javatraining.lesson2;

import com.javatraining.lesson2.award.Award;
import com.javatraining.lesson2.award.LimitCalculation;
import com.javatraining.lesson2.nominator.Nominator;
import com.javatraining.lesson2.nominee.Nominee;

public class NominationCreationWithLimits_Lesson4 {

    public static void main(String[] args) {

        Award award1 = new Award(100);
        Award award2 = new Award(200);
        Award award3 = new Award(500);
        Award award4 = new Award(50);
        Award award5 = new Award(1000);
        Award [] awardsArray1 = new Award[]{award1, award2, award3, award4, award5};

        Nominator nominator1 = new Nominator();
        nominator1.setNominatorAwardQuantityLimit(5);
        nominator1.setNominatorAwardAmountLimit(500.5);

        Nominee nominee1 = new Nominee("Bill");
        Nominee[] nomineesArray1 = new Nominee[]{nominee1};
        nominee1.setNomineeAwardQuantityLimit(2);
        nominee1.setNomineeAwardAmountLimit(1000.5);

        LimitCalculation.checkAllLimits(award1, nominator1, nomineesArray1);
        LimitCalculation.checkAllLimits(award2, nominator1, nomineesArray1);
        LimitCalculation.checkAllLimits(award3, nominator1, nomineesArray1);
        LimitCalculation.checkAllLimits(award4, nominator1, nomineesArray1);

        LimitCalculation.useNominatorAwardQuantityLimit(nominator1, award1, nomineesArray1);
        LimitCalculation.useNominatorAwardAmountLimit(nominator1, award1, nomineesArray1);
        LimitCalculation.useNomineeAwardQuantityLimit(nominee1, awardsArray1, nominator1);
        LimitCalculation.useNomineeAwardAmountLimit(nominee1, awardsArray1, nominator1);
    }
}
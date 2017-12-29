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

        LimitCalculation.useNominatorAwardQuantityLimit(award1, nominator1, nomineesArray1);
        LimitCalculation.useNominatorAwardAmountLimit(award1, nominator1, nomineesArray1);
        LimitCalculation.useNomineeAwardQuantityLimit(award1, nominator1, nomineesArray1);
        LimitCalculation.useNomineeAwardAmountLimit(award1, nominator1, nomineesArray1);
    }
}
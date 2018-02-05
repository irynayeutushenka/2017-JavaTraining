/**
 * Runner for displaying award information
 *
 * @author Iryna_Yeutushenka
 */

package com.javatraining.lesson2;

import com.javatraining.lesson2.award.Award;

import java.util.ArrayList;

import static com.javatraining.lesson2.award.AwardTypes.*;
import static com.javatraining.lesson2.utils.NominationHelper.printAwardsOfDefinedType;
import static com.javatraining.lesson2.utils.NominationHelper.printAwardsTypes;

public class PrintAwards {
    public static void main(String[] args) {

        Award award1 = new Award(10, "USD", CASH, 1);
        Award award2 = new Award(25, "USD", NON_CASH, 2);
        Award award3 = new Award(50, "USD", DIGITAL, 3);
        Award award4 = new Award(100, "USD", PHYSICAL, 4);
        Award award5 = new Award(200, "USD", CASH, 5);
        Award award6 = new Award(500, "USD", CASH, 6);
        Award award7 = new Award(10, "USD", NON_CASH, 7);
        Award award8 = new Award(25, "USD", NON_CASH, 8);
        Award award9 = new Award(50, "USD", DIGITAL, 9);
        Award award10 = new Award(100, "USD", DIGITAL, 10);
        Award award11 = new Award(200, "USD", PHYSICAL, 11);
        Award award12 = new Award(500, "USD", PHYSICAL, 12);
        Award award13 = new Award(10, "USD", CASH, 13);
        Award award14 = new Award(25, "USD", CASH, 14);
        Award award15 = new Award(50, "USD", CASH, 15);

        ArrayList<Award> awardList = new ArrayList<>();
        awardList.add(award1);
        awardList.add(award2);
        awardList.add(award3);
        awardList.add(award4);
        awardList.add(award5);
        awardList.add(award6);
        awardList.add(award7);
        awardList.add(award8);
        awardList.add(award9);
        awardList.add(award10);
        awardList.add(award11);
        awardList.add(award12);
        awardList.add(award13);
        awardList.add(award14);
        awardList.add(award15);

        printAwardsOfDefinedType(awardList, CASH);
        printAwardsTypes(awardList);

        System.out.println(award1.hashCode());
        System.out.println(award3.hashCode());
        System.out.println(award1.equals(award13));
    }
}

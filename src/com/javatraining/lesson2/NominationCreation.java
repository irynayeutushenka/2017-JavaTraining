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

        award1.calculateQuantity(nominee1, awardArrayPerRecipient1);
        award2.calculateQuantity(nominee2, awardArrayPerRecipient2);
        award3.calculateQuantity(nominee3, awardArrayPerRecipient3);
    }
}

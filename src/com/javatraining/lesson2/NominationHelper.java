/**
 * Runner for creation nominations taking into account limits
 *
 * @author Iryna_Yeutushenka
 */


package com.javatraining.lesson2;

import com.javatraining.lesson2.award.Award;
import java.util.Random;

public class NominationHelper {

    /**
     * Method to calculate population to be used in calculateQuantity method
     *
     * @param awardArrayPerRecipient - list of awards received by the recipient
     * @return population - total count of employee's awards without soli
     */
    static int countPopulation(Award awardArrayPerRecipient[]) {
        int count = 0;
        for (Award a : awardArrayPerRecipient) {
            if (a.getSoli() != 0.0f) {
                count++;
            }
        }
        return count;
    }

    /**
     * Method to calculate quantity parameter for each award without soli of each recipients using the formula:
     * quantity = ((Z^2*(P)*(1-P))/(C^2)) / (1 + ((((Z^2*(P)*(1-P ))/(C^2))-1)/population))
     * where:
     * C = a random decimal i.e. 5% = 0.05
     * population = total count of employee's awards without soli
     * Z = a random whole number i.e. 3
     * P = award value;
     *
     * @param award      - chosen award for nomination
     * @param population - total count of employee's awards without soli
     * @return quantity parameter
     */
    public static double calculateQuantity(Award award, int population) {

        Random rand = new Random();
        double c = rand.nextDouble(); // a random decimal i.e. 5% = 0.05
        int z = rand.nextInt(10) + 1; // a random whole number i.e. 3
        int power = 2; //возведение в степень 2
        double v = award.getValue(); //award value
        double pz = Math.pow(z, power); // (Z^2)
        double d = pz * v * (1 - v); // (Z^2*(P)*(1-P))
        double pc = Math.pow(c, power); ///(C^2)
        double m = d / pc;
        double n = (1 + (((m - 1) / population)));
        double quantity = m / n;
        System.out.println(String.format("Award Value - %s, Population - %s, Calculated Quantity - %s", award.getValue(), population, quantity));
        return quantity;
    }
}

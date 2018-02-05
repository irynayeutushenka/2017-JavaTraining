/**
 * Represents a recipient of the award.
 *
 * @author Iryna_Yeutushenka
 */

package com.javatraining.lesson2.operationsWithLimit;

public interface OperationsWithLimit {

    /**
     * Method checks if Award Quantity Limit is reached
     *
     * @param currentAmount limit to be reached after chosen award is given
     * @param limit         established limit
     * @return true if limit is reached and false otherwise
     */
    boolean isAwardQuantityLimitReached(int currentAmount, int limit);

    /**
     * Method checks if Award Quantity Limit is reached
     *
     * @param currentAmount limit to be reached after chosen award is given
     * @param limit         established limit
     * @return true if limit is reached and false otherwise
     */
    boolean isAwardAmountLimitReached(double currentAmount, double limit);
}

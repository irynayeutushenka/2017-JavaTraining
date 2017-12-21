/**
 * Написать command-line приложение, которое будет:
 * a) выводить в консоль следующий текст:
 * We make work HUMAN.
 * Unlock full potential. Celebrate positive moments.
 * Every day.
 * b) вывести на косоль длину 2ой строки
 * c) переписать всё в нижнем регистре
 * d) заменить символ ‘e’ на ‘E’.
 */

package com.javatraining.lesson1;

public class TaskSecond {

    private static final String NEW_LINE = "\n";
    private static String LOGO_1 = "We make work HUMAN.";
    private static String LOGO_2 = "Unlock full potential. Celebrate positive moments.";
    private static String LOGO_3 = "Every day.";

    public static void main(String[] args) {
        String logo = String.format("%1$s%4$s%2$s%4$s%3$s", LOGO_1, LOGO_2, LOGO_3, NEW_LINE );
        taskA(logo);
        taskB();
        taskC(logo);
        taskD(logo);
    }

    private static void taskA(String text) {
        System.out.println(String.format("Task A%s%s", NEW_LINE, text));
    }

    private static void taskB() {
        int logo2Length = LOGO_2.length();
        System.out.println(String.format("Task B%1$s%2$s", NEW_LINE, logo2Length));
    }

    private static void taskC(String text) {
        String lowerLogo = text.toLowerCase();
        System.out.println(String.format("Task C %1$s%2$s", NEW_LINE, lowerLogo));
    }

    private static void taskD(String text) {
        String logoReplaced = text.replace('e', 'E');
        System.out.println(String.format("Task C %1$s%2$s", NEW_LINE, logoReplaced));
    }
}
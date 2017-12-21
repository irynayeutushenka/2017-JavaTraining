/**
 * a) Создать строку 'Globoforce' как массив символов.
 * b) вывести размер массива.
 * с) заменить символ ‘b’, на символ ‘$’
 */


package com.javatraining.lesson1;

import java.util.Arrays;


public class TaskThird {

    private static final String NEW_LINE = "\n";
    private static char[] gfArray = {'G', 'l', 'o', 'b', 'o', 'f', 'o', 'r', 'c', 'e'};

    public static void main(String[] args) {
        String gfString = Arrays.toString(gfArray);
        taskA(gfString);
        taskB(gfString);
        taskCv1(gfString);
        taskCv2();
    }

    private static void taskA(String text) {
        System.out.println(String.format("Task A%s%s", NEW_LINE, text));
    }

    private static void taskB(String text) {
        if (text != null) {
            int gfStringLength = text.length();
            System.out.println(String.format("Task B%s%s", NEW_LINE, gfStringLength));
        }
    }

    private static void taskCv1(String text) {
        String gfStringReplaced = text.replace('b', '$');
        System.out.println(String.format("Task C%1$s%2$s", NEW_LINE, gfStringReplaced));
    }

    private static void taskCv2() {
        for (int i = 0; i < gfArray.length; i++) {
            if (gfArray[i] == 'b') {
                gfArray[i] = '$';
            }
            System.out.println(gfArray[i]);
        }
    }
}
package org.example;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите пожалуйста число:");
        long number = scanner.nextLong();

        System.out.println("Введеное число: " + returnedInWords(number));
    }

    public static String returnedInWords(long number) {

        ArrayList<String> array = new ArrayList<>();
        String[] ones = new String[]{"", "one", "two", "free", "four", "five", "six", "seven", "eight", "nine"};
        String[] tens = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] teens = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen" +
                "eighteen", "nineteen"};
        String hundred = "hundred";
        String[] orders = new String[]{"", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion" +
                "sextillion"};
        String minus = "minus";
        String zero = "Zero";

        int count = 1;
        StringBuilder printNumber = new StringBuilder();

        if (number == 0) {
            return zero;
        }
        boolean checkMinus = false;
        if (number < 0) {
            checkMinus = true;
            number = -number;
        }
        while (number != 0) {

            int residue = (int) (number % 1000);
            int firstFromEnd = residue % 10;
            int secondFromEnd = ((residue / 10) % 10);
            int thirdFromEnd = residue / 100;
            number = number / 1000;

            if (firstFromEnd > 0 && secondFromEnd != 1) {
                array.addFirst(ones[firstFromEnd]);
            }
            if (secondFromEnd > 1) {
                array.addFirst(tens[secondFromEnd]);
            }
            if (secondFromEnd == 1 && firstFromEnd == 0) {
                array.addFirst(teens[firstFromEnd]);
            }
            if (secondFromEnd == 1 && firstFromEnd > 0) {
                array.addFirst(teens[firstFromEnd]);
            }
            if (thirdFromEnd > 0) {
                array.addFirst(hundred);
                array.addFirst(ones[thirdFromEnd]);
            }
            if (count > 0 && number != 0) {
                array.addFirst(orders[count]);
                if ((number % 10000) == 1000 || (number % 100000) == 0){
                    array.removeFirst();
                }
                count++;
            }
        }
        if (checkMinus) {
            array.addFirst(minus);
        }

        for (int i = 0; i < array.size(); i++){
            printNumber.append(array.get(i));
            printNumber.append(" ");
        }

        return printNumber.toString();
    }
}

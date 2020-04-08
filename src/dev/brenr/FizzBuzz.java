package dev.brenr;

import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Number: ");
        final int input = scanner.nextInt();

        System.out.println(fizzBuzz(input));
    }

    private static String fizzBuzz(final int number) {
        final boolean isFizz = number % 5 == 0;
        final boolean isBuzz = number % 3 == 0;

        if(!isFizz && !isBuzz)
            return Integer.toString(number);

        return (isFizz ? "Fizz" : "") + (isBuzz ? "Buzz" : "");
    }

}

package dev.brenr;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        final Employee employee = new Employee(50_000, 20);
        Employee.printNumberOfEmployees();
        final int wage = employee.calculateWage();
        System.out.println(wage);

        NumberFormat
    }

}

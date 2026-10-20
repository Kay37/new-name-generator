package com.pluralsight;

// * importing Scanner for user input

import java.util.Scanner;

public class FullNameApplication {

    // * static scanner that can be accessed by any method within this class.
    public static Scanner sc = new Scanner(System.in);

    // ! static variables/finals go here

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {

        // TODO - Prompt the user to enter the parts of their name.
        System.out.printf("""
                %sHello! Please provide your full name! Include first, middle, last, and any suffix. %n
                """, BLUE);
        String firstName = askQuestion(BLUE, "First name: ");
        String middleName = askQuestion(BLUE, "Middle name: ");
        String lastName = askQuestion(BLUE, "Last name: ");
        String suffix = askQuestion(BLUE, "Suffix: ");

        // TODO - Create a string that holds the user's full name. Trim leading or trailing spaces user may have put.
        String formattedFullName;
        formattedFullName = firstName;
        if (!middleName.isEmpty()) {
            formattedFullName = formattedFullName + " " + middleName;
        }
        if (!lastName.isEmpty()) {
            formattedFullName = formattedFullName + " " + lastName;
        }
        if (!suffix.isEmpty()) {
            formattedFullName = formattedFullName + ", " + suffix;

        }
        // TODO - Print the user's name to them
        System.out.printf("%sYour full name is:%s %s%s%s%n", BLUE, RESET, GREEN, formattedFullName, RESET);

        // * close scanner to save resources
        sc.close();
    } // ! main method closing bracket

    // ! other methods go below this comment

    public static String makeColorScheme(String color, String originalMessage) {
        return color + originalMessage + RESET;
    }

    public static String askQuestion(String color, String prompt) {
        String coloredPrompt;
        coloredPrompt = makeColorScheme(color, prompt);
        System.out.print(coloredPrompt);
        String answer = sc.nextLine();
        return answer.trim();
    }

} // ! class closing bracket

package main;

// Create a program that takes in words and let the program return number of characters and number of words has been written.
// The program should shut down when the user types 'Stop'. The word 'Stop' should not be counted.
// The program should have two classes, and have atleast three different testcases testing the program.

public class MainCounting {
    public static void main(String[] args) {

        StopProgram userOne = new StopProgram();
        System.out.println("This is a program that will let you type in words!");
        System.out.println("The rules are simple. Type in any word using only letters.");
        System.out.println("Too stop the program simply type the word 'Stop'. The word itself does not count!");
        System.out.println("The app will then print out your number of characters, words written and the longest word written.");
        System.out.print("To start simply type a word: ");
            userOne.startCounting();
            //userOne.startCount();

    }
}

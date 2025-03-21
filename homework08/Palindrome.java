// Delta College - CST 283 - Klingler
// This program reads a string object from the user and determines
// if the word stored within is a palindrome or not

import javax.swing.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Palindrome 
{
    public static void main(String[] args) 
    {
        String[] fileNames = { "C:/Users/Getbe/OneDrive/Desktop/palindrome0.txt", "C:/Users/Getbe/OneDrive/Desktop/palindrome1.txt", "C:/Users/Getbe/OneDrive/Desktop/palindrome2.txt" };

        for (String fileName : fileNames) {
            try {
                //to read file content and process it
                String sentence = readFileContent(fileName);
                String processedSentence = cleanString(sentence);
                if (isPalindrome(processedSentence)) {
                    System.out.println("File: " + fileName + " - The sentence is a palindrome.");
                } else {
                    System.out.println("File: " + fileName + " - The sentence is NOT a palindrome.");
                }
            } catch (IOException e) {
                System.out.println("Error reading the file: " + fileName);
            }
        }
    }
    //reads the file content so we can return as a string
    public static String readFileContent(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        Scanner fileScanner = new Scanner(new File(fileName));

        while (fileScanner.hasNextLine()) {
            content.append(fileScanner.nextLine()).append(" ");
        }

        fileScanner.close();
        return content.toString().trim();
    }
    //to clean the string (removes spaces, puncation, etc)
    public static String cleanString(String input) {
        return input.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }


    // This method receives a string object and returns TRUE
    // if the object represents a palindrom and FALSE otherwise
    public static boolean isPalindrome(String word) 
    {
        LinkedQueue<Character> charQueue = new LinkedQueue<>();
        LinkedStack<Character> charStack = new LinkedStack<>();
         
        boolean palindromeOK = true;       // Assume a palindrom until detecting otherwise

        // Traverse characters of word, In sequence, push into a stack
        // and enqueue into a queue.
        //chnaged the for loop a little
        for (char c : word.toCharArray()) {
            charStack.push(c);
            charQueue.enqueue(c);
        }

        // Pop and access characters in reverse order.  Match with
        // corresponding character in queue.  Any mismatch would
        // disqualify string as a palindrome

        //but now we compare charchteres from the stack with dequed charachters
        while (!charStack.isEmpty()) {
            if (!charStack.pop().equals(charQueue.dequeue())) {
                palindromeOK = false;
                break;
            }
        }

        return palindromeOK;
    }
}

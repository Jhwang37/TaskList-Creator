package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 *Author: Jhwang37
 * Project: Task List Creator
 * Purpose: Get comfortable using array lists that allows the user to add and delete entries.
 * Date: 1/14/2019
 */

public class TaskList {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        ArrayList<String> list1 = new ArrayList<String>();
        System.out.println("=====================");
        System.out.println("======List Maker=====");
        System.out.println("=====================");
        addTask(list1);
    }

    public static void showList(ArrayList list) {//Method to show the contents of the array list with a number.
        int i = 1;
        for (Object z : list) {
            System.out.println(i++ + "." + z);
        }
    }

    public static ArrayList addTask(ArrayList list) throws IOException {
        Boolean start = true; //using a boolean for the while loop to start

        System.out.println("Enter a task to the list (Enter 'remove' to delete an entry)");
        String task = scan.nextLine();
        while (start) {
            if (task.equals("remove")) {//first part of the loop, when the user enters "remove", this if statement will execute
                removeTask(list);//method for removing words with the Array List as the parameter
                start = false;//stops the while loop
            } else {//adds Strings to the array list and executes until start does not equal true
                System.out.println("Enter a task: ");
                task = scan.nextLine();
                list.add(task);
            }
        }
        return list;
    }

    public static ArrayList removeTask(ArrayList list) throws IOException {//Method that will remove entries in an Array List
        int delete;
        try {
            System.out.println("\n=============================");
            System.out.println("======Task List Deleter======");
            System.out.println("=============================");
            showList(list);
            /*
             *Working on this issue; it will not let me enter into the do while loop unless I enter something into the console.
             * I have tried putting 'delete = scan.nextInt()' inside the do/while loop and before it.
             * When I placed 'delete = scan.nextInt()' before the do/while loop, would get an error when entering '0' to exit
             * HAVE TO FIGURE OUT AND UPDATE
             */
            System.out.println("Enter 1 to start removing tasks from the list ");

            do {
                delete = scan.nextInt();
                if (delete != 0) {//first part of the loop that gets the int value from the user and deletes the entry from the array list location
                    System.out.println("Enter the number to delete corresponding task " +
                            "(Enter 0 to go to task adder)");
                    delete = scan.nextInt();
                    System.out.println("\nYou have deleted the task: " + list.get(delete - 1) + "\n");
                    list.remove(delete - 1);
                    System.out.println("Updated Task List");
                    showList(list);
                } else {//Takes user back to the add word part of the program
                    addTask(list);
                    break;
                }
            } while (delete != 0);
        } catch (InputMismatchException iex) {
            System.out.println("Wrong number was entered");
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        return list;
    }
}

/*
 *while loop that I tried using but would not let me enter 0 even with Exceptions.
 * I believe it was because it used the 0 in relation to the Array List and I kept getting an index OutOfBounds Exception.
 */
//        while (start) {
//            if (delete == 0) {
//                System.out.println("out of loop");
//                start = false;
//                addTask(list);
//
//            }  else {
//                System.out.println("Delete another: / Enter 0 to stop");
//                delete = scan.nextInt();
//                System.out.println("You have deleted the task: " + list.get(delete -1));
//                list.remove(delete - 1);
//                System.out.println("Priority List");
//                showList(list);
//            }
//        }
//       return list;
//    }


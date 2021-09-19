package presentation;

import java.util.Scanner;

import application.BinaryTreeHandler;
import core.Command;

public class AbstractTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Escolha o algoritimo o tipo de TAD a ser usado\n" + "[1] - Árvore binária \n" + "[2] - Vetor \n"
                + "[3] - Lista duplamente encadeada \n");

        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                executeBinaryTree();
                break;
            default:
                return;
        }
    }

    private static void executeBinaryTree() {
        var durationInsert = BinaryTreeHandler.execute(Command.InsertStudents);
        
        var durationPrint = BinaryTreeHandler.execute(Command.PrintStudents);

        var durationCount = BinaryTreeHandler.execute(Command.CountStudentsWithESCourse);

        var durationRemove = BinaryTreeHandler.execute(Command.RemoveStudents);

        printResult(Command.InsertStudents, durationInsert);

        printResult(Command.PrintStudents, durationPrint);

        printResult(Command.CountStudentsWithESCourse, durationCount);

        printResult(Command.RemoveStudents, durationRemove);
    }

    private static void printResult(Command command, long duration) {
        System.out.printf("\nO comando %s durou %.4f ms%n", command.toString(), duration / 1000d);
    }
}

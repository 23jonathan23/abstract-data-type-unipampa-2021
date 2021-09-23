package presentation;

import java.util.Scanner;

import application.BinaryTreeHandler;
import application.VectorHandler;
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
            case 2:
                executeVector();
            default:
                return;
        }
    }

    private static void executeBinaryTree() {
        var binaryTreeHandler = new BinaryTreeHandler();

        var durationInsert = binaryTreeHandler.execute(Command.InsertStudents);
        
        var durationPrint = binaryTreeHandler.execute(Command.PrintStudents);

        var durationCount = binaryTreeHandler.execute(Command.CountStudentsWithESCourse);

        var durationRemove = binaryTreeHandler.execute(Command.RemoveStudents);

        printResult(Command.InsertStudents, durationInsert);

        printResult(Command.PrintStudents, durationPrint);

        printResult(Command.CountStudentsWithESCourse, durationCount);

        printResult(Command.RemoveStudents, durationRemove);
    }

    private static void executeVector() {
        var vectorHandler = new VectorHandler();

        var durationInsert = vectorHandler.execute(Command.InsertStudents);
        
        var durationPrint = vectorHandler.execute(Command.PrintStudents);

        var durationCount = vectorHandler.execute(Command.CountStudentsWithESCourse);

        var durationRemove = vectorHandler.execute(Command.RemoveStudents);

        printResult(Command.InsertStudents, durationInsert);

        printResult(Command.PrintStudents, durationPrint);

        printResult(Command.CountStudentsWithESCourse, durationCount);

        printResult(Command.RemoveStudents, durationRemove);
    }

    private static void printResult(Command command, long duration) {
        System.out.printf("\nO comando %s durou %.4f ms%n", command.toString(), duration / 1000d);
    }
}

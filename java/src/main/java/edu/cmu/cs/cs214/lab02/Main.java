package edu.cmu.cs.cs214.lab02;

import edu.cmu.cs.cs214.lab02.shapes.Circle;
import edu.cmu.cs.cs214.lab02.shapes.Rectangle;
import edu.cmu.cs.cs214.lab02.shapes.Shape;
import edu.cmu.cs.cs214.lab02.shapes.Square;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shape shape = null;

        try {
            System.out.println("Select a shape to render:");
            System.out.println("1. Rectangle");
            System.out.println("2. Circle");
            System.out.println("3. Square");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter width: ");
                    double width = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double height = scanner.nextDouble();
                    shape = new Rectangle(width, height);
                    break;
                case 2:
                    System.out.print("Enter radius: ");
                    double radius = scanner.nextDouble();
                    shape = new Circle(radius);
                    break;
                case 3:
                    System.out.print("Enter side length: ");
                    double sideLen = scanner.nextDouble();
                    shape = new Square(sideLen);
                    break;
                default:
                    System.out.println("Invalid choice");
                    System.exit(1);
            }

            Renderer renderer = new Renderer(shape);
            renderer.draw();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric values.");
        } finally {
            scanner.close();
        }
    }
}
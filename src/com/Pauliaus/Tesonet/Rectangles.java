package com.Pauliaus.Tesonet;

import java.util.Scanner;

public class Rectangles {

    /*
    Characters used to build a rectangle.
    Copied from the task description file.
     */
    private final static char topLeft = '┌';
    private final static char topRight = '┐';
    private final static char horizontalEdge = '─';
    private final static char verticalEdge = '│';
    private final static char bottomLeft = '└';
    private final static char bottomRight = '┘';

    public static void main(String[] args) {
        //Code used for testing the method
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please put in width and height:");
        System.out.println(draw(scanner.nextInt(), scanner.nextInt()));
        */

        //Tests to compare the rectangles to the ones given in the task

        //Rectangles given as an examples in  the task file
        String rectangle1 = "┌┐\n" +
                            "└┘";
        String rectangle2 = "┌─┐\n" +
                            "│ │\n" +
                            "└─┘";
        String rectangle3 = "┌──────┐\n" +
                            "│      │\n" +
                            "└──────┘";
        //Test 1
        String test1Result = rectangle1.equals(draw(2,2)) ? "passed" : "failed";
        System.out.println("Test 1 " + test1Result);

        //Test 2
        String test2Result = rectangle2.equals(draw(3,3)) ? "passed" : "failed";
        System.out.println("Test 2 " + test2Result);

        //Test 3
        String test3Result = rectangle3.equals(draw(8,3)) ? "passed" : "failed";
        System.out.println("Test 3 " + test3Result);
    }

    public static String draw(int width, int height) {

        //Handling the cases when arguments are too low
        if (width < 2 || height < 2) {
            if (width < 2 && height < 2) {          //Both arguments too low
                return "Both parameters are too low! Enter values higher than 1!";
            } else if (width < 2) {                 //Width argument too low
                return "Width parameter is too low! Enter a value higher than 1!";
            } else {                                //Height argument too low
                return "Height parameter is too low! Enter a value higher than 1!";
            }
        }

        /*
        A StringBuilder Object to build the rectangle in.
        Could be done using String Objects, but since String is
        unmodifiable, the method would be creating too many objects.
        StringBuilder is a modifiable String Object.
         */
        StringBuilder rectangle = new StringBuilder();

        /*
        Horizontal rows to avoid some loops. Could be done
        using String.repeat(), but StringBuilder is available since Java 8,
        whereas String.repeat() only on Java 11+.
        */

        //Top and bottom horizontal rows without corners
        StringBuilder topAndBottom = new StringBuilder();
        for (int i = 0; i < width - 2; i++) {       //i < width - 2 because of the 2 corner chars
            topAndBottom.append(horizontalEdge);
        }

        //The middle rows
        StringBuilder middleRow = new StringBuilder();
        middleRow.append(verticalEdge);
        for (int i = 0; i < width - 2; i++) {       //i < width - 2 because of the 2 wall chars
            middleRow.append(' ');
        }
        middleRow.append(verticalEdge);

        //Painting the top row
        rectangle.append(topLeft)
                .append(topAndBottom)
                .append(topRight)
                .append('\n');          //The newline character

        //Painting the middle rows
        for (int i = 0; i < height - 2; i++) {
            rectangle.append(middleRow)
                    .append('\n');      //The newline character
        }

        //Painting the bottom row
        rectangle.append(bottomLeft)
                .append(topAndBottom)
                .append(bottomRight);
        //Not appending the newline at the end to let the user control that

        //Returning a String Object containing the rectangle
        return rectangle.toString();
    }
}

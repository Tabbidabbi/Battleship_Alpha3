/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import IO.IO;

/**
 *
 * @author Tobias
 */
public class Helper {

    static int input;

    /**
     *
     * @param message Hint
     * @param min Minimum Value
     * @param max Maximum Value
     * @return
     */
    public static int checkUserInput(String message, int min, int max) {
        boolean error = false;
        do {
            IO.println(message);
            input = IO.readInt();
            if (input < min || input > max) {
                IO.println("Eingabe, außerhalb des gültigen Bereiches (" + min + "-" + max + ")");
                error = true;
            } else {
                error = false;

            }
        } while (error);
        return input;
    }
     public static int checkUserInput(int min, int max) {
        boolean error = false;
        do {
            input = IO.readInt();
            if (input < min || input > max) {
                IO.println("Eingabe, außerhalb des gültigen Bereiches (" + min + "-" + max + ")");
                error = true;
            } else {
                error = false;

            }
        } while (error);
        return input;
    }
     
        public static boolean checkOrientation() {
        boolean orientation = false;
        boolean error = false;
        do {
            IO.print("Bitte geben Sie die Ausrichtung des Schiffes an (h = horizontal, v = vertical: ");
            String o = IO.readString();
            if (o.equals("h")) {
                error = false;
                orientation = true;
            } else if (o.equals("v")) {
                error = false;
                orientation = false;
            } else {
                IO.println("Falsche Eingabe, bitte wiederholen Sie die Eingabe!");
                error = true;
            }
        } while (error);

        return orientation;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.util.ArrayList;

import IO.IO;
import Gameobjects.Player.Player;

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
    
    public static String aiChooseCoordinate(ArrayList<Gameobjects.Player.Player> playerList, int playerNumber){
    	boolean error = false;
    	String coordinateInput = null;
    	do{
    		
    		int Coordinate = getAiYCoordinate(playerList, playerNumber);
        	String yCoordinate = Integer.toString(Coordinate);
        	String xCoordinate = getAiXCoordinate(playerList, playerNumber);
        	coordinateInput = yCoordinate + xCoordinate;
        	//Prueft, ob Koordinate getroffen
        	for(int i = 0; i < playerList.get(playerNumber).getPlayfield().getFieldMatrix().length; i++){
        		for(int j = 0; j < playerList.get(playerNumber).getPlayfield().getFieldMatrix()[i].length; j++){
        			if(coordinateInput == playerList.get(playerNumber).getPlayfield().getFieldMatrix()[i][j].getFieldNumber() && 
        					playerList.get(playerNumber).getPlayfield().getFieldMatrix()[i][j].getIsHit() == true){
        				
        				error = true;
        				
        			}
        		}
        		
        	}
    	}while (error);
    	//Koordinate
    	
    	//R�ckgabewert Koordinate
    	return coordinateInput;
    }
    
    public static int getAiYCoordinate(ArrayList<Gameobjects.Player.Player> playerList, int playerNumber){
    	
    	//Range der Zufallszahlen
    	int pool = playerList.get(playerNumber).getPlayfield().getFieldMatrix().length - 1;
    	//Zufallszahl zwischen
    	return (int)(Math.random() * pool) + 1;
    }
    
    public static String getAiXCoordinate(ArrayList<Gameobjects.Player.Player> playerList, int playerNumber){
    	//char 97-122 = abc.....
    	String coordinate;
    	int randomNumber = 0;
    	int endOfRange = playerList.get(playerNumber).getPlayfield().getFieldMatrix().length + 96;
    	while(randomNumber < 97) {
    		randomNumber = (int)(Math.random() * endOfRange);
    	}
    	char letter = (char) randomNumber;
    	coordinate = Character.toString(letter);
    	return coordinate;
    }
    
    public static boolean chooseAiOrientation(){
    	boolean error;
    	boolean orientation = false;
            int orient = (int)(Math.random() * 2) + 1;
    	if(orient == 1){
    		error = false;
                   	orientation = true;	
    	} else{
                   	error = false;
                   	orientation = false;
            } 
            return orientation;
    }
}

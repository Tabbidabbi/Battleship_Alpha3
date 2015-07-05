package Gameobjects.Player;

import Game.Settings;
import Gameobjects.Playfield.Playfield;
import Gameobjects.Ships.*;
import IO.IO;
import java.util.ArrayList;
import Game.Game;
import Gameobjects.Playfield.PlayerPlayfieldGui;

public class Player {
    
    
    Settings gameSettings;
    private int input;
    
    private int number;

    private String name;

    private ArrayList<Ship> ships;

//    Settings settings = new Settings();
    private Playfield playfield;
    private PlayerPlayfieldGui playerPlayFieldGui;

    private Playfield opponentField;

    private boolean lost;

    private boolean isAI;

    public Player(int number) {
//        this.name = name;
        this.gameSettings = Settings.getGameSettings();
        this.number = number;
        buildShipArray(gameSettings);
        this.playerPlayFieldGui = new PlayerPlayfieldGui();
//        playfield = new Playfield(gameSettings.getPlayfieldSize(),gameSettings.getPlayfieldSize());
//        playfield.printPlayField();
//        opponentField = new Playfield(gameSettings.getPlayfieldSize(),gameSettings.getPlayfieldSize());
    }
    

    public PlayerPlayfieldGui getPlayerPlayFieldGui() {
        return playerPlayFieldGui;
    }

    public void setPlayerPlayFieldGui(PlayerPlayfieldGui playerPlayFieldGui) {
        this.playerPlayFieldGui = playerPlayFieldGui;
    }
    
    private void buildShipArray(Settings cSettings) {
         ships = new ArrayList<>();
        int shipNumber = 1;
        for (int i = 1; i <= cSettings.getAmountOfCorvette(); i++) {
            Ship ship = new Destroyer(shipNumber);
            ships.add(ship);
            shipNumber++;
        }
        for (int i = 1; i <= cSettings.getAmountOfFrigate(); i++) {
            Ship ship = new Frigate(shipNumber);
            ships.add(ship);
            shipNumber++;

        }
        for (int i = 1; i <= cSettings.getAmountOfCorvette(); i++) {
            Ship ship = new Corvette(shipNumber);
            ships.add(ship);
            shipNumber++;

        }
        for (int i = 1; i <= cSettings.getAmountOfSubmarine(); i++) {
            Ship ship = new Submarine(shipNumber);
            ships.add(ship);
            shipNumber++;

        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }

    public Playfield getPlayfield() {
        return playfield;
    }

    public void setPlayfield(Playfield playfield) {
        this.playfield = playfield;
    }

    public Playfield getOpponentField() {
        return opponentField;
    }

    public void setOpponentField(Playfield opponentField) {
        this.opponentField = opponentField;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public boolean isIsAI() {
        return isAI;
    }

    public void setIsAI(boolean isAI) {
        this.isAI = isAI;
    }
    
 
    
    public void printShipList() {

        for (Ship ship : ships) {
            IO.println(ship.getName() + "\t" + ship.getNumber() + "\t"
                    + " Größe " + "(" + ship.getSize() + ")");
        }
    }
    
    }

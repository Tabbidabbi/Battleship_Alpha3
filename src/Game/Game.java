 package Game;

import Gameobjects.Ships.Ship;
import Gameobjects.Player.Player;
import Gameobjects.Playfield.Playfield;
import IO.IO;
import java.util.ArrayList;
import Helper.Helper;

public class Game {

    private ArrayList<Player> playerList;

    private ArrayList<Ship> shipList;

    private int input;

    private String coordinateInput;

    private boolean shipOrientation;

    private Settings currentGameSettings;

    private int amountOfPlayer;

    private boolean error;

    public Game(Settings settings) {
        this.currentGameSettings = settings;
        IO.println("Willkommen beim Spiel Schiffeversenken!!!");
        buildPlayerArray();
        placeAllShips();

    }

    private void buildPlayerArray() {
        this.playerList = new ArrayList<>();
        int playerNumber = 1;
        for (int i = 1; i <= currentGameSettings.getAmountOfPlayer(); i++) {
            IO.print("Spieler " + (i) + " - Geben Sie ihren Namen ein: ");
            String name = IO.readString();//Einlesen des Spielernamens
            Player player = new Player(playerList, currentGameSettings, name, playerNumber);
            playerList.add(player);
            playerNumber++;

        }

    }

    private void placeAllShips() {
        error = false;

        for (Player player : playerList) {
            IO.println("Spieler " + player.getName() + " Sie können nun folgende Schiffe setzen: ");
            player.printShipList();
            ArrayList<Ship> ships = player.getShips();
            System.out.println(ships.size());
            for (int s = 0; s < ships.size();) {
                IO.print("Bitte geben Sie die Koordinaten für " + ships.get(s).getName() + " " + ships.get(s).getNumber() + " ein:");
                do {
                    coordinateInput = IO.readString().toLowerCase(); //Großbuchstaben-> Kleinbuchstaben
                    //Teste Eingabe mit RegEx(^ Anfang, 1 Zahl (1-9) und 1 oder keine Zahl(0-9) und 1 Buchstabe (a-z), $ Ende
                    if (coordinateInput.matches("^[1-9]{1}[0-9]{0,1}[a-z]{1}$")) {
                        error = false;
                    } else {
                        IO.println("Falsche Eingabe, bitte geben sie zuerst die Nummer und dann den Buchstaben des Feldes ein: ");
                        error = true;
                    }
                } while (error);
                shipOrientation = Helper.checkOrientation();
                //Schiff wird gesetzt
                if (!placeShip(ships.get(s), coordinateInput, shipOrientation, player.getPlayfield(), player.getOpponentField())) {
                    IO.println("Das Schiff konnte nicht gesetzt werden. Bitte erneut versuchen.");
                } else {
                    s++;
                }

            }

        }
    }

    public boolean placeShip(Ship ship, String input, boolean orientation, Playfield playfield, Playfield opponentfield) {

        //true = horizontal
        if (orientation == true) {
            for (int y = 0; y < playfield.getFieldMatrix().length; y++) {
                for (int x = 0; x < playfield.getFieldMatrix()[y].length; x++) {
                    if (input.equals(playfield.getFieldMatrix()[y][x].getFieldNumber())) {
//                     1. ALLE Felder sind active
//                     Alle Felder liegen innerhalb des playfields
                        for (int i = 0; i < ship.getSize(); i++) {
                            try {
                                //Abfrage, welche prüft ob das Feld auf der das Schiff gesetzt werden soll, deaktiviert ist. Falls ja:
                                //gibt die ganze Methode "false zurück".
                                if (!playfield.getFieldMatrix()[y][x + i].isActive()) {
                                    IO.println("Leider nicht möglich, das Schiff muss mindestens 1 Feld Abstand zum nächsten Schiff haben!");
                                    return false;
                                }
                                //Falls das Schiff mit der Größe nicht in das Array passt, fange die Fehlermeldung ab und gib folgendes aus...
                            } catch (ArrayIndexOutOfBoundsException e) {
                                IO.println("Das Schiff passt so nicht auf das Spielfeld, bitte neue koordinaten eingeben!!!");
                                return false;
                            }
                        }
                        // Setze Schiff

                        for (int i = 0; i < ship.getSize(); i++) {
                            playfield.getFieldMatrix()[y][x + i].setPlayerStatus(ship.getSign());
                            playfield.getFieldMatrix()[y][x + i].setOpponentStatus(ship.getSign());
                            playfield.getFieldMatrix()[y][x + i].setIsWater(false);
                            playfield.getFieldMatrix()[y][x + i].setHasShip(true);
                            playfield.getFieldMatrix()[y][x + i].setShipNumber(ship.getNumber());

                            opponentfield.getFieldMatrix()[y][x + i].setIsWater(false);
                            opponentfield.getFieldMatrix()[y][x + i].setHasShip(true);
                            opponentfield.getFieldMatrix()[y][x + i].setShipNumber(ship.getNumber());

                        }

//             Deaktiviere Felder um das Schiff herum
                        for (int i = (x - 1); i <= ship.getSize() + x; i++) {
                            for (int j = (y - 1); j < y + 2; j++) {
                                try {
                                    playfield.getFieldMatrix()[j][i].setActive(false);
                                    //Tetstweise eingebaut um zu sehen welche Felder deaktiviert werden
//                        playfield.getPlayField()[j][i].setStatus("F");
                                } catch (ArrayIndexOutOfBoundsException e) {

                                }
                            }
                        }
                    }
                }
            }

        } //false = vertikal
        else {
            for (int y = 0; y < playfield.getFieldMatrix().length; y++) {
                for (int x = 0; x < playfield.getFieldMatrix()[y].length; x++) {
                    if (input.equals(playfield.getFieldMatrix()[y][x].getFieldNumber())) {
                        for (int i = 0; i < ship.getSize(); i++) {
                            try {
                                //Abfrage, welche prüft ob das Feld auf der das Schiff gesetzt werden soll, deaktiviert ist. Falls ja:
                                //gibt die ganze Methode "false zurück".
                                if (!playfield.getFieldMatrix()[y + i][x].isActive()) {
                                    IO.println("Leider nicht möglich, das Schiff muss mindestens 1 Feld Abstand zum nächsten Schiff haben!");
                                    return false;
                                }
                                //Falls das Schiff mit der Größe nicht in das Array passt, fange die Fehlermeldung ab und gib folgendes aus...
                            } catch (ArrayIndexOutOfBoundsException e) {
                                IO.println("Das Schiff passt so nicht auf das Spielfeld, bitte neue koordinaten eingeben!!!");
                                return false;
                            }
                        }
                        // Setze Schiff
                        for (int i = 0; i < ship.getSize(); i++) {
                            playfield.getFieldMatrix()[y + i][x].setPlayerStatus(ship.getSign());
                            playfield.getFieldMatrix()[y + i][x].setOpponentStatus(ship.getSign());
                            playfield.getFieldMatrix()[y + i][x].setIsWater(false);
                            playfield.getFieldMatrix()[y + i][x].setHasShip(true);
                            playfield.getFieldMatrix()[y + i][x].setShipNumber(ship.getNumber());

                            opponentfield.getFieldMatrix()[y][x + i].setIsWater(false);
                            opponentfield.getFieldMatrix()[y][x + i].setHasShip(true);
                            opponentfield.getFieldMatrix()[y][x + i].setShipNumber(ship.getNumber());

                        }

                        // Deaktiviere Felder um das Schiff herum
                        for (int i = (y - 1); i <= ship.getSize() + y; i++) {
                            for (int j = (x - 1); j < x + 2; j++) {
                                try {
                                    playfield.getFieldMatrix()[i][j].setActive(false);
                                    //Tetstweise eingebaut um zu sehen welche Felder deaktiviert werden
//                        playfield.getPlayField()[i][j].setStatus("F");
                                } catch (ArrayIndexOutOfBoundsException e) {

                                }
                            }
                        }

                    }
                }
            }
        }
        playfield.printPlayField();

        return true;
    }
}

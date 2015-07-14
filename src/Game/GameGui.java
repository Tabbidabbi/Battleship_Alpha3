/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Gameobjects.Player.Player;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.*;
import Gameobjects.Playfield.*;
import Gameobjects.Ships.Ship;
import Main.BattleshipGui_old;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import Main.BattleshipGui_old;
import Main.MenuHandler;
import javax.swing.GroupLayout.SequentialGroup;

/**
 *
 * @author Tobias
 */
public class GameGui extends JPanel {

    BoxLayout boxLayout;

    JPanel playerPlayFieldPanel;
    JPanel[] playerPlayFieldArray;

    Game game;

    Settings gameSettings;

    JLabel playerListLabel;
    JButton[] playerButton;
    JPanel playerListPanel;

    JTextArea textOutputArea;
    JPanel textOutputPanel;
    JPanel midPanel;

    JLabel shipListLabel;
    JButton[] shipListButtons;
    JPanel shipListPanel;

    JPanel componentPanel;

    JButton menuButton, saveGameButton;
    JPanel buttonPanel;

    private PrintStream standardOut;

    public GameGui(Game game) {
        this.game = game;
        this.gameSettings = game.getGameSettings();
        setOpaque(false);
        GroupLayout gameGuiLayout = new GroupLayout(this);

        playerPlayFieldPanel = new JPanel();
        playerPlayFieldPanel.setOpaque(false);
        playerPlayFieldArray = new JPanel[gameSettings.getAmountOfPlayer()];
        for (int i = 0; i < game.getPlayerList().size(); i++) {
            playerPlayFieldArray[i] = game.getPlayerList().get(i).getPlayerPlayFieldGui();
        }

        playerPlayFieldPanel.add(playerPlayFieldArray[0]);

        playerListLabel = new JLabel("Spieler: ");
        playerListPanel = new JPanel();
//        playerListPanel.setMaximumSize(new Dimension(300, 200));
        playerListPanel.add(playerListLabel);
        playerListPanel.setLayout(new BoxLayout(playerListPanel, BoxLayout.Y_AXIS));
        playerButton = new JButton[gameSettings.getAmountOfPlayer()];
        for (int i = 0; i < playerButton.length; i++) {
            playerButton[i] = new JButton(game.getPlayerList().get(i).getName());
            playerListPanel.add(playerButton[i]);
        }

        textOutputArea = new JTextArea(10, 35);
        textOutputArea.setEditable(false);
//        PrintStream printStream = new PrintStream(new CustomOutputStream(textOutputArea));
//        standardOut = System.out;
//        System.setOut(printStream);
//        System.setErr(printStream);
//        printStream.println("Hallo Welt");

        textOutputPanel = new JPanel();
        textOutputPanel.setPreferredSize(new Dimension(200, 200));
        textOutputPanel.setOpaque(false);
        textOutputPanel.add(textOutputArea);

        shipListLabel = new JLabel("Schiffe: ");
        shipListPanel = new JPanel();
        shipListPanel.add(shipListLabel);
        shipListPanel.setLayout(new BoxLayout(shipListPanel, BoxLayout.Y_AXIS));
        shipListButtons = new JButton[gameSettings.getAmountOfAllShips()];
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < shipListButtons.length; j++) {
                shipListButtons[j] = new JButton(game.getPlayerList().get(i).getShips().get(j).getName());
                shipListPanel.add(shipListButtons[j]);
            }
        }

        menuButton = new JButton("Hauptmenü");
        menuButton.setActionCommand("Game-MainMenu");
        menuButton.setFont(new Font("Serif", 10, 13));
        menuButton.setBackground(Color.white);
        menuButton.setForeground(Color.black);
        saveGameButton = new JButton("Spiel Speichern");
        saveGameButton.setActionCommand("Game-SaveGame");
        saveGameButton.setFont(new Font("Serif", 10, 13));
        saveGameButton.setBackground(Color.white);
        saveGameButton.setForeground(Color.black);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(menuButton);
        buttonPanel.add(saveGameButton);

        setLayout(gameGuiLayout);
        gameGuiLayout.setVerticalGroup(
                gameGuiLayout.createSequentialGroup()
                .addGroup(gameGuiLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(playerPlayFieldPanel)
                        .addGroup(gameGuiLayout.createSequentialGroup()
                                .addComponent(textOutputPanel)
                                .addGroup(gameGuiLayout.createParallelGroup()
                                        .addComponent(playerListPanel)
                                        .addComponent(shipListPanel))
                        )
                )
                .addComponent(buttonPanel)
        );
        gameGuiLayout.setHorizontalGroup(
                gameGuiLayout.createSequentialGroup()
                .addComponent(playerPlayFieldPanel)
                .addGroup(gameGuiLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(textOutputPanel)
                        .addGroup(gameGuiLayout.createSequentialGroup()
                                .addComponent(playerListPanel)
                                .addComponent(shipListPanel))
                        .addComponent(buttonPanel))
        );

        gameGuiLayout.setAutoCreateGaps(true);
        gameGuiLayout.setAutoCreateContainerGaps(true);

        setVisible(true);
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setGameButtonListener(ActionListener l) {
        this.menuButton.addActionListener(l);
        this.saveGameButton.addActionListener(l);
    }

    public class CustomOutputStream extends OutputStream {

        private JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) throws IOException {
            // redirects data to the text area
            textArea.append(String.valueOf((char) b));
            // scrolls the text area to the end of data
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }
}

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
import Main.BattleshipGui_old;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import Main.BattleshipGui_old;
import Main.MenuHandler;
/**
 *
 * @author Tobias
 */
public class GameGui extends JPanel {

    
    
//    GridBagLayout gridBagLayout;
//    GridBagConstraints gbc;
    
    BoxLayout boxLayout;

    JPanel playerPlayFieldPanel;
    JPanel[] playerPlayFieldArray;
    
    
    Game game;
    
    Settings gameSettings;
    

    JLabel playerListLabel;
    JTextArea playerListArea;
    JPanel playerListPanel;

    JTextArea textOutputArea;
    JPanel textOutputPanel;

    JLabel shipListLabel;
    JTextArea shipListArea;
    JPanel shipListPanel;
    
    JPanel componentPanel;

    JButton menuButton, saveGameButton;
    JPanel buttonPanel;

    private PrintStream standardOut;

    public GameGui() {
//        setPreferredSize(new Dimension(1024, 768));
        game = new Game();
//        setOpaque(false);
//        gridBagLayout = new GridBagLayout();
//        gbc = new GridBagConstraints();
//        setLayout(gridBagLayout);
        boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxLayout);
        
        playerPlayFieldPanel = new JPanel();
        playerPlayFieldArray = new JPanel[Settings.getGameSettings().getAmountOfPlayer()];
        for (int i = 0; i < game.getPlayerList().size();i++) {
            playerPlayFieldArray[i] = game.getPlayerList().get(i).getPlayerPlayFieldGui();
        }
        
        playerPlayFieldPanel.add(playerPlayFieldArray[0]);
            
//        gbc.gridwidth = GridBagConstraints.REMAINDER;
//        gridBagLayout.setConstraints(playerPlayFieldPanel, gbc);

        playerListLabel = new JLabel("Spieler: ");
        playerListArea = new JTextArea(10, 10);
        playerListPanel = new JPanel();
        playerListPanel.setLayout(new BoxLayout(playerListPanel, BoxLayout.Y_AXIS));
        playerListPanel.add(playerListLabel);
        playerListPanel.add(playerListArea);
//        playerListPanel.setPreferredSize(new Dimension(150, 250));

        textOutputArea = new JTextArea(10, 35);
        textOutputArea.setEditable(false);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textOutputArea));
        standardOut = System.out;
        System.setOut(printStream);
        System.setErr(printStream);
        printStream.println("Hallo Welt");


        textOutputPanel = new JPanel();
        textOutputPanel.add(textOutputArea);
//        textOutputPanel.setPreferredSize(new Dimension(450, 250));

        shipListLabel = new JLabel("Schiffe: ");
        shipListArea = new JTextArea(10, 10);
        shipListPanel = new JPanel();
        shipListPanel.setLayout(new BoxLayout(shipListPanel, BoxLayout.Y_AXIS));
        shipListPanel.add(shipListLabel);
        shipListPanel.add(shipListArea);
//        shipListPanel.setPreferredSize(new Dimension(150, 250));
        
        
        componentPanel = new JPanel();
        componentPanel.setLayout(new BoxLayout(componentPanel, BoxLayout.X_AXIS));
        componentPanel.add(playerListPanel);
        componentPanel.add(textOutputPanel);
        componentPanel.add(shipListPanel);
        
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
        
        add(playerPlayFieldPanel);
        add(componentPanel);
        add(buttonPanel);

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

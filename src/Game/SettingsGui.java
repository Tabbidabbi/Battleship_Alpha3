/*
 * To change this license headerLabel, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Main.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import Game.*;
import Gameobjects.Player.Player;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.*;
import javax.swing.plaf.basic.BasicMenuUI;

/**
 *
 * @author Tobias
 */
public class SettingsGui extends JPanel {

    JLabel headerLabel;
    JPanel headerPanel;

    JComboBox ammountPlayerComboBox;
    String[] comboBoxItems = {"2", "3", "4", "5", "6"};
    JLabel playerComboBoxLabel = new JLabel("Anzahl der Spieler");
    JPanel playerComboBoxPanel;

    JLabel[] ammountPlayersLabel = {new JLabel("Spieler 1:"), new JLabel("Spieler 2:"), new JLabel("Spieler 3:"),
        new JLabel("Spieler 4:"), new JLabel("Spieler 5:"), new JLabel("Spieler 6:")};
    JTextField[] playerTextFields = new JTextField[6];
    JCheckBox[] kiCheckboxes = new JCheckBox[6];
    JPanel[] singlePlayerPanel = new JPanel[6];
    JPanel playerPanel;

    JSpinner[] setAmmountOfShipsSpinner;
    JLabel[] shipLabel = {new JLabel("Anzahl der Zerstörer:"),
        new JLabel("Anzahl der Fregatten:"), new JLabel("Anzahl der Korvetten:"),
        new JLabel("Anzahl der U-Boote:")};
    JPanel[] singleShipPanel = new JPanel[4];
    JPanel shipFieldsPanel;

    JLabel playFieldSizeLabel;
    JSpinner playFieldSizeSpinner;
    JPanel playFieldSizePanel;

    JPanel categoriePanel;

    JPanel backPanel;

    JButton backButton, resetSettingsButton, StartGameButton;
    JPanel buttonPanel;

    MainMenuGui mainMenuGUI;

    Settings gameSettings; 
    

    public SettingsGui() {
        setLayout(new FlowLayout());
        
        gameSettings = Settings.getGameSettings();
        headerLabel = new JLabel("Einstellungen");
        headerLabel.setFont(new Font("Serif", 25, 25));
        headerPanel = new JPanel();
        headerPanel.add(headerLabel);
        headerPanel.setOpaque(false);

        playerComboBoxPanel = new JPanel();
        ammountPlayerComboBox = new JComboBox(comboBoxItems);
        ammountPlayerComboBox.addItemListener(new ComboBoxHandler());
        ammountPlayerComboBox.setSelectedItem(comboBoxItems[0]);

        playerComboBoxPanel.add(playerComboBoxLabel);
        playerComboBoxPanel.add(ammountPlayerComboBox);

        playerPanel = new JPanel();
        playerPanel.setPreferredSize(new Dimension(250, 150));
        playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
        for (int i = 0; i < playerTextFields.length; i++) {
            playerTextFields[i] = new JTextField("Spieler" + (i + 1) ,10);
            playerTextFields[i].addActionListener(new PlayerTextFieldHandler());
            singlePlayerPanel[i] = new JPanel();
            kiCheckboxes[i] = new JCheckBox("KI");
            singlePlayerPanel[i].add(ammountPlayersLabel[i]);
            singlePlayerPanel[i].add(playerTextFields[i]);
            singlePlayerPanel[i].add(kiCheckboxes[i]);
            playerPanel.add(singlePlayerPanel[i]);
            if (i > 1) {
                playerTextFields[i].setEditable(false);
                kiCheckboxes[i].setEnabled(false);
            }

        }
        setAmmountOfShipsSpinner = new JSpinner[4];
        shipFieldsPanel = new JPanel();
        shipFieldsPanel.setLayout(new BoxLayout(shipFieldsPanel, BoxLayout.Y_AXIS));
        for (int i = 0; i < 4; i++) {
            setAmmountOfShipsSpinner[i] = new JSpinner();
            singleShipPanel[i] = new JPanel();
            singleShipPanel[i].add(shipLabel[i]);
            singleShipPanel[i].add(setAmmountOfShipsSpinner[i]);
            shipFieldsPanel.add(singleShipPanel[i]);
        }
        setAmmountOfShipsSpinner[0].setModel(new SpinnerNumberModel(gameSettings.getAmountOfDestroyer(), 0, 3, 1));
        setAmmountOfShipsSpinner[1].setModel(new SpinnerNumberModel(gameSettings.getAmountOfFrigate(), 0, 4, 1));
        setAmmountOfShipsSpinner[2].setModel(new SpinnerNumberModel(gameSettings.getAmountOfCorvette(), 0, 5, 1));
        setAmmountOfShipsSpinner[3].setModel(new SpinnerNumberModel(gameSettings.getAmountOfSubmarine(), 0, 6, 1));

        playFieldSizeLabel = new JLabel("Spielfeldgröße:");
        playFieldSizeSpinner = new JSpinner();
        playFieldSizeSpinner.addChangeListener(new PlayfieldSizeHandler());

        playFieldSizeSpinner.setModel(new SpinnerNumberModel(gameSettings.getPlayfieldSize(), 8, 26, 1));
        
        playFieldSizePanel = new JPanel();
        playFieldSizePanel.add(playFieldSizeLabel);
        playFieldSizePanel.add(playFieldSizeSpinner);
        shipFieldsPanel.add(playFieldSizePanel);

        categoriePanel = new JPanel();

        categoriePanel.setLayout(new BoxLayout(categoriePanel, BoxLayout.X_AXIS));
        categoriePanel.add(playerComboBoxPanel);
        categoriePanel.add(playerPanel);
        categoriePanel.add(shipFieldsPanel);

        backButton = new JButton("Hauptmenü");
        backButton.setActionCommand("Settings-MainMenu");
        backButton.setFont(new Font("Serif", 10, 13));
        backButton.setBackground(Color.white);
        backButton.setForeground(Color.black);
        StartGameButton = new JButton("Spiel Starten");
        StartGameButton.setActionCommand("Settings-StartGame");
        StartGameButton.setFont(new Font("Serif", 10, 13));
        StartGameButton.setBackground(Color.white);
        StartGameButton.setForeground(Color.black);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(backButton);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(StartGameButton);
        buttonPanel.add(Box.createHorizontalGlue());

        backPanel = new JPanel();
        backPanel.setPreferredSize(new Dimension(1200, 800));
        backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.Y_AXIS));
        backPanel.add(headerPanel);
        backPanel.add(categoriePanel);
//        backPanel.add(textFieldP);
        backPanel.add(Box.createRigidArea(new Dimension(0, 80)));
        backPanel.add(buttonPanel);
        backPanel.add(Box.createRigidArea(new Dimension(0, 80)));

        add(backPanel);

    }

    public void setListener(ActionListener l) {
        this.backButton.addActionListener(l);
        this.StartGameButton.addActionListener(l);
    }
public void setGameSettings(Settings gamesettings) {
    this.gameSettings = gamesettings;
}
    private class ComboBoxHandler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            int command = ammountPlayerComboBox.getSelectedIndex();

            if (e.getStateChange() == ItemEvent.SELECTED) {

                switch (command) {
                    case 0:
                        playerTextFields[2].setEditable(false);
                        playerTextFields[3].setEditable(false);
                        playerTextFields[4].setEditable(false);
                        playerTextFields[5].setEditable(false);

                        kiCheckboxes[2].setEnabled(false);
                        kiCheckboxes[3].setEnabled(false);
                        kiCheckboxes[4].setEnabled(false);
                        kiCheckboxes[5].setEnabled(false);
                        
                        gameSettings.setAmountOfPlayer(2);
                        break;
                    case 1:
                        playerTextFields[2].setEditable(true);
                        playerTextFields[3].setEditable(false);
                        playerTextFields[4].setEditable(false);
                        playerTextFields[5].setEditable(false);

                        kiCheckboxes[2].setEnabled(true);
                        kiCheckboxes[3].setEnabled(false);
                        kiCheckboxes[4].setEnabled(false);
                        kiCheckboxes[5].setEnabled(false);

                        gameSettings.setAmountOfPlayer(3);
                        break;
                    case 2:
                        playerTextFields[2].setEditable(true);
                        playerTextFields[3].setEditable(true);
                        playerTextFields[4].setEditable(false);
                        playerTextFields[5].setEditable(false);

                        kiCheckboxes[2].setEnabled(true);
                        kiCheckboxes[3].setEnabled(true);
                        kiCheckboxes[4].setEnabled(false);
                        kiCheckboxes[5].setEnabled(false);
                        
                        gameSettings.setAmountOfPlayer(4);
                        break;
                    case 3:
                        playerTextFields[2].setEditable(true);
                        playerTextFields[3].setEditable(true);
                        playerTextFields[4].setEditable(true);
                        playerTextFields[5].setEditable(false);

                        kiCheckboxes[2].setEnabled(true);
                        kiCheckboxes[3].setEnabled(true);
                        kiCheckboxes[4].setEnabled(true);
                        kiCheckboxes[5].setEnabled(false);
                        
                        gameSettings.setAmountOfPlayer(5);
                        break;
                    case 4:
                        playerTextFields[2].setEditable(true);
                        playerTextFields[3].setEditable(true);
                        playerTextFields[4].setEditable(true);
                        playerTextFields[5].setEditable(true);

                        kiCheckboxes[2].setEnabled(true);
                        kiCheckboxes[3].setEnabled(true);
                        kiCheckboxes[4].setEnabled(true);
                        kiCheckboxes[5].setEnabled(true);
                        
                        gameSettings.setAmountOfPlayer(6);
                        break;
                }
            }

        }
    }
    
    private class PlayerTextFieldHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String [] textFieldInput = new String[6];
            
            
            for (int i = 0; i < gameSettings.getAmountOfPlayer(); i++) {
                textFieldInput[i] = playerTextFields[i].getText();
//                gameSettings.setPlayerNames(textFieldInput[i]);
                
                
            }
//            String textField1 = playerTextFields[0].getText();
//            String textField2 = playerTextFields[1].getText();
//            String textField3 = playerTextFields[2].getText();
//            String textField4 = playerTextFields[3].getText();
//            String textField5 = playerTextFields[4].getText();
//            String textField6 = playerTextFields[5].getText();
            
            
            
            
            
            }
        }
    
    private class PlayfieldSizeHandler implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            
            int input1 = (int)playFieldSizeSpinner.getValue();
            
            
                gameSettings.setPlayfieldSize(input1);
                System.out.println(input1);
            
        }



            

            
            
        }
        
    }
        


    

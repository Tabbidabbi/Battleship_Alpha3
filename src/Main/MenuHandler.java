/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Game.Game;
import Game.GameGui;
import Game.InstructionsGui;
import Game.Settings;
import Game.SettingsGui;
import Gameobjects.Playfield.PlayerPlayfieldGui;
import Multimedia.BackgroundImagePanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Tobias
 */
public class MenuHandler extends JPanel implements ActionListener {
    
    JPanel panelContainer;
    MainMenuGui mainMenuGui;
    SettingsGui settingsGui;
    InstructionsGui instructionsGui;
    GameGui gameGui;
    PlayerPlayfieldGui playfieldGui;

    GridBagLayout gameGuiLayout;
    GridBagConstraints gridBagConstraints;

    CardLayout cardLayout;
    
    Settings gameSettings;
    
    Game newGame;
    
    
    public MenuHandler() {
        
        
        setOpaque(false);
        setBackground(Color.red);
        setPreferredSize(new Dimension(1500, 800));
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        mainMenuGui = new MainMenuGui();
        mainMenuGui.setOpaque(false);
        
        add(mainMenuGui, "menu");

        cardLayout.show(this, "menu");

        addMenuListener();

        setVisible(true);

    }

    private void addMenuListener() {
        this.mainMenuGui.setListener(this);
    }

    private void addSettingsGuiListener() {
        this.settingsGui.setListener(this);
    }
    private void addInstructionGuiListener() {
        this.instructionsGui.setListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {

            case "Menu-NewGame":
                this.settingsGui = new SettingsGui();
                add(settingsGui, "settings");
                addSettingsGuiListener();
                cardLayout.show(this, "settings");
                break;
            case "Menu-LoadGame":
                break;
            case "Menu-Instructions":
                instructionsGui = new InstructionsGui();
                add(instructionsGui, "instructions");
                addInstructionGuiListener();
                cardLayout.show(this, "instructions");
                break;
            case "Menu-ExitGame":
                    System.exit(0);
                break;
            case "Settings-MainMenu":
                    cardLayout.show(this, "menu");
                break;
            case "Settings-StartGame":
//                settingsGui.setAmountOfPlayer(4);
                System.out.println("Hallo");
                System.out.println(settingsGui);
                this.gameSettings = new Settings(settingsGui);
                System.out.println(gameSettings);
                this.newGame =   new Game(gameSettings);
                    add(newGame.getGameGui(), "newGame");
                    cardLayout.show(this, "newGame");
                    break;
            case "Instructions-MainMenuButton":
                    cardLayout.show(this, "menu");
                break;

        }

    }

}
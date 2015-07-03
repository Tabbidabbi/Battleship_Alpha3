/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Multimedia.BackgroundImagePanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Game.*;
import Gameobjects.Playfield.*;
/**
 *
 * @author Tobias
 */
public class BattleshipGui extends JFrame{
    
    BackgroundImagePanel backgroundImagePanel;
    JPanel panelContainer;
    MainMenuGui mainMenuGui;
    SettingsGui settingsGui;
    InstructionsGui instructionsGui;
    GameGui gameGui;
    PlayerPlayfieldGui playfieldGui;
    
    GridBagLayout gameGuiLayout;
    GridBagConstraints gridBagConstraints;
    
    CardLayout cardLayout;

    public BattleshipGui() {
        setTitle("Battleship");
        setLayout(null);
        setBounds(450, 50, 1024, 768);
        setContentPane( backgroundImagePanel = new BackgroundImagePanel("G:\\hs\\Prog2\\Battleship_Alpha2\\Images\\background.jpg"));
        
        mainMenuGui = new MainMenuGui();
        mainMenuGui.setOpaque(false);
        
        settingsGui = new SettingsGui();
//        settingsGui.setPreferredSize(new Dimension(800, 600));
        instructionsGui = new InstructionsGui();
        
        gameGui = new GameGui();
        
        playfieldGui = new PlayerPlayfieldGui();
        
        
        
        
        cardLayout = new CardLayout();
        panelContainer = new JPanel(cardLayout);
//        panelContainer.setPreferredSize(getSize());
        panelContainer.setOpaque(false);
        panelContainer.add(mainMenuGui, "menu");
        panelContainer.add(settingsGui, "settings");
        panelContainer.add(instructionsGui, "instructions");
        panelContainer.add(gameGui, "newGame");
        panelContainer.add(playfieldGui, "playfield");
        
        cardLayout.show(panelContainer, "menu");
        
        
        
        add(panelContainer);
        addListener();
        
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void addListener() {
        this.mainMenuGui.setMenuButtonListener(new MenuHandler());
        this.settingsGui.setSettingsButtonListener(new MenuHandler());
        this.instructionsGui.setInstructionsButtonListener(new MenuHandler());
    }

    class MenuHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String command = e.getActionCommand();
            
            switch(command) {
                
                case "Menu-NewGame":
                    cardLayout.show(panelContainer, "newGame");
                    break;
                case "Menu-LoadGame":
                    break;
                case "Menu-Settings":
                    cardLayout.show(panelContainer, "settings");
                    break;
                case "Menu-Instructions":
                    cardLayout.show(panelContainer, "instructions");
                    break;
                case "Menu-ExitGame":
                    System.exit(0);
                    break;
                case "Settings-MainMenu":
                    cardLayout.show(panelContainer, "menu");
                    break;
                case "InstructionsMainMenuButton":
                    cardLayout.show(panelContainer, "menu");
                    break;
                    
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        BattleshipGui battleshipGui = new BattleshipGui();
    }
    
}

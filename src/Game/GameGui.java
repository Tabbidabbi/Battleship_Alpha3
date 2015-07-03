/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.*;
import Gameobjects.Playfield.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author Tobias
 */
public class GameGui extends JPanel {

    GridBagLayout gridBagLayout;
    GridBagConstraints gbc;

    PlayerPlayfieldGui playerPlayFieldPanel;

    JPanel playerListPanel;

    JTextArea textOutputArea;
    JPanel textOutputPanel;

    JPanel shipListPanel;

    JPanel buttonPanel;
    
    private PrintStream standardOut;

    public GameGui() {
        setPreferredSize(new Dimension(1024, 768));
        setOpaque(false);
        gridBagLayout = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(gridBagLayout);

        playerPlayFieldPanel = new PlayerPlayfieldGui();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(playerPlayFieldPanel, gbc);

        playerListPanel = new JPanel();
        playerListPanel.setBackground(Color.red);
        playerListPanel.setPreferredSize(new Dimension(150, 250));
        
        textOutputArea = new JTextArea(10,35);
        textOutputArea.setEditable(false);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textOutputArea));
        standardOut = System.out;
        System.setOut(printStream);
        System.setErr(printStream);
        
        printStream.println("Hallo Welt");

        textOutputPanel = new JPanel();
        textOutputPanel.add(textOutputArea);
        textOutputPanel.setPreferredSize(new Dimension(450, 250));

        shipListPanel = new JPanel();
        shipListPanel.setBackground(Color.blue);
        shipListPanel.setPreferredSize(new Dimension(150, 250));


        add(playerPlayFieldPanel);
        add(playerListPanel);
        add(textOutputPanel);
        add(shipListPanel);

        setVisible(true);
    }

    public class CustomOutputStream extends OutputStream {
    private JTextArea textArea;
     
    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }
     
    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        textArea.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
}

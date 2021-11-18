package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends JPanel implements ActionListener {
    private Color darkGray = new Color(54, 54, 54);
    private Color lightGray = new Color(200, 200, 200);
    private JButton newButton;
    private JButton checkButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton levelButton;
    private JButton exitButton;
    private GUI gui;
    private Font font;
    private Image img = Toolkit.getDefaultToolkit().createImage("src/main/ui/images/Main_Background.gif");
    private List<JButton> buttons;

    public MainPanel(GUI gui) {
        this.gui = gui;
        Icon logo = new ImageIcon("src/main/ui/images/Parsec Logo.png");
//        JLabel label = new JLabel(logo);
//        label.setBounds(80, 110, 142, 29);
//        add(label);
        setLayout(null);
        buttonsSetUp();
        for (JButton next : buttons) {
            add(next);
        }

        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setPreferredSize(new Dimension(300, 539));
    }

    @SuppressWarnings("methodlength")
    public void buttonsSetUp() {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/ui/fonts/Nagoda.ttf"));
        } catch (FontFormatException e) {
            System.out.println("Font not accepted");
        } catch (IOException e) {
            System.out.println("IOException Caught");
        }
        newButton = new JButton("New Trip");
        checkButton = new JButton("Trip Logs");
        levelButton = new JButton("Colony Levels");
        saveButton = new JButton("Save Changes");
        loadButton = new JButton("Load Trips");
        exitButton = new JButton("Quit");
        buttons = new ArrayList<>();
        buttons.add(exitButton);
        buttons.add(loadButton);
        buttons.add(saveButton);
        buttons.add(levelButton);
        buttons.add(checkButton);
        buttons.add(newButton);
        int y = 485;
        for (JButton next : buttons) {
            next.setBackground(darkGray);
            next.setBorderPainted(false);
            next.setForeground(lightGray);
            next.setFont(font.deriveFont(18f));
            next.setFocusPainted(false);
            next.setBounds(20, y, 260, 35);
            next.addActionListener(this);
            y -= 45;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newButton) {
            gui.switchToNewPanel();
        }
        if (e.getSource() == checkButton) {
            gui.switchToLogPanel();
        }
        if (e.getSource() == levelButton) {
            gui.switchToLevelPanel();
        }
        if (e.getSource() == saveButton) {
            gui.switchToSavePanel();
        }
        if (e.getSource() == loadButton) {
            gui.switchToLoadPanel();
        }
        if (e.getSource() == exitButton) {
            gui.switchToQuitPanel();
        }
    }
}
package views.swing;

import controllers.SwingController;
import views.swing.viewElement.JCreateButton;
import views.swing.viewElement.JCreateTextArea;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by dkotenko on 12/4/18.
 */
public class CreateWindow extends JFrame {
    private JFrame frame;
    public CreateWindow() {
        super("Swingy");
        frame = this;
        SwingController swingController = new SwingController();
        JCreateTextArea inputNameHero = new JCreateTextArea();
        JLabel enterNameHero = new JLabel("Enter name Hero :");
        JLabel selectClass = new JLabel("Select class :");
        JRadioButton warriorButton = new JRadioButton("Warrior");
        JRadioButton druidButton = new JRadioButton("Druid");
        JRadioButton hunterButton = new JRadioButton("Hunter");
        JCreateButton createButton = new JCreateButton("Create");
        JCreateButton backButton = new JCreateButton("Back");
        ButtonGroup group = new ButtonGroup();

        group.add(warriorButton);
        group.add(druidButton);
        group.add(hunterButton);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        try {
            JLabel background = new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/backCreate.jpg"))));
            setContentPane(background);
        } catch (IOException e) {
            e.printStackTrace();
        }

        enterNameHero.setFont(new Font("Luminari", Font.BOLD, 22));
        enterNameHero.setForeground(Color.ORANGE);
        enterNameHero.setLocation(80,90);
        enterNameHero.setSize(300,20);

        selectClass.setFont(new Font("Luminari", Font.BOLD, 22));
        selectClass.setForeground(Color.ORANGE);
        selectClass.setLocation(80,100);
        selectClass.setSize(300,160);

        inputNameHero.setSize(250, 40);
        inputNameHero.setLocation(300, 80);
        inputNameHero.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null || inputNameHero.getText().length() >= 15) {
                    return;
                }

                super.insertString(offs, str, a);
            }
        });

        warriorButton.setLocation(300, 160);
        warriorButton.setSize(250,40);
        warriorButton.setFont(new Font("Luminari", Font.BOLD, 20));
        warriorButton.setSelected(true);
        warriorButton.setForeground(Color.ORANGE);
        warriorButton.setActionCommand("1");
        druidButton.setLocation(300, 200);
        druidButton.setSize(250,40);
        druidButton.setFont(new Font("Luminari", Font.BOLD, 20));
        druidButton.setForeground(Color.ORANGE);
        druidButton.setActionCommand("2");
        hunterButton.setLocation(300, 240);
        hunterButton.setSize(250,40);
        hunterButton.setFont(new Font("Luminari", Font.BOLD, 20));
        hunterButton.setForeground(Color.ORANGE);
        hunterButton.setActionCommand("3");

        createButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String pClass = group.getSelection().getActionCommand();
                swingController.createHero(inputNameHero.getText(), Integer.parseInt(pClass));
            }
        });
        createButton.setLocation(220, 310);
        createButton.setSize(160,40);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                swingController.toMainWindow(frame);
            }
        });
        backButton.setLocation(220,380);
        backButton.setSize(160,40);

        add(warriorButton);
        add(druidButton);
        add(hunterButton);
        add(inputNameHero);
        add(selectClass);
        add(enterNameHero);
        add(createButton);
        add(backButton);
    }
}

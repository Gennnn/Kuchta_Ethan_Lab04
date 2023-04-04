package me.ethan.fortuneteller;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl;
    JPanel displayPnl;
    JTextArea fortuneOut;
    JScrollPane fortuneScroller;
    JPanel actionPnl;
    JButton fortuneBtn;
    JButton quitBtn;
    JPanel header;
    JLabel imageLabel;
    int lastFortune = 0;
    int genInt;
    ArrayList<String> fortuneArray;
    JButton readFortune;
    JFrame frame = new JFrame();
    JButton button = new JButton("Tell my fortune!");

    public FortuneTellerFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        createTellerPanel();
        createFourtunePanel();
        createActionPanel();
        fortuneArray = new ArrayList<>();
        fortuneArrayGen(fortuneArray);
        c.insets = new Insets(2,2,2,2);

        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        mainPnl.add(header, c);
        c.gridheight = 4;
        c.gridwidth = 3;
        c.gridy = 1;
        c.ipadx = 0;


        mainPnl.add(displayPnl, c);
        c.gridwidth = 1;
        c.gridy = 5;
        c.ipady = 20;
        c.ipadx = 0;
        mainPnl.add(actionPnl, c);
        add(mainPnl);
        setSize(750,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static ArrayList fortuneArrayGen(ArrayList<String> array) {
        array.add("A windfall of lunchmeat awaits.");
        array.add("Your next shower will be interrupted by a large, mildly poisonous insect.");
        array.add("Your organs will be harvested and marketed as souvenirs to the Xeaibobia Tribe of New Guinea.");
        array.add("There’s no time like 1853 – The year or the army time, it’s up to you.");
        array.add("You won’t have enough to cover your tab. Wear running shoes.");
        array.add("A kangaroo will play a pivotal role in the weekend.");
        array.add("You will be killed by Drop Bears.");
        array.add("Your exciting plans for the weekend bore the planets.");
        array.add("Watch more TV and pay less attention to your family.");
        array.add("Every time you lay your head on the pillow, a luminous red dot appears on your forehead.");
        array.add("You will be asked to dance by a stranger wearing a sandwich board.");
        array.add("The Feds want to talk about your surfing habits.");
        array.add("You will buy some minors some alcohol… sorry that should be miners.");
        return array;
    }


    private void createTellerPanel() {
        header = new JPanel();
        header.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        ImageIcon tellerImage = new ImageIcon("teller.png");
        Image timage = tellerImage.getImage();
        Image ntimage = timage.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        ImageIcon newTellerImage = new ImageIcon(ntimage);
        JLabel tellerText = new JLabel("Fortune Teller", SwingConstants.CENTER);
        tellerText.setFont(new Font("Helvetica", Font.BOLD, 40));
        header.setBorder(new BevelBorder(BevelBorder.LOWERED));
        imageLabel = new JLabel(newTellerImage);

        header.add(imageLabel);
        header.add(tellerText);
        header.setPreferredSize(new Dimension(700, 200));
    }
    private void createFourtunePanel() {
        displayPnl = new JPanel();
        displayPnl.setLayout(new GridLayout(1,2));
        fortuneOut = new JTextArea();
        fortuneOut.setEditable(false);
        fortuneOut.setLineWrap(true);
        fortuneOut.setWrapStyleWord(true);
        fortuneOut.setFont(new Font("Helvetica", Font.PLAIN, 20));
        fortuneOut.setBackground(UIManager.getColor ( "Panel.background" ));
        fortuneScroller = new JScrollPane(fortuneOut);
        fortuneScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        fortuneScroller.setBorder(new BevelBorder(BevelBorder.RAISED));
        fortuneScroller.setBackground(Color.lightGray);
        fortuneScroller.setPreferredSize(new Dimension(700,400));
        displayPnl.add(fortuneScroller);
    }
    private void createActionPanel() {
        actionPnl = new JPanel();
        actionPnl.setLayout(new BorderLayout());
        JPanel actionPnlInternal = new JPanel();
        actionPnlInternal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        fortuneBtn = new JButton("Tell My Fortune!");
        fortuneBtn.addActionListener(
                (ActionEvent ae) ->
                {
                    Random rndInt = new Random();
                    do {
                        genInt = rndInt.nextInt(12);
                    } while (lastFortune == genInt);
                    lastFortune = genInt;
                    fortuneOut.append(fortuneArray.get(genInt) + "\n\n");
                }
        );
        quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font("Helvetica", Font.PLAIN, 35));
        fortuneBtn.setFont(new Font("Helvetica", Font.PLAIN, 35));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        actionPnl.setBorder( new BevelBorder(BevelBorder.LOWERED));
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        actionPnlInternal.add(fortuneBtn,c);
        c.gridx = 1;
        actionPnlInternal.add(quitBtn, c);
        actionPnl.add(actionPnlInternal, BorderLayout.CENTER);
        actionPnl.setPreferredSize(new Dimension(700, 100));
    }



}





class TellFortune implements ActionListener {
    public void actionPerformed(ActionEvent ae) {
        System.out.println();
    }
}



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel textPanel;
    private JPanel buttonPanel;
    private JLabel label;
    private Land map;
    private Human player;
    private ArrayList<Goblin> gobs;
    private JButton northButton;
    private JButton southButton;
    private JButton eastButton;
    private JButton westButton;
    public GUI(Land l1, Human h1, ArrayList<Goblin> g1){
        gobs = g1;
        player = h1;
        map = l1;
        frame = new JFrame();
        northButton = new JButton("North");
        northButton.addActionListener(this);
        southButton = new JButton("South");
        southButton.addActionListener(this);
        westButton = new JButton("West");
        westButton.addActionListener(this);
        eastButton = new JButton("East");
        eastButton.addActionListener(this);
        label = new JLabel(map.toString());
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        textPanel = new JPanel();
        buttonPanel = new JPanel();
        textPanel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        textPanel.setLayout(new GridLayout(0,1));
        buttonPanel.setLayout(new GridLayout(0,2));
        textPanel.add(label);
        buttonPanel.add(northButton);
        buttonPanel.add(eastButton);
        buttonPanel.add(southButton);
        buttonPanel.add(westButton);
        mainPanel.add(textPanel);
        mainPanel.add(buttonPanel);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Human VS Goblins");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == northButton){
            if(player.move("n", map)) {
                for (int a = 0; a < gobs.size(); a++) {
                    gobs.get(a).move(map);
                    if (player.getHealth() <= 0) {
                        break;
                    }
                }
            }
        } else if(e.getSource() == southButton){
            if(player.move("s", map)) {
                for (int a = 0; a < gobs.size(); a++) {
                    gobs.get(a).move(map);
                    if (player.getHealth() <= 0) {
                        break;
                    }
                }
            }
        } else if(e.getSource() == eastButton){
            if(player.move("e", map)) {
                for (int a = 0; a < gobs.size(); a++) {
                    gobs.get(a).move(map);
                    if (player.getHealth() <= 0) {
                        break;
                    }
                }
            }
        } else if(e.getSource() == westButton){
            if(player.move("w", map)) {
                for (int a = 0; a < gobs.size(); a++) {
                    gobs.get(a).move(map);
                    if (player.getHealth() <= 0) {
                        break;
                    }
                }
            }
        }
        label.setText(map.toString());
        if(player.getHealth()<=0){
            buttonPanel.setVisible(false);
            JLabel death = new JLabel("You have died!");
            textPanel.add(death);
        }
    }
}

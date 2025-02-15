import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
///import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
///import javax.swing.JTextField;
//import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class PlayerMenu extends JFrame{
    //Fonts use on the PlayerMenu
    final private Font ButtonFont= new Font("Segoe Print",Font.BOLD,18);
    final private  Font PrincipalMeniuFont = new Font("Script Bold Italic",Font.BOLD,35);
    Color customColor2=new Color(170, 0, 0);
    Color customColor1=new Color(0, 100, 0);
    Color customColor=new Color(255,255,224);
    public void initialize(){
        ///Creating Frame Panel for the Players Menu and an auxiliar Panel
        JPanel Player=new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw the background image
                Image image = new ImageIcon("images/PlayerMenu.png").getImage();
                g.drawImage(image, 0,0, getWidth(), getHeight(), this);
            }
        };
        JPanel NOP= new JPanel();
        NOP.setOpaque(false);
        NOP.setLayout(new BoxLayout(NOP,BoxLayout.Y_AXIS));
        NOP.add(Box.createRigidArea(new Dimension(0,70)));
        //Title label
        JLabel Title= new JLabel("Who´s your target?");
        Title.setFont(PrincipalMeniuFont);
        Title.setForeground(customColor);
        Title.setAlignmentX(Component.CENTER_ALIGNMENT);
        Title.setAlignmentY(Component.CENTER_ALIGNMENT);
        NOP.add(Title);
        ///create a space between Title and Button
        NOP.add(Box.createRigidArea(new Dimension(0,370)));

        ///Number of players Buttons
        JButton btPlayer1=new JButton("CPU");
        btPlayer1.setFont(ButtonFont);
        btPlayer1.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e) {
                OnePlayerGame G1 = new OnePlayerGame();
                G1.setVisible(true);
                G1.initialize();  
            }
        });
        btPlayer1.setBackground(customColor1);


        JButton btPlayer2=new JButton("SecondPlayer");
       
        btPlayer2.setFont(ButtonFont);
        btPlayer2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                TwoPlayerGame G2 = new TwoPlayerGame();
                G2.setVisible(true);  
                G2.initialize();
            }
        });
        btPlayer2.setBackground(customColor2);


        //Buttons added in a Button Panel
          JPanel buttonsPanel=new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2,0,5));
        buttonsPanel.add(btPlayer1);
        buttonsPanel.add(btPlayer2);
        NOP.add(buttonsPanel); 
        //Add everything in Player
        Player.add(NOP);


        add(Player);

        setTitle("Russian Roullete");
        setSize(1920,1080);
        setMinimumSize(new Dimension(300,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}

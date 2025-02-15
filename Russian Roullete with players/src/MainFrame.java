import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
///import java.awt.event.ActionListener;

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

//import javafx.scene.layout.Border;

public class MainFrame  extends JFrame{
    //Fonts use on the Main Menu
    final private Font ButtonFont= new Font("Segoe Print",Font.BOLD,18);
    final private Font PrincipalMeniuFont= new Font("Old English Text MT",Font.BOLD,35);
    public void initialize(){
        //Create the Main Menu of the Game
        JPanel mainPanel= new JPanel(new BorderLayout());
        JPanel StartPage=new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw the background image
                Image image = new ImageIcon("images/MainMenuBackground.png").getImage();
                g.drawImage(image, 0,0, getWidth(), getHeight(), this);
            }
        };
        StartPage.setLayout(new BoxLayout(StartPage, BoxLayout.Y_AXIS));
        
        //Title of the game
        JLabel Title=new JLabel("Welcome to Russian Roullete");
        Title.setFont(PrincipalMeniuFont);
        Color customColor=new Color(255,255,224);
        Title.setForeground(customColor);
        Title.setAlignmentX(Component.CENTER_ALIGNMENT);
        Title.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        StartPage.add(Box.createRigidArea(new Dimension(0,20)));
        StartPage.add(Title);

        //create space between title and button
        StartPage.add(Box.createRigidArea(new Dimension(0,350)));
        
        ///Start Button/Play Button
        JButton btPlay=new JButton("Play");
        btPlay.setFont(ButtonFont);
        btPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerMenu PlayerMenu = new PlayerMenu();
                PlayerMenu.setVisible(true);
                PlayerMenu.initialize();  
            }

        });
        btPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
        btPlay.setAlignmentY(Component.CENTER_ALIGNMENT);
        btPlay.setBackground(customColor);
        StartPage.add(btPlay);
        
        //Button added in a Button Panel

        ///Settings for Main Menu and added the information
        mainPanel.add(StartPage);
        add(mainPanel);
        
        setTitle("Russian Roullete");
        setSize(1920,1080);
        setMinimumSize(new Dimension(300,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
///import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
///import javax.swing.JTextField;
//import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class OnePlayerGame extends JFrame {
    ///Used fonts and colors
    final private Font ButtonFont= new Font("Segoe Print",Font.BOLD,18);
    final private Font GameTextFont= new Font("Handwriting",Font.BOLD,35);
    Color customColor=new Color(255,255,224);
    Color customColor2=new Color(170, 0, 0);
    public void initialize(){

        ///creating the principal Jpanel and a second one that control the main one
        JPanel OnePlayer= new JPanel();
        JPanel Game=new JPanel();
        ///About background of the layer
        OnePlayer.setBackground(Color.DARK_GRAY);
        Game.setBackground(Color.DARK_GRAY);
        Game.setLayout(new BoxLayout(Game,BoxLayout.Y_AXIS));

        ///Shot Button making

        JButton Shot=new JButton("Shot");
        Shot.setFont(ButtonFont);
        ///TextBox making for after the pressing the button
        JLabel GameText=new JLabel();
        GameText.setForeground(customColor2);
        GameText.setFont(GameTextFont);

        ///creating a label for a gif in a consequence of pressing the button
        JLabel Photoending = new JLabel();

        ///what button do
        Shot.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e) {
                ///creating a variable that make random numbers and used the gunshot class
                Random rand=new Random();
                Gunshot g1= new Gunshot(rand.nextInt(6)+1,rand.nextInt(6)+1);
                    if(g1.GetBullet()!=g1.GetSpot()){
                        //The case you escape from being shot by the gun
                        ImageIcon gifIcon = new ImageIcon("images/gifshot.gif");
                        Photoending.setIcon(gifIcon);
                        GameText.setText("YOU SURVIVED!!");
                        
                    }else{
                        ///If that condition is false you died so I put a funny image
                       
                        ImageIcon imageIcon = new ImageIcon("images/lama ending.jpeg");

                        Image image = imageIcon.getImage(); 
                        Image scaledImage = image.getScaledInstance(400, 400, Image.SCALE_SMOOTH); 
                        ImageIcon scaledIcon = new ImageIcon(scaledImage); 

                        ///changing the label content
                        Photoending.setIcon(scaledIcon);
                        GameText.setText("YOU DIED!!!");
                        Game.remove(Shot);

                    }

            }    
            
        });

        Shot.setAlignmentX(CENTER_ALIGNMENT);
        Game.add(Box.createRigidArea(new Dimension(0,50)));
        Game.add(GameText);
        Shot.setBackground(customColor);
        Shot.setAlignmentX(CENTER_ALIGNMENT);
        Game.add(Box.createRigidArea(new Dimension(0,50)));
        Game.add(Photoending);
        Game.add(Box.createRigidArea(new Dimension(0,50)));
        Game.add(Shot);
        OnePlayer.add(Game);
        add(OnePlayer);

        
        setTitle("Russian Roullete");
        setSize(1920,1080);
        setMinimumSize(new Dimension(1280,600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}

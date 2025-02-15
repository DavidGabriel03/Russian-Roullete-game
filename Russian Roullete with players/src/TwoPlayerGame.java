import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionListener;

import javax.swing.Action;
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
public class TwoPlayerGame  extends JFrame{
    final private Font ButtonFont= new Font("Segoe Print",Font.BOLD,18);
    final private  Font PrincipalMeniuFont = new Font("Old English Text MT",Font.BOLD,35);
    Color customColor2=new Color(170, 0, 0);
    Color customColor1=new Color(0, 100, 0);
    Color customColor=new Color(255,255,224);
    public void initialize(){
        JPanel TwoPlayer= new JPanel();
        JPanel Game=new JPanel();
        Game.setLayout(new BoxLayout(Game,BoxLayout.Y_AXIS));
        JButton Shot=new JButton("Shot");
        JLabel LoseText=new JLabel("YOU DIED!!!");
        JLabel Nexttry=new JLabel("YOU SURVIVED THIS TIME");
        Shot.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e) {
                Random rand=new Random();
                Gunshot g1= new Gunshot(rand.nextInt(6)+1,rand.nextInt(6)+1);
                    if(g1.GetBullet()==g1.GetSpot()){
                        ///You lose
                        Game.add(LoseText);
                        System.out.println("You lose");
                        Game.remove(Shot);
                    }else{
                        //You escape this time
                        Game.add(Nexttry);
                        System.out.println("You escape this time");
                    }
            }    
        }); 
        Game.add(Shot);
        TwoPlayer.add(Game);
        add(TwoPlayer);

        setTitle("Russian Roullete");
        setSize(1920,1080);
        setMinimumSize(new Dimension(300,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

package javavariado;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FontAnimation extends JPanel implements ActionListener {
    Timer timer;
    int x=1;
    float alpha=1;
    
    public FontAnimation(){
        timer=new Timer(8, this);
        timer.setInitialDelay(190);
        timer.start();
    }
    
    @Override
    public void paint (Graphics g){
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g ;
        
        Font font = new Font("Dialog", Font.PLAIN, x);
        g2d.setFont(font);
        
        FontMetrics fm= g2d.getFontMetrics();
        String s= "¡Hello world!";
        
        int w=(int) getSize().getWidth();
        int h=(int) getSize().getHeight();
        
        int stringWidth= fm.stringWidth(s);
        
        g2d.drawString (s, (w - stringWidth) /2, h /2);
    }
    
    public static void main (String[] args){
        JFrame frame = new JFrame("FontAnimation");
        frame.add(new FontAnimation());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        x+=1;
        alpha-= 0.0001;
        repaint();
    }
}
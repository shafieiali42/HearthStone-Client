package view.Animation;


import Main.ClientMain;
import view.CardView.CardImagePanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class AnimationOfRotation extends JPanel  {
    private static String cardName;
    static final double fps = 20;
    public static boolean running=true;
    public static void main(String[] args){
        AnimationOfRotation animationOfRotation = new AnimationOfRotation();
        animationOfRotation.setBackground(Color.gray);
//        test.setPreferredSize(new Dimension(1200, 715));
//        test.setBounds(0, 0, 1200, 715);
        ClientMain.getMyMainFrame().setContentPane(animationOfRotation);
    }


    static void update(JFrame frame) {
        while (running) {
            frame.repaint();
            frame.revalidate();
            try {
                Thread.sleep((long) (1000 / fps));
            } catch (InterruptedException e) {
                return;
            }
        }
    }




    private long lastUpdate = 0;
    int frame;



    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);
        if (lastUpdate==0)
            lastUpdate=System.nanoTime();
        long temp;
        while ((temp = System.nanoTime()-lastUpdate)>(1000000000/fps)){
            lastUpdate+=temp;
            frame++;
        }
        CardImagePanel back = null;
        try {
            back = new CardImagePanel(cardName,100,100,true,1,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new RotatedPic(0, 500, 500, 0,
                back).rotate(g2d,frame);

        g2d.setFont(new Font("TimesRoman", Font.ITALIC, 50));
        g2d.setColor(Color.black);
        g2d.drawString("Playing Card:)",550,600);
////        new RotatedPic(0, 500, 500, 0,
//                new SimplePainter(back)).paint(g2d,frame);
    }


    public static String getCardName() {
        return cardName;
    }

    public static void setCardName(String cardName) {
        AnimationOfRotation.cardName = cardName;
    }
}
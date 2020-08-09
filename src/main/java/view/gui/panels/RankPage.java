package view.gui.panels;

import Main.ClientMain;
import controller.controllers.Controller;
import utility.constant.Constant;
import utility.guiUtilities.LengthOfMessage;
import view.gui.panels.MenuPanel.MainMenuPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RankPage extends JPanel {


    private int width;
    private int height;
    private volatile boolean repaint;
    private JButton backBtn;
    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);




    public RankPage() {

        width = Constant.widthOfMainFrame;
        height = 5 * Constant.heightOfMainFrame;
        setSize(width, height);
        setBackground(Color.yellow);
//        setJScrollPane(new JScrollPane(this));
        setLayout(null);
        initBackBtn();

    }


    public void designBtn(JButton btn) {
        btn.setSize(90, 90);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);

    }

    private void initBackBtn() {
        backBtn = new JButton("Back");
        designBtn(backBtn);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMain.getMyMainFrame().setContentPane(new MainMenuPage());
            }
        });
        add(backBtn);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
//        if (Controller.isNeedRepaintScoreBoard()) {

//            Controller.getCurrentClient().sendShowScoreBoardRequest();
            drawScoreBoardPage(Controller.getRankedNames(), Controller.getRankedCups(), graphics2D);
//        }
    }


    private void drawScoreBoardPage(ArrayList<String> names, ArrayList<String> cups,
                                  Graphics2D g2d) {



        g2d.setFont(new Font("TimesRoman", Font.ITALIC, 25));
        g2d.setColor(Color.red);

        int ySpace = Constant.heightOfMainFrame / (names.size() + 1);
        String xSpace = "";
        for (int i = 0; i < 20; i++) {
            xSpace = xSpace + " ";
        }


        for (int i = 0; i < names.size(); i++) {
            if (names.get(i) != null) {
                String playerState = names.get(i) + xSpace + cups.get(i);
                int xCoordinate = (Constant.widthOfMainFrame - LengthOfMessage.lengthOfMessage(playerState, g2d)) / 2;
                g2d.drawString(playerState, xCoordinate, (i + 1) * ySpace);

            }
        }

    }


    //getter and setters
    //********************

    public boolean isRepaint() {
        return repaint;
    }

    public void setRepaint(boolean repaint) {
        this.repaint = repaint;
    }

}

package view.gui.panels.GamePage;

import utility.constant.Constant;

import javax.swing.*;
import java.awt.*;


public class LogPanel extends JPanel {




    private JScrollPane jScrollPane;
    private String log;
    private Color colorOfLogOfEnemy = Color.red;
    private Color getColorOfLogOfMyPlayer = Color.BLACK;

    public int getWidthOfLogPanel() {
        return Constant.WIDTH_OF_LOG_PANEL;
    }


    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }


    public LogPanel() {
        setLayout(null);
        setSize(Constant.WIDTH_OF_LOG_PANEL, Constant.HEIGHT_OF_LOG_PANEL);
        setBackground(Color.green);
        setJScrollPane(new JScrollPane(this));
        log = "";
    }


    private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        removeAll();
        drawString(g, log, 0, 0);
    }



    public JScrollPane getJScrollPane() {
        return jScrollPane;
    }

    public void setJScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }


    public int getHeightOfLogPanel() {
        return Constant.HEIGHT_OF_LOG_PANEL;
    }
}

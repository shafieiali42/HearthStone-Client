package view.gui.panels.GamePage;


import utility.constant.Constant;

import javax.swing.*;
import java.awt.*;

public class GamePage extends JPanel {


    public GamePage() {
        setSize(Constant.widthOfMainFrame, Constant.heightOfMainFrame);
        setLayout(null);
        LogPanel logPanel = (LogPanel) Constant.getPanels().get("LogPanel");
        logPanel.setPreferredSize(new Dimension(logPanel.getWidthOfLogPanel(), 1600));
        logPanel.setFocusable(true);
        logPanel.requestFocus();
        logPanel.setJScrollPane(new JScrollPane(logPanel));
        logPanel.getJScrollPane().setBounds(0,
                0, logPanel.getWidthOfLogPanel(), logPanel.getHeightOfLogPanel());
        logPanel.getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        logPanel.getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        logPanel.getJScrollPane().setBorder(null);
        logPanel.getJScrollPane().setFocusable(false);
        this.add(logPanel.getJScrollPane());

        PlayPanel playPanel = (PlayPanel) Constant.getPanels().get("PlayPanel");
        this.addPanel(playPanel, logPanel.getWidthOfLogPanel(), 0,
                PlayPanel.getWidthOfPlayPanel(), PlayPanel.getHeightOfPlayPanel());

        DeckAndEndTurnBtnPanel deckAndEndTurnBtnPanel =
                (DeckAndEndTurnBtnPanel) Constant.getPanels().get("DeckAndEndTurnBtnPanel");

        this.addPanel(deckAndEndTurnBtnPanel, logPanel.getWidthOfLogPanel() + playPanel.getWidthOfPlayPanel(), 0,
                Constant.WIDTH_OF_END_TURN_PANEL, Constant.HEIGHT_OF_END_TURN_PANEL);

    }


    public void addPanel(JPanel panel, int x, int y, int width, int height) {
        panel.setBounds(x, y, width, height);
        add(panel);
    }

}

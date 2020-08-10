package view.gui.panels.GamePage;


import utility.constant.Constant;
import javax.swing.*;
import java.awt.*;

public class GamePage extends JPanel {





    public GamePage(){
        setSize(Constant.widthOfMainFrame,Constant.heightOfMainFrame);
        setLayout(null);
        LogPanel.getInstance().setPreferredSize(new Dimension(LogPanel.getInstance().getWidthOfLogPanel(),1600));
        LogPanel.getInstance().setFocusable(true);
        LogPanel.getInstance().requestFocus();
        LogPanel.getInstance().setJScrollPane(new JScrollPane(LogPanel.getInstance()));
        LogPanel.getInstance().getJScrollPane().setBounds(0,
                0,LogPanel.getInstance().getWidthOfLogPanel(),LogPanel.getInstance().getHeightOfLogPanel());
        LogPanel.getInstance().getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        LogPanel.getInstance().getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        LogPanel.getInstance().getJScrollPane().setBorder(null);
        LogPanel.getInstance().getJScrollPane().setFocusable(false);
        this.add(LogPanel.getInstance().getJScrollPane());

        PlayPanel playPanel=(PlayPanel)Constant.getPanels().get("PlayPanel");
        this.addPanel(playPanel,LogPanel.getInstance().getWidthOfLogPanel(),0,
                PlayPanel.getWidthOfPlayPanel(),PlayPanel.getHeightOfPlayPanel());


        this.addPanel(DeckAndEndTurnBtnPanel.getInstance(),LogPanel.getInstance().getWidthOfLogPanel()+playPanel.getWidthOfPlayPanel(),0,
                Constant.WIDTH_OF_END_TURN_PANEL, Constant.HEIGHT_OF_END_TURN_PANEL);

    }


    public void addPanel(JPanel panel, int x, int y, int width, int height){
        panel.setBounds(x,y,width,height);
        add(panel);
    }

}

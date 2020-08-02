package view.gui.panels.myMainFrame;

import utility.constant.Constant;
import javax.swing.*;

public class MyMainFrame extends JFrame {


    private int width;
    private int height;


    public MyMainFrame() {
        this.initFrame();
    }

    private void initFrame() {
        this.loadFrame();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void loadFrame() {
        System.out.println("mainFrame");

        width = Constant.widthOfMainFrame;
        height = Constant.heightOfMainFrame;
        setDefaultCloseOperation(Constant.defaultCloseOperation);
        setResizable(Constant.resizable);
        setSize(width, height);
    }


}

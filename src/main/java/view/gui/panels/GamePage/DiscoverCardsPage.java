package view.gui.panels.GamePage;



import controller.controllers.Controller;
import controller.controllers.GamePartController;
import utility.constant.Constant;
import utility.guiUtilities.MethodsOfShowCardsOnPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DiscoverCardsPage extends JPanel {


    private boolean waiting=true;
    private String selectedWeapon="";
    public boolean getWaiting() {
        return waiting;
    }

    public String getSelectedWeapon() {
        return selectedWeapon;
    }

    public void setSelectedWeapon(String selectedWeapon) {
        this.selectedWeapon = selectedWeapon;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    private static DiscoverCardsPage discoverCardsPage=new DiscoverCardsPage();
    public static DiscoverCardsPage getInstance(){return discoverCardsPage;}

    private String firstCard;
    private String secondCard;
    private String thirdCard;

    private JButton okButton;
    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);



    private DiscoverCardsPage(){
        setLayout(null);
        setBackground(Color.gray);
        firstCard="";
        secondCard="";
        thirdCard="";
        initOkBtn();

    }


    public void reStartSetting(){
        firstCard="";
        secondCard="";
        thirdCard="";
        selectedWeapon="";
        waiting=true;
    }

    private void initOkBtn() {
        okButton = new JButton("DONE");
        okButton.setSize(Constant.WIDTH_OF_OK_BTN,Constant. HEIGHT_OF_OK_BTN);
        okButton.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        okButton.setBounds((Constant.widthOfMainFrame-Constant.WIDTH_OF_OK_BTN)/2,
                (Constant.heightOfMainFrame-200) ,
                Constant.WIDTH_OF_OK_BTN,
                Constant.HEIGHT_OF_OK_BTN);
        okButton.setForeground(colorOfTextOfBtn);
        okButton.setBackground(colorOfBtn);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendOkButtonDiscoverPageRequest();
//                ControllerOfMainComponents.setStatus(Status.PLAY_PAGE);
//                MyMainFrame.getInstance().setContentPane(GamePage.getInstance());

            }
        });
//        add(okButton);

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        MethodsOfShowCardsOnPanel.showCards(GamePartController.getListOfWeapons(),this,3,200,300);
        //        add(okButton);
    }

    public String getFirstCard() {
        return firstCard;
    }

    public void setFirstCard(String firstCard) {
        this.firstCard = firstCard;
    }

    public String getSecondCard() {
        return secondCard;
    }

    public void setSecondCard(String secondCard) {
        this.secondCard = secondCard;
    }

    public String getThirdCard() {
        return thirdCard;
    }

    public void setThirdCard(String thirdCard) {
        this.thirdCard = thirdCard;
    }

}

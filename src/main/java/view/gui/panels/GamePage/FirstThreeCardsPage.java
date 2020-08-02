package view.gui.panels.GamePage;

import utility.constant.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class FirstThreeCardsPage extends JPanel {




    private static FirstThreeCardsPage firstThreeCardsPage=new FirstThreeCardsPage();
    public static FirstThreeCardsPage getInstance(){return firstThreeCardsPage;}
    private String firstCard;
    private String secondCard;
    private String thirdCard;
    private boolean canChangeFirstCard=true;
    private boolean canChangeSecondCard=true;
    private boolean canChangeThirdCard=true;
    private JButton okButton;
    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);



    private FirstThreeCardsPage(){
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
        canChangeFirstCard=true;
        canChangeSecondCard=true;
        canChangeThirdCard=true;
    }

    private void initOkBtn() {
        okButton = new JButton("DONE");
        okButton.setSize(Constant.WIDTH_OF_OK_BTN,Constant. HEIGHT_OF_OK_BTN);
        okButton.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        okButton.setBounds((Constant.widthOfMainFrame-Constant.WIDTH_OF_OK_BTN)/2,
                              (Constant.heightOfMainFrame-200) ,
                Constant.    WIDTH_OF_OK_BTN,
                Constant.HEIGHT_OF_OK_BTN);
        okButton.setForeground(colorOfTextOfBtn);
        okButton.setBackground(colorOfBtn);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerOfMainComponents.setStatus(Status.PLAY_PAGE);
                MyMainFrame.getInstance().setContentPane(GamePage.getInstance());

            }
        });
        add(okButton);

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            MethodsOfShowCardsOnPanel.showCards(GamePartController.getFirstFriendlyThreeCards(),this,3,200,300);
        } catch (IOException e) {
            e.printStackTrace();
        }
        add(okButton);
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

    public boolean getCanChangeFirstCard() {
        return canChangeFirstCard;
    }

    public void setCanChangeFirstCard(boolean canChangeFirstCard) {
        this.canChangeFirstCard = canChangeFirstCard;
    }

    public boolean getCanChangeSecondCard() {
        return canChangeSecondCard;
    }

    public void setCanChangeSecondCard(boolean canChangeSecondCard) {
        this.canChangeSecondCard = canChangeSecondCard;
    }

    public boolean getCanChangeThirdCard() {
        return canChangeThirdCard;
    }

    public void setCanChangeThirdCard(boolean canChangeThirdCard) {
        this.canChangeThirdCard = canChangeThirdCard;
    }
}

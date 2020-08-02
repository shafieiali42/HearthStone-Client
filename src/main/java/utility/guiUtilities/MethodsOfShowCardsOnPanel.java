package utility.guiUtilities;


import view.CardView.CardImagePanel;
import view.gui.panels.CollectionPages.LittleCardPanel;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class MethodsOfShowCardsOnPanel {

    //this method used to show cards in shop and collection pages :))
    public static void showCards(ArrayList<String> cards, JPanel panel, int numOfCardInEveryRow) {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        int counter = 0;
        int xCoordinate = 10;
        int yCoordinate = 10;
        int xSapce = 170;
        int ySpace = 10;
        for (String cardName : cards) {
            counter++;
            CardImagePanel cardImagePanel = null;
            try {
                cardImagePanel = new CardImagePanel(cardName);
                addPanel(cardImagePanel, panel, xCoordinate, yCoordinate, cardImagePanel.getWidth(),
                        cardImagePanel.getHeight());
                if (counter % numOfCardInEveryRow == 0) {
                    xCoordinate = 10;
                    yCoordinate += cardImagePanel.getHeight() + ySpace;
                } else {
                    xCoordinate += xSapce;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

/*
    public static void showCards(ArrayList<String> cards, JPanel panel, int numOfCardInEveryRow, int width, int height) throws IOException {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        int counter = 0;
        int yCoordinate = (770 - height) / 2;
        int xSpace = (1400 - 3 * width) / 4;
        int xCoordinate = xSpace;
        for (String cardsName : cards) {
            counter++;
            CardImagePanel cardImagePanel = new CardImagePanel(cardsName, width, height, true,1,null);
            addPanel(cardImagePanel, panel, xCoordinate, yCoordinate, width,height);
            xCoordinate += xSpace + width;
        }
    }


    public static void showBackOfEnemyHandsCards(ArrayList<String> cards, JPanel panel, int numOfCardInEveryRow, int typeOfBackOfCard) throws IOException {
        int counter = 0;
        int xCoordinate = 10;
        int yCoordinate = 0;
        int xSapce = 20;
        int ySpace = 10;


        yCoordinate = 10;
        for (String cardsName : cards) {
            counter++;
            CardImagePanel cardImagePanel = new CardImagePanel(PlayPanel.getInstance().getWidthOfEachCardHandsCards(),
                    PlayPanel.getInstance().getHeightOfEachCardHandsCards(), typeOfBackOfCard);

            addPanel(cardImagePanel, panel, xCoordinate, yCoordinate, cardImagePanel.getWidth(),
                    cardImagePanel.getHeight());

            if (counter % numOfCardInEveryRow == 0) {
                xCoordinate = 10;
                yCoordinate += cardImagePanel.getHeight() + ySpace;
            } else {
                xCoordinate += xSapce + PlayPanel.getInstance().getWidthOfEachCardHandsCards();
            }
        }

    }


    public static void showHandsCards(ArrayList<String> cards, JPanel panel, int numOfCardInEveryRow, Alliance alliance) throws IOException {
        int counter = 0;
        int xCoordinate = 10;
        int yCoordinate = 0;
        int xSpace = 20;
        int ySpace = 10;
        if (alliance.equals(Alliance.ENEMY)) {
            yCoordinate = 15;
        } else if (alliance.equals(Alliance.FRIENDLY)) {
            yCoordinate = 690;
        }
        for (String cardsName : cards) {
            counter++;
            CardImagePanel cardImagePanel = new CardImagePanel(cardsName,
                    PlayPanel.getInstance().getWidthOfEachCardHandsCards(),
                    PlayPanel.getInstance().getHeightOfEachCardHandsCards(), true, 1, alliance,counter,"");

//            CardPanel.getInstance().setBackground(Color.white);
            addPanel(cardImagePanel, panel, xCoordinate, yCoordinate, cardImagePanel.getWidth(),
                    cardImagePanel.getHeight());

            if (counter % numOfCardInEveryRow == 0) {
                xCoordinate = 10;
                yCoordinate += cardImagePanel.getHeight() + ySpace;
            } else {
                xCoordinate += xSpace + PlayPanel.getInstance().getWidthOfEachCardHandsCards();
            }
        }

    }


    public static void showBattleGroundCards(ArrayList<String> cards, JPanel panel, int numOfCardInEveryRow, Alliance alliance) throws IOException {
        int counter = 0;
        int xCoordinate = 50;
        int yCoordinate = 0;
        if (alliance.equals(Alliance.FRIENDLY)) {
            yCoordinate = 395;
        } else if (alliance.equals(Alliance.ENEMY)) {
            yCoordinate = 385 - 10 - PlayPanel.getInstance().getHeightOfEachCardGamePanel();
        }
        int xSapce = 50;
        int ySpace = 10;

        for (int i = 0; i < cards.size(); i++) {
            String cardsName = cards.get(i);
            counter++;
            CardImagePanel cardImagePanel = new CardImagePanel(cardsName,
                    PlayPanel.getInstance().getWidthOfEachCardGamePanel(),
                    PlayPanel.getInstance().getHeightOfEachCardGamePanel(),
                    true, 2, alliance, i + 1);
            cardImagePanel.repaint();
            cardImagePanel.revalidate();

//            CardPanel.getInstance().setBackground(Color.white);
            addPanel(cardImagePanel, panel, xCoordinate, yCoordinate, cardImagePanel.getWidth(),
                    cardImagePanel.getHeight());

//            System.out.println("X: "+xCoordinate+" Y: "+yCoordinate);

            if (counter % numOfCardInEveryRow == 0) {
                xCoordinate = 100;
                yCoordinate += cardImagePanel.getHeight() + ySpace;
            } else {
                xCoordinate += xSapce + PlayPanel.getInstance().getWidthOfEachCardGamePanel();
            }
        }
    }
*/

    public static void addPanel(JPanel originPanel, JPanel destinationPanel, int x, int y, int width, int height) {
        originPanel.setBounds(x, y, width, height);
        destinationPanel.add(originPanel);
    }

    public static void addPanel(LittleCardPanel originPanel, JPanel destinationPanel, int x, int y, int width, int height) {
        originPanel.setBounds(x, y, width, height);
        destinationPanel.add(originPanel);
    }


}

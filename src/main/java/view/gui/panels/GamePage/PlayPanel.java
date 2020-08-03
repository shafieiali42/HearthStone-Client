package view.gui.panels.GamePage;


import utility.constant.Constant;
import view.CardView.CardImagePanel;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class PlayPanel extends JPanel {



    static int WIDTH_OF_PLAY_PANEL = 1115;
    static int HEIGHT_OF_PLAY_PANEL = 770;

    private BufferedImage heroImage;
    private BufferedImage heroPowerImage;
    private BufferedImage weaponImage;
    private BufferedImage enemyHeroImage;
    private BufferedImage enemyHeroPowerImage;
    private BufferedImage enemyWeaponImage;
    private boolean needsToRepaint = true;
    private boolean needTimer = false;
    private int typeOfBackOfCards = 1;
    private boolean endTurn = false;
    private static PlayPanel playPanel = new PlayPanel();

    public static PlayPanel getInstance() {
        return playPanel;
    }

    String time = "";
    boolean needAnimation = false;

    private PlayPanel() {
        setLayout(null);
        setBackground(Color.gray);
        setSize(WIDTH_OF_PLAY_PANEL, HEIGHT_OF_PLAY_PANEL);
    }




    public void showFriendlyHeroImage() {

        CardImagePanel cardImagePanel = null;
        try {
            cardImagePanel = new CardImagePanel(GamePartController.getNameOfFriendlyHeroOfGameState(),
                    Constant.WIDTH_OF_HERO_IMAGE, Constant.HEIGHT_OF_HERO_IMAGE, "hero", Alliance.FRIENDLY);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MethodsOfShowCardsOnPanel.addPanel(cardImagePanel, this,
                Constant.X_COORDINATE_OF_HERO_IMAGE, Constant.Y_COORDINATE_OF_HERO_IMAGE, Constant.WIDTH_OF_HERO_IMAGE, Constant.HEIGHT_OF_HERO_IMAGE);
    }


    public void showEnemyHeroImage() {

        CardImagePanel cardImagePanel = null;
        try {
            cardImagePanel = new CardImagePanel(GamePartController.getNameOfEnemyHeroOfGameState(),
                    Constant.WIDTH_OF_HERO_IMAGE, Constant.HEIGHT_OF_HERO_IMAGE, "hero", Alliance.ENEMY);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MethodsOfShowCardsOnPanel.addPanel(cardImagePanel, this,
                Constant.X_COORDINATE_OF_ENEMY_HERO_IMAGE, Constant.Y_COORDINATE_OF_ENEMY_HERO_IMAGE,
                Constant.WIDTH_OF_HERO_IMAGE, Constant.HEIGHT_OF_HERO_IMAGE);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/main/resources/Assets/map1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        graphics2D.drawImage(image,0,0,1115,770,null);
        graphics2D.drawLine(0, Constant.HEIGHT_OF_HANDS_PANEL, Constant.WIDTH_OF_GAME_PANEL, Constant.HEIGHT_OF_HANDS_PANEL);

        graphics2D.drawLine(0, Constant. HEIGHT_OF_HANDS_PANEL +  Constant.HEIGHT_OF_GAME_PANEL / 2,
                Constant.WIDTH_OF_GAME_PANEL,  Constant.HEIGHT_OF_HANDS_PANEL + Constant. HEIGHT_OF_GAME_PANEL / 2);

        graphics2D.drawLine(0,  Constant.HEIGHT_OF_HANDS_PANEL +  Constant.HEIGHT_OF_GAME_PANEL,
                Constant.WIDTH_OF_GAME_PANEL,  Constant.HEIGHT_OF_HANDS_PANEL +  Constant.HEIGHT_OF_GAME_PANEL);


        if (needAnimation) {
            String[] strings = new String[1];
            AnimationOfRotation.main(strings);
            needAnimation = false;
            needsToRepaint = true;
        }


//        System.out.println(Thread.currentThread().getName());
//        if (endTurn){
//            Mapper.endTurn();
//            this.endTurn=false;
//        }

        if (needTimer) {
            graphics2D.setColor(Color.red);
            graphics2D.setFont(new Font("TimesRoman", Font.ITALIC, 50));
            graphics2D.drawString(time, 1050, 310);
            graphics2D.setColor(Color.black);
        }

        try {
            if (needsToRepaint) {
                this.removeAll();
                GamePartController.showFriendlyHandsCardInPlay(this, Constant. NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS);
                GamePartController.showFriendlyBattleGroundCardsInPlay(this, Constant. NUMBER_OF_CARDS_PER_ROW_GAME_PANEL);
                GamePartController.showEnemyBattleGroundCardsInPlay(this, Constant. NUMBER_OF_CARDS_PER_ROW_GAME_PANEL);
                GamePartController.showEnemyHandsCardInPlay(this,  Constant.NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS,
                        typeOfBackOfCards, GamePartController.getGameMode());

                this.revalidate();
                needsToRepaint = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        showFriendlyHeroImage();
        showEnemyHeroImage();

        GamePartController.showFriendlyWeaponOfGameState(this, Constant. WIDTH_OF_WEAPON_IMAGE,  Constant.HEIGHT_OF_WEAPON_IMAGE,
                Constant. X_COORDINATE_OF_WEAPON, Constant. Y_COORDINATE_OF_WEAPON);

        GamePartController.showEnemyWeaponOfGameState(this, Constant. WIDTH_OF_WEAPON_IMAGE,  Constant.HEIGHT_OF_WEAPON_IMAGE,
                Constant. X_COORDINATE_OF__ENEMY_WEAPON, Constant. Y_COORDINATE_OF_ENEMY_WEAPON);

        GamePartController.showFriendlyHeroPower(this,  Constant.WIDTH_OF_HERO_POWER_IMAGE, Constant. HEIGHT_OF_HERO_POWER_IMAGE,
                Constant.  X_COORDINATE_OF_HERO_POWER_IMAGE, Constant. Y_COORDINATE_OF_HERO_POWER_IMAGE);

        GamePartController.showEnemyHeroPower(this,  Constant.WIDTH_OF_HERO_POWER_IMAGE,  Constant.HEIGHT_OF_HERO_POWER_IMAGE,
                Constant.X_COORDINATE_OF_ENEMY_HERO_POWER_IMAGE, Constant. Y_COORDINATE_OF_ENEMY_HERO_POWER_IMAGE);


        graphics2D.setColor(Color.red);
        graphics2D.setFont(new Font("TimesRoman", Font.ITALIC, 25));
//        graphics2D.drawString(Administer.getHpOfCurrentFriendlyHeroInGameState() + "", X_COORDINATE_OF_HEAL_FIELD, Y_COORDINATE_OF_HEAL_FIELD);

    }


    //getter and setters
    //*********************


    public int getTypeOfBackOfCards() {
        return typeOfBackOfCards;
    }

    public void setTypeOfBackOfCards(int typeOfBackOfCards) {
        this.typeOfBackOfCards = typeOfBackOfCards;
    }

    public void setNeedAnimation(boolean needAnimation) {
        this.needAnimation = needAnimation;
    }

    public boolean getNeedsToRepaint() {
        return needsToRepaint;
    }

    public void setNeedsToRepaint(boolean needsToRepaint) {
        this.needsToRepaint = needsToRepaint;
    }

    public static int getWidthOfPlayPanel() {
        return WIDTH_OF_PLAY_PANEL;
    }

    public static int getHeightOfPlayPanel() {
        return HEIGHT_OF_PLAY_PANEL;
    }

    public boolean getNeedTimer() {
        return needTimer;
    }

    public void setNeedTimer(boolean needTimer) {
        this.needTimer = needTimer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public boolean isEndTurn() {
        return endTurn;
    }

    public void setEndTurn(boolean endTurn) {
        this.endTurn = endTurn;
    }
}

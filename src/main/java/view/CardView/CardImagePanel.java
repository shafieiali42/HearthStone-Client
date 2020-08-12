package view.CardView;


import Main.ClientMain;
import controller.Alliance;
import controller.controllers.Controller;
import controller.controllers.GamePartController;
import controller.controllers.Status;
import utility.constant.Constant;
import view.gui.panels.GamePage.DiscoverCardsPage;
import view.gui.panels.GamePage.PlayPanel;
import view.gui.panels.myMainFrame.MyMainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//import View.Gui.Loop.Loop.GraphicLoop;

public class CardImagePanel extends JPanel implements MouseListener, MouseMotionListener {

    private BufferedImage imageOfCard;
    private boolean isLock;
    private String cardName;
    boolean dragging = false;
    private int numberOfCardInBattleGround;
    private Alliance alliance;
    private boolean firstTime = true;
    boolean entered = false;
    static boolean clicked = false;
    static boolean doubleClick = false;
    private String hp;
    private String attackPower;
    //    private int mana;
    private boolean isInited = false;
    private String typeOfCard = "minionOrSpell";
    int x, y;

    public boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(String cardName) throws IOException {
        isLock = GamePartController.isThisCardLock(cardName);
    }

    public BufferedImage getImageOfCard() {
        return imageOfCard;
    }


    public CardImagePanel(String cardName) throws IOException {
        setLayout(null);
        setSize(150, 170);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.cardName = cardName;
        setIsLock(cardName);
        if (this.isLock) {
//            System.out.println(cardName);
            imageOfCard = ImageIO.read(new File("src/main/resources/Assets/GreyCardImage/" + cardName + ".png"));
        } else {
            imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/" + cardName + ".png"));
        }
    }

    public CardImagePanel(int width, int height, int typeOfBackOfCard) throws IOException {
        System.out.println("BackOFCards////////////////////////");
        setLayout(null);
        setSize(width, height);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        imageOfCard = ImageIO.read(new File("src/main/resources/BackOfCards/BackOfCards" + typeOfBackOfCard + ".png"));

    }


    public CardImagePanel(String cardName, int width, int height, boolean showLockCards, int type, Alliance alliance) throws IOException {
        if (showLockCards) {
            setLayout(null);
            setSize(width, height);
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
            this.alliance = alliance;
            this.cardName = cardName;
            setIsLock(this.cardName);
            if (type == 1) {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/" + cardName + ".png"));
            } else if (type == 2) {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/BattleGroundCardImage/" + cardName + ".png"));
            }
        }

    }

    public CardImagePanel(String cardName, int width, int height, boolean showLockCards,
                          int type, Alliance alliance, int counter, String s) throws IOException {
        if (showLockCards) {
            setLayout(null);
            setSize(width, height);
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
            this.alliance = alliance;
            this.cardName = cardName;
//            this.mana = GamePartController.giveMinionManaWithName(counter, alliance);
            setIsLock(this.cardName);
            if (type == 1) {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/" + cardName + ".png"));
            } else if (type == 2) {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/BattleGroundCardImage/" + cardName + ".png"));
            }
        }

    }

    public CardImagePanel(String cardName, int width, int height, boolean showLockCards,
                          int type, Alliance alliance, int numberOfCardInBattleGround) throws IOException {
        if (showLockCards) {
            setLayout(null);
            setSize(width, height);
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
            this.alliance = alliance;
            this.cardName = cardName;
            this.numberOfCardInBattleGround = numberOfCardInBattleGround;
            this.hp = GamePartController.giveMinionHpWithName(numberOfCardInBattleGround, alliance);
            this.attackPower = GamePartController.giveMinionAttackWithName(numberOfCardInBattleGround, alliance);
            isInited = true;
            setIsLock(this.cardName);
            if (type == 1) {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/" + cardName + ".png"));
            } else if (type == 2) {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/BattleGroundCardImage/" + cardName + ".png"));
            }
        }
    }


    public CardImagePanel(String cardName, int width, int height, String typeOfCard, Alliance alliance) throws IOException {
        setLayout(null);
        setSize(width, height);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
//        this.card = card;
        this.typeOfCard = typeOfCard;
        this.cardName = cardName;
        this.alliance = alliance;
        if (typeOfCard.equalsIgnoreCase("weapon")) {
            this.hp = GamePartController.giveWeaponDurability(alliance);
            this.attackPower = GamePartController.giveWeaponAttackPower(alliance);
        }

        if (typeOfCard.equalsIgnoreCase("hero")) {
            this.hp = GamePartController.giveHeroHp(alliance);
            this.attackPower = GamePartController.giveHeroAttackPower(alliance);
        }

        setIsLock(this.cardName);
        if (typeOfCard.equalsIgnoreCase("heroPower")) {
            imageOfCard = ImageIO.read(new File("src/main/resources/Assets/HeroPowerImages/" + cardName + ".png"));
        } else if (typeOfCard.equalsIgnoreCase("hero")) {

            imageOfCard = ImageIO.read(new File("src/main/resources/Assets/HeroImages/" + cardName + ".png"));
        } else {

            if (this.isLock) {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/GreyCardImage/" + cardName + ".png"));
            } else {
                imageOfCard = ImageIO.read(new File("src/main/resources/Assets/CardsImage/" + cardName + ".png"));

            }
        }
    }




    @Override
    public void mouseClicked(MouseEvent e) {

        int xCoordinateOfCard = e.getComponent().getX();
        int yCoordinateOfCard = e.getComponent().getY();

        if (SwingUtilities.isRightMouseButton(e)) {
            Controller.getCurrentClient().sendMouseClickedRequest(cardName, typeOfCard, clicked, xCoordinateOfCard,
                    yCoordinateOfCard, alliance, "Right", isLock);
        } else if (SwingUtilities.isLeftMouseButton(e)) {

            Controller.getCurrentClient().sendMouseClickedRequest(cardName, typeOfCard, clicked, xCoordinateOfCard,
                    yCoordinateOfCard, alliance, "Left", isLock);
        }
    }


    boolean canReleased = true;

    @Override
    public void mousePressed(MouseEvent e) {

        if (ClientMain.getCurrentPage().equals(Status.PLAY_PAGE_MY_TURN) ||
                ClientMain.getCurrentPage().equals(Status.PLAY_PAGE)) {

            Controller.getCurrentClient().sendMousePressRequest(cardName);//todoooo
            if (GamePartController.canDragCard(e.getComponent().getY())) {
                x = e.getX();
                y = e.getY();
            } else {
                int xCoordinate = e.getComponent().getX();
                int yCoordinate = e.getComponent().getY();
                e.getComponent().setLocation(xCoordinate, yCoordinate);
                canReleased = false;
            }

        }

    }


    @Override

    public void mouseReleased(MouseEvent e) {
        if (!canReleased) {
            PlayPanel playPanel = (PlayPanel) Constant.getPanels().get("PlayPanel");
//            System.out.println("cant released");
            playPanel.setNeedsToRepaint(true);
            playPanel.repaint();
            playPanel.revalidate();
            return;
        }

        if (ClientMain.getCurrentPage().equals(Status.PLAY_PAGE_MY_TURN) ||
                ClientMain.getCurrentPage().equals(Status.PLAY_PAGE)) {
            String xCoordinateOfReleased = e.getComponent().getX() + "";
            String yCoordinateOfRelease = e.getComponent().getY() + "";
            Controller.getCurrentClient().sendMouseReleasedRequest(cardName, xCoordinateOfReleased, yCoordinateOfRelease);
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {

        if (ClientMain.getCurrentPage().equals(Status.PLAY_PAGE_MY_TURN) ||
                ClientMain.getCurrentPage().equals(Status.PLAY_PAGE)) {

            dragging = true;
            e.getComponent().setLocation(e.getX() + e.getComponent().getX() - x, e.getY() + e.getComponent().getY() - y);
        }

    }


    @Override
    public void mouseEntered(MouseEvent e) {
        if (clicked) {
//            System.out.println("Entered");
            entered = true;
            repaint();
            revalidate();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        System.out.println("Exited");
        entered = false;
        repaint();
        revalidate();
    }


    @Override
    public void mouseMoved(MouseEvent e) {
//        System.out.println("Moved");
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(imageOfCard, 0, 0, this.getWidth(), this.getHeight(), null);
        Graphics2D graphics2D = (Graphics2D) g;

        if (ClientMain.getCurrentPage().equals(Status.PLAY_PAGE)
                || ClientMain.getCurrentPage().equals(Status.CHOOSE_TARGET_FOR_SPELL)
                || ClientMain.getCurrentPage().equals(Status.CHOOSE_TARGET_FOR_HERO_POWERS)) {


            graphics2D.setFont(new Font("TimesRoman", Font.ITALIC, 20));
            graphics2D.setColor(Color.red);
            if (isInited) {
                if (this.typeOfCard.equalsIgnoreCase("weapon")) {
                    this.hp = GamePartController.giveWeaponDurability(alliance);
                    this.attackPower = GamePartController.giveWeaponAttackPower(alliance);
                } else {
                    this.hp = GamePartController.giveMinionHpWithName(numberOfCardInBattleGround, alliance);
                    this.attackPower = GamePartController.giveMinionAttackWithName(numberOfCardInBattleGround, alliance);
                }
            }

            if (this.typeOfCard.equalsIgnoreCase("weapon")) {
                graphics2D.setFont(new Font("TimesRoman", Font.ITALIC, 15));
                graphics2D.drawString(this.hp + "", 68, 93);
                graphics2D.drawString(this.attackPower + "", 7, 93);
//                graphics2D.drawString(this.mana + "", 10, 15);//todo mana
            } else if (this.typeOfCard.equalsIgnoreCase("hero")) {
                graphics2D.drawString(this.hp + "", 115, 98);
                graphics2D.drawString(this.attackPower + "", 12, 98);
            } else if (typeOfCard.equalsIgnoreCase("heroPower")) {
                //doesnt show eny Thing
            } else {
                graphics2D.drawString(this.hp + "", 73, 98);
                graphics2D.drawString(this.attackPower + "", 10, 98);
//                graphics2D.drawString(this.mana + "", 10, 15);//todo mana
            }


            if (entered) {
                int r = this.getWidth() / 4;
                graphics2D.setFont(new Font("TimesRoman", Font.ITALIC, 50));
                graphics2D.setColor(Color.black);
                graphics2D.drawOval(this.getWidth() / 2 - r, this.getHeight() / 2 - r, 2 * r, 2 * r);

                graphics2D.drawLine(this.getWidth() / 2, this.getHeight() / 2 - 2 * r
                        , this.getWidth() / 2, this.getHeight() / 2 + 2 * r);

                graphics2D.drawLine(this.getWidth() / 2 - 2 * r, this.getHeight() / 2
                        , this.getWidth() / 2 + 3 * r, this.getHeight() / 2);
            }

        }
    }


    public static boolean isClicked() {
        return clicked;
    }

    public static void setClicked(boolean clicked) {
        CardImagePanel.clicked = clicked;
    }
}
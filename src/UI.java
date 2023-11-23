import static_variables.CustomColors;
import static_variables.CustomFonts;
import static_variables.CustomSizes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI extends JFrame {
    GameLogic gameLogic;
    EventHandling EventHandling;

    // Collors
    Color panelColor = CustomColors.buttonPressed;
    Color topButtonsColor =CustomColors.btn_Clr;
    Color tileTextBgColor =CustomColors.backGroundCopy;


    //Fonts
    Font gameFont = CustomFonts.current_Font_Button;
    Font topButtonFont =new Font (Font.SANS_SERIF, 1,  CustomSizes.button_size);


    JPanel gamePanel = new JPanel();
    JPanel newGamePanel = new JPanel();
    JButton newGameButton = new JButton("Start new game");

    JButton wingame_b = new JButton("Win the game!");

    ArrayList<JButton> buttonList = new ArrayList<>();

    ArrayList<JButton> button_winnerlist = new ArrayList<>();
    public JButton placeholder(JButton emptybutton) {
        return emptybutton;
    }
    public UI(EventHandling EventHandling){
        System.out.println("Running UI constructor");
        this.EventHandling = EventHandling;
        this.gameLogic = new GameLogic(this);
        newGameButton.setFont(topButtonFont);// Ändrar teckensnittet till Arial, normal stil och storlek 20
        wingame_b.setFont(topButtonFont);// Ändrar teckensnittet till Arial, normal stil och storlek 20
        newGameButton.setBackground(topButtonsColor); // Ändrar bakgrundsfärgen till blå
        wingame_b.setBackground(topButtonsColor); // Ändrar bakgrundsfärgen till blå
        gamePanel.setBackground(panelColor); // Ändrar bakgrundsfärgen till grå
        newGamePanel.setBackground(panelColor); // Ändrar bakgrundsfärgen till grå
        setLayout(new BorderLayout());
        add(gamePanel,BorderLayout.CENTER);
        add(newGamePanel,BorderLayout.NORTH);
        newGamePanel.add(newGameButton);
        newGamePanel.add(wingame_b);
        gamePanel.setLayout(new GridLayout(4,4));
        for(int i = 0;i<15;i++){
            buttonList.add(new JButton(String.valueOf(i+1)));
            buttonList.get(i).setBackground(panelColor); // Ändrar bakgrundsfärgen till grå
            buttonList.get(i).setForeground(tileTextBgColor); // Ändrar textfärgen till vit
            buttonList.get(i).setFont(gameFont); // Ändrar teckensnittet till Arial, normal stil och storlek 20
            buttonList.get(i).setBorder(BorderFactory.createLineBorder(static_variables.CustomColors.btn_Clr_Copy,1));
            //static_variables.CustomColors.btn_Clr_Copy

        }
        buttonList.add(new JButton());
        button_winnerlist.addAll(buttonList);
        gameLogic.shuffleTiles();

        newGameButton.addActionListener(EventHandling);
        wingame_b.addActionListener(EventHandling);

        for(JButton button:buttonList){
            button.addActionListener(EventHandling);
            gamePanel.add(button);
        }




        setTitle("Puzzle");
        setIconImage(new ImageIcon("src/fifteen.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,500);
    }
}

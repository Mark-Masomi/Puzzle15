import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI extends JFrame {
    GameLogic gameLogic=new GameLogic() ;
    tile15_2 tile15_2;
    JPanel gamePanel = new JPanel();
    JPanel newGamePanel = new JPanel();
    JButton newGameButton = new JButton("Start new game");

    JButton wingame_b = new JButton("win the game!");

    ArrayList<JButton> buttonList = new ArrayList<>();

    ArrayList<JButton> button_winnerlist = new ArrayList<>();
    public JButton placeholder(JButton emptybutton) {
        return emptybutton;
    }
    public UI(){
        setLayout(new BorderLayout());
        add(gamePanel,BorderLayout.CENTER);
        add(newGamePanel,BorderLayout.NORTH);
        newGamePanel.add(newGameButton);
        newGamePanel.add(wingame_b);
        gamePanel.setLayout(new GridLayout(4,4));
        for(int i = 0;i<15;i++){
            buttonList.add(new JButton(String.valueOf(i+1)));
        }
        buttonList.add(new JButton());
        button_winnerlist.addAll(buttonList);
        gameLogic.shuffleTiles();

        newGameButton.addActionListener(tile15_2);
        wingame_b.addActionListener(tile15_2);

        for(JButton button:buttonList){
            button.addActionListener(tile15_2);
            gamePanel.add(button);
        }


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,500);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class tile15_2 extends JFrame implements ActionListener {

    GameLogic gameLogic=new GameLogic() ;
    JPanel gamePanel = new JPanel();
    JPanel newGamePanel = new JPanel();
    JButton newGameButton = new JButton("Start new game");

    JButton wingame_b = new JButton("win the game!");

    ArrayList<JButton> buttonList = new ArrayList<>();

    ArrayList<JButton> button_winnerlist = new ArrayList<>();


    public JButton placeholder(JButton emptybutton) {
        return emptybutton;
    }
    public tile15_2(){
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

        newGameButton.addActionListener(this);
        wingame_b.addActionListener(this);

        for(JButton button:buttonList){
            button.addActionListener(this);
            gamePanel.add(button);
        }


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,500);




    }





    @Override
    public void actionPerformed(ActionEvent e) {
        int currentTileIndex = 0;
        JButton pushedButton = (JButton) e.getSource();
        for(int i =0;i<buttonList.size();i++){
            if(pushedButton.getText().equals(buttonList.get(i).getText()))
                currentTileIndex = i;
        }
        if(e.getSource()==newGameButton){
            gameLogic.shuffleTiles();
        }
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            int currentTileIndex = 0;
//            JButton pushedButton = (JButton) e.getSource();
//            for(int i =0; i<buttonList.size(); i++){
//                if(pushedButton.getText().equals(buttonList.get(i).getText()))
//                    currentTileIndex = i;
//            }
//            if(e.getSource() == newGameButton){
//                gameLogic.shuffleTiles();
//            }


        if(e.getSource()!=newGameButton&&e.getSource()!=buttonList.get(gameLogic.emptytileIndex())){
            int choiceindex=0;
            if(gameLogic.emptytileIndex()==5||gameLogic.emptytileIndex()==6||gameLogic.emptytileIndex()==9||gameLogic.emptytileIndex()==10){
                if(e.getSource()==buttonList.get(gameLogic.emptytileIndex()-1)
                        ||e.getSource()==buttonList.get(gameLogic.emptytileIndex()+1)
                        ||e.getSource()==buttonList.get(gameLogic.emptytileIndex()-4)
                        ||e.getSource()==buttonList.get(gameLogic.emptytileIndex()+4)){
                    Collections.swap(buttonList,currentTileIndex,gameLogic.emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }
            }
            else if(gameLogic.emptytileIndex()==0){
                if(e.getSource()==buttonList.get(1)||e.getSource()==buttonList.get(4)) {
                    Collections.swap(buttonList, currentTileIndex, gameLogic.emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }
            else if(gameLogic.emptytileIndex()==1||gameLogic.emptytileIndex()==2){
                if(e.getSource()==buttonList.get(gameLogic.emptytileIndex()-1)||e.getSource()==buttonList.get(gameLogic.emptytileIndex()+1)
                        ||e.getSource()==buttonList.get(gameLogic.emptytileIndex()+4)){
                    Collections.swap(buttonList, currentTileIndex, gameLogic.emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(gameLogic.emptytileIndex()==3){
                if(e.getSource()==buttonList.get(2)||e.getSource()==buttonList.get(7)){
                    Collections.swap(buttonList, currentTileIndex, gameLogic.emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(gameLogic.emptytileIndex()==4||gameLogic.emptytileIndex()==8){
                if(e.getSource()==buttonList.get(gameLogic.emptytileIndex()-4)||e.getSource()==buttonList.get(gameLogic.emptytileIndex()+4)
                        ||e.getSource()==buttonList.get(gameLogic.emptytileIndex()+1)){
                    Collections.swap(buttonList, currentTileIndex, gameLogic.emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(gameLogic.emptytileIndex()==7||gameLogic.emptytileIndex()==11){
                if(e.getSource()==buttonList.get(gameLogic.emptytileIndex()-4)||e.getSource()==buttonList.get(gameLogic.emptytileIndex()+4)
                        ||e.getSource()==buttonList.get(gameLogic.emptytileIndex()-1)){
                    Collections.swap(buttonList, currentTileIndex, gameLogic.emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(gameLogic.emptytileIndex()==12){
                if(e.getSource()==buttonList.get(gameLogic.emptytileIndex()-4)||e.getSource()==buttonList.get(gameLogic.emptytileIndex()+1)){
                    Collections.swap(buttonList, currentTileIndex, gameLogic.emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(gameLogic.emptytileIndex()==13||gameLogic.emptytileIndex()==14){
                if(e.getSource()==buttonList.get(gameLogic.emptytileIndex()-4)||e.getSource()==buttonList.get(gameLogic.emptytileIndex()+1)
                        ||e.getSource()==buttonList.get(gameLogic.emptytileIndex()-1)){
                    Collections.swap(buttonList, currentTileIndex, gameLogic.emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(gameLogic.emptytileIndex()==15){
                if(e.getSource()==buttonList.get(gameLogic.emptytileIndex()-4)||e.getSource()==buttonList.get(gameLogic.emptytileIndex()-1)){
                    Collections.swap(buttonList, currentTileIndex, gameLogic.emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

        }
        if (buttonList.equals(button_winnerlist)){
            JOptionPane.showMessageDialog(null,
                    "congrats you've won this round!");
        }
        if (e.getSource() == wingame_b) {
            Collections.sort(buttonList, new Comparator<JButton>() {
                @Override
                public int compare(JButton b1, JButton b2) {
                    if (b1.getText().isBlank()) {
                        return 1;
                    } else if (b2.getText().isBlank()) {
                        return -1;
                    } else {
                        return Integer.parseInt(b1.getText()) - Integer.parseInt(b2.getText());
                    }
                }
            });
            gamePanel.removeAll();
            for (JButton b : buttonList) {
                gamePanel.add(b);
            }
            gamePanel.revalidate();
            gamePanel.repaint();
        }

    }


}
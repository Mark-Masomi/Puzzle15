import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class tile15_2 extends JFrame implements ActionListener {

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
        shuffleTiles();

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

    public int emptytileIndex () {
        int index = 0;
        for (int i = 0; i < buttonList.size(); i++) {
            if (buttonList.get(i).getText().trim().isBlank()) {
                index = i;
            }

        }
        return index;
    }
    public void shuffleTiles() {
        do {
            Collections.shuffle(buttonList);
        } while (!isSolvable());

        for(JButton button:buttonList){
            gamePanel.add(button);
        }
        gamePanel.revalidate();
    }
    public boolean isSolvable() {
        int inversions = 0;
        for (int i = 0; i < buttonList.size() - 1; i++) {
            for (int j = i + 1; j < buttonList.size(); j++) {
                if (!buttonList.get(i).getText().isBlank() && !buttonList.get(j).getText().isBlank() &&
                        Integer.parseInt(buttonList.get(i).getText()) > Integer.parseInt(buttonList.get(j).getText())) {
                    inversions++;
                }
            }
        }
        if (inversions % 2 == 0) {
            return (emptytileIndex() / 4) % 2 == 1;
        } else {
            return (emptytileIndex() / 4) % 2 == 0;
        }
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
            shuffleTiles();
        }


        if(e.getSource()!=newGameButton&&e.getSource()!=buttonList.get(emptytileIndex())){
            int choiceindex=0;
            if(emptytileIndex()==5||emptytileIndex()==6||emptytileIndex()==9||emptytileIndex()==10){
                if(e.getSource()==buttonList.get(emptytileIndex()-1)
                        ||e.getSource()==buttonList.get(emptytileIndex()+1)
                        ||e.getSource()==buttonList.get(emptytileIndex()-4)
                        ||e.getSource()==buttonList.get(emptytileIndex()+4)){
                    Collections.swap(buttonList,currentTileIndex,emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }
            }
            else if(emptytileIndex()==0){
                if(e.getSource()==buttonList.get(1)||e.getSource()==buttonList.get(4)) {
                    Collections.swap(buttonList, currentTileIndex, emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }
            else if(emptytileIndex()==1||emptytileIndex()==2){
                if(e.getSource()==buttonList.get(emptytileIndex()-1)||e.getSource()==buttonList.get(emptytileIndex()+1)
                        ||e.getSource()==buttonList.get(emptytileIndex()+4)){
                    Collections.swap(buttonList, currentTileIndex, emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(emptytileIndex()==3){
                if(e.getSource()==buttonList.get(2)||e.getSource()==buttonList.get(7)){
                    Collections.swap(buttonList, currentTileIndex, emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(emptytileIndex()==4||emptytileIndex()==8){
                if(e.getSource()==buttonList.get(emptytileIndex()-4)||e.getSource()==buttonList.get(emptytileIndex()+4)
                        ||e.getSource()==buttonList.get(emptytileIndex()+1)){
                    Collections.swap(buttonList, currentTileIndex, emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(emptytileIndex()==7||emptytileIndex()==11){
                if(e.getSource()==buttonList.get(emptytileIndex()-4)||e.getSource()==buttonList.get(emptytileIndex()+4)
                        ||e.getSource()==buttonList.get(emptytileIndex()-1)){
                    Collections.swap(buttonList, currentTileIndex, emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(emptytileIndex()==12){
                if(e.getSource()==buttonList.get(emptytileIndex()-4)||e.getSource()==buttonList.get(emptytileIndex()+1)){
                    Collections.swap(buttonList, currentTileIndex, emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(emptytileIndex()==13||emptytileIndex()==14){
                if(e.getSource()==buttonList.get(emptytileIndex()-4)||e.getSource()==buttonList.get(emptytileIndex()+1)
                        ||e.getSource()==buttonList.get(emptytileIndex()-1)){
                    Collections.swap(buttonList, currentTileIndex, emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(emptytileIndex()==15){
                if(e.getSource()==buttonList.get(emptytileIndex()-4)||e.getSource()==buttonList.get(emptytileIndex()-1)){
                    Collections.swap(buttonList, currentTileIndex, emptytileIndex());
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

//        if (e.getSource()==wingame_b){
//            for (JButton b:button_winnerlist) {
//                gamePanel.add(b);
//            }
//            gamePanel.revalidate();
//            JOptionPane.showMessageDialog(null,
//                    "congrats you've won this round!");
//        }
    }


}
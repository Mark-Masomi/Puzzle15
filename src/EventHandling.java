import static_variables.CustomDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;

public class EventHandling extends JFrame implements ActionListener {

    GameLogic gameLogic;
    UI ui;

    public JButton placeholder(JButton emptybutton) {
        return emptybutton;
    }
    public EventHandling(){
        ui = new UI(this);
        gameLogic = new GameLogic(ui);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int currentTileIndex = 0;
        JButton pushedButton = (JButton) e.getSource();
        for(int i =0;i<ui.buttonList.size();i++){
            if(pushedButton.getText().equals(ui.buttonList.get(i).getText()))
                currentTileIndex = i;
        }
        if(e.getSource()==ui.newGameButton){
            gameLogic.shuffleTiles();
        }

        if(e.getSource()!=ui.newGameButton&&e.getSource()!=ui.buttonList.get(gameLogic.emptytileIndex())){
            int choiceindex=0;
            if(gameLogic.emptytileIndex()==5||gameLogic.emptytileIndex()==6||gameLogic.emptytileIndex()==9||gameLogic.emptytileIndex()==10){
                if(e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()-1)
                        ||e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()+1)
                        ||e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()-4)
                        ||e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()+4)){
                    Collections.swap(ui.buttonList,currentTileIndex,gameLogic.emptytileIndex());
                    for (JButton button : ui.buttonList) {
                        ui.gamePanel.add(button);
                    }
                    ui.gamePanel.revalidate();
                }
            }
            else if(gameLogic.emptytileIndex()==0){
                if(e.getSource()==ui.buttonList.get(1)||e.getSource()==ui.buttonList.get(4)) {
                    Collections.swap(ui.buttonList, currentTileIndex, gameLogic.emptytileIndex());
                    for (JButton button : ui.buttonList) {
                        ui.gamePanel.add(button);
                    }
                    ui.gamePanel.revalidate();
                }

            }
            else if(gameLogic.emptytileIndex()==1||gameLogic.emptytileIndex()==2){
                if(e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()-1)||e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()+1)
                        ||e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()+4)){
                    Collections.swap(ui.buttonList, currentTileIndex, gameLogic.emptytileIndex());
                    for (JButton button : ui.buttonList) {
                        ui.gamePanel.add(button);
                    }
                    ui.gamePanel.revalidate();
                }

            }

            else if(gameLogic.emptytileIndex()==3){
                if(e.getSource()==ui.buttonList.get(2)||e.getSource()==ui.buttonList.get(7)){
                    Collections.swap(ui.buttonList, currentTileIndex, gameLogic.emptytileIndex());
                    for (JButton button : ui.buttonList) {
                        ui.gamePanel.add(button);
                    }
                    ui.gamePanel.revalidate();
                }

            }

            else if(gameLogic.emptytileIndex()==4||gameLogic.emptytileIndex()==8){
                if(e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()-4)||e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()+4)
                        ||e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()+1)){
                    Collections.swap(ui.buttonList, currentTileIndex, gameLogic.emptytileIndex());
                    for (JButton button : ui.buttonList) {
                        ui.gamePanel.add(button);
                    }
                    ui.gamePanel.revalidate();
                }

            }

            else if(gameLogic.emptytileIndex()==7||gameLogic.emptytileIndex()==11){
                if(e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()-4)||e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()+4)
                        ||e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()-1)){
                    Collections.swap(ui.buttonList, currentTileIndex, gameLogic.emptytileIndex());
                    for (JButton button : ui.buttonList) {
                        ui.gamePanel.add(button);
                    }
                    ui.gamePanel.revalidate();
                }

            }

            else if(gameLogic.emptytileIndex()==12){
                if(e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()-4)||e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()+1)){
                    Collections.swap(ui.buttonList, currentTileIndex, gameLogic.emptytileIndex());
                    for (JButton button : ui.buttonList) {
                        ui.gamePanel.add(button);
                    }
                    ui.gamePanel.revalidate();
                }

            }

            else if(gameLogic.emptytileIndex()==13||gameLogic.emptytileIndex()==14){
                if(e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()-4)||e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()+1)
                        ||e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()-1)){
                    Collections.swap(ui.buttonList, currentTileIndex, gameLogic.emptytileIndex());
                    for (JButton button : ui.buttonList) {
                        ui.gamePanel.add(button);
                    }
                    ui.gamePanel.revalidate();
                }

            }

            else if(gameLogic.emptytileIndex()==15){
                if(e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()-4)||e.getSource()==ui.buttonList.get(gameLogic.emptytileIndex()-1)){
                    Collections.swap(ui.buttonList, currentTileIndex, gameLogic.emptytileIndex());
                    for (JButton button : ui.buttonList) {
                        ui.gamePanel.add(button);
                    }
                    ui.gamePanel.revalidate();
                }

            }

        }
        if (ui.buttonList.equals(ui.button_winnerlist)){
//            JOptionPane.showMessageDialog(null,
//                    "congrats you've won this round!");
            //winner Message icon
            ImageIcon icon = new ImageIcon("src/win.png");
            Image image = icon.getImage();
            Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            icon = new ImageIcon(newimg);

            JOptionPane.showMessageDialog(null,
                    "Congratulations! You've won this round!",
                    "Game Over",
                    JOptionPane.INFORMATION_MESSAGE,
                    icon);
        }
        if (e.getSource() == ui.wingame_b) {
            Collections.sort(ui.buttonList, new Comparator<JButton>() {
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
            ui.gamePanel.removeAll();
            for (JButton b : ui.buttonList) {
                ui.gamePanel.add(b);
            }
            ui.gamePanel.revalidate();
            ui.gamePanel.repaint();
        }

    }


}
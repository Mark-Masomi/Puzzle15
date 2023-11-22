import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class GameLogic {
    JPanel gamePanel = new JPanel();
    ArrayList<JButton> buttonList = new ArrayList<>();

    public void shuffleTiles() {
        do {
            Collections.shuffle(buttonList);
        } while (!isSolvable());

        for(JButton button:buttonList){
            gamePanel.add(button);
        }
        gamePanel.revalidate();
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

    public void swapTiles(int currentTileIndex) {
        Collections.swap(buttonList, currentTileIndex, emptytileIndex());
        for (JButton button : buttonList) {
            gamePanel.add(button);
        }
        gamePanel.revalidate();
    }

}

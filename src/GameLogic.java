import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class GameLogic {
    UI ui;

    public GameLogic(UI ui) {
        this.ui = ui;
    }

    public void shuffleTiles() {
        do {
            Collections.shuffle(ui.buttonList);
        } while (!isSolvable());

        for(JButton button:ui.buttonList){
            ui.gamePanel.add(button);
        }
        ui.gamePanel.revalidate();
    }
    public int emptytileIndex () {
        int index = 0;
        for (int i = 0; i < ui.buttonList.size(); i++) {
            if (ui.buttonList.get(i).getText().trim().isBlank()) {
                index = i;
            }

        }
        return index;
    }
    public boolean isSolvable() {
        int inversions = 0;
        for (int i = 0; i < ui.buttonList.size() - 1; i++) {
            for (int j = i + 1; j < ui.buttonList.size(); j++) {
                if (!ui.buttonList.get(i).getText().isBlank() && !ui.buttonList.get(j).getText().isBlank() &&
                        Integer.parseInt(ui.buttonList.get(i).getText()) > Integer.parseInt(ui.buttonList.get(j).getText())) {
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
        Collections.swap(ui.buttonList, currentTileIndex, emptytileIndex());
        for (JButton button : ui.buttonList) {
            ui.gamePanel.add(button);
        }
        ui.gamePanel.revalidate();
    }

}

package com.github.parisoft.magic.engine.game;

import com.github.parisoft.magic.engine.entity.Player;

public class Games {

    public static Game currentGame() {
        return Match.getInstance().getCurrentGame();
    }
    
    public static Player activePlayer() {
        return currentGame().getActivePlayer();
    }
}

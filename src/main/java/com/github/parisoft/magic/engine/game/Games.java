package com.github.parisoft.magic.engine.game;

import com.github.parisoft.magic.engine.entity.Player;
import com.github.parisoft.magic.engine.game.phase.Phase;
import com.github.parisoft.magic.engine.game.step.Step;

public class Games {

    public static Game currentGame() {
        return Match.getInstance().getCurrentGame();
    }
    
    public static Turn currentTurn() {
        return currentGame().getCurrentTurn();
    }
    
    public static Phase currentPhase() {
        return currentTurn().getCurrentPhase();
    }
    
    public static Step currentStep() {
        return currentPhase().getCurrentStep();
    }
    
    public static Player activePlayer() {
        return currentGame().getActivePlayer();
    }
}

package com.github.parisoft.magic.engine.game;

import com.github.parisoft.magic.engine.core.entity.Player;
import com.github.parisoft.magic.engine.game.phase.Phase;
import com.github.parisoft.magic.engine.game.step.Step;

public class Games {

    static final ThreadLocal<Match> currentMatch = new ThreadLocal<Match>(){
        protected Match initialValue() {
            return new Match();
        }
    };
    
    public static boolean not(boolean condition) {
        return !condition;
    }
    
    public static Match currentMatch() {
        return currentMatch.get();
    }
    
    public static Game currentGame() {
        return currentMatch().getCurrentGame();
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
    
    public static Player nonActivePlayer() {
        return activePlayer().getOpponent();
    }
    
    public static Player attackingPlayer() {
        return activePlayer();
    }
    
    public static Player defendingPlayer() {
        return nonActivePlayer();
    }
}

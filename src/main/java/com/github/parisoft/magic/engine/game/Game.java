package com.github.parisoft.magic.engine.game;

import java.util.ArrayList;
import java.util.List;

import com.github.parisoft.magic.engine.event.Event;

public class Game implements Runnable {

    private List<Turn> turns = new ArrayList<>();
    private Turn currentTurn;
   
    @Override
    public void run() {
        while (isNotEnded()) {
            currentTurn = nextTurn();
            currentTurn.run();
        }
    }
    
    public Turn currentTurn() {
        return currentTurn;
    }

    private Turn nextTurn() {
        if (turns.isEmpty()) {
            return new Turn();
        }
        
        return turns.remove(0);
    }

    public boolean isNotEnded() {
        return !Thread.interrupted();//TODO check game end conditions
    }
    
    public void execute(Event event) {
        
    }
}

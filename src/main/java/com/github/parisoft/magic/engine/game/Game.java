package com.github.parisoft.magic.engine.game;

import java.util.ArrayDeque;
import java.util.Deque;

import com.github.parisoft.magic.engine.core.entity.Player;
import com.github.parisoft.magic.engine.core.event.Event;
import com.github.parisoft.magic.engine.core.zone.Battlefield;

public class Game implements Runnable {

    private final Deque<Turn> turns = new ArrayDeque<>();
    private final Battlefield battlefield = new Battlefield();

    private Turn currentTurn;
    private Player activePlayer;
   
    @Override
    public void run() {
        while (isNotEnded()) {
            currentTurn = nextTurn();
            currentTurn.run();
        }
    }
    
    private Turn nextTurn() {
        if (turns.isEmpty()) {
            return new Turn();
        }
        
        return turns.pop();
    }
    
    public Player getActivePlayer() {
        return activePlayer;
    }
    
    public Turn getCurrentTurn() {
        return currentTurn;
    }

    public Battlefield getBattlefield() {
        return battlefield;
    }

    public boolean isNotEnded() {
        return !Thread.interrupted();//TODO check game end conditions
    }
    
    public void perform(Event event) {
        
    }
    
    public void givePriority() {
        
    }
}

package com.github.parisoft.magic.engine.core.event;

import com.github.parisoft.magic.engine.game.phase.Phase;

public class EndPhaseEvent extends Event {

    private final Phase phase;
    
    public EndPhaseEvent(Phase step) {
        this.phase = step;
    }
    
    public Phase getPhase() {
        return phase;
    }
    
    @Override
    public void perform() {
        // TODO Auto-generated method stub
        
    }

}

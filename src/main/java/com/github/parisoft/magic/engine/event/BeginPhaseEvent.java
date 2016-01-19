package com.github.parisoft.magic.engine.event;

import com.github.parisoft.magic.engine.game.phase.Phase;

public class BeginPhaseEvent extends Event {

    private final Phase phase;
    
    public BeginPhaseEvent(Phase step) {
        this.phase = step;
    }
    
    public Phase getPhase() {
        return phase;
    }
    
    @Override
    public void resolve() {
        // TODO Auto-generated method stub
        
    }

}

package com.github.parisoft.magic.engine.core.event;

import com.github.parisoft.magic.engine.game.step.Step;

public class BeginStepEvent extends Event {

    private final Step step;
    
    public BeginStepEvent(Step step) {
        this.step = step;
    }
    
    public Step getStep() {
        return step;
    }
    
    @Override
    public void resolve() {
        // TODO Auto-generated method stub
        
    }

}

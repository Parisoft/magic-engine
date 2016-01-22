package com.github.parisoft.magic.engine.core.event;

import com.github.parisoft.magic.engine.game.step.Step;

public class EndStepEvent extends Event {

    private final Step step;

    public EndStepEvent(Step step) {
        this.step = step;
    }

    public Step getStep() {
        return step;
    }

    @Override
    public void perform() {
        // TODO Auto-generated method stub
        
    }

}

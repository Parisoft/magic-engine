package com.github.parisoft.magic.engine.game.step;

import static com.github.parisoft.magic.engine.game.Games.currentGame;

import com.github.parisoft.magic.engine.event.BeginStepEvent;
import com.github.parisoft.magic.engine.event.EndStepEvent;

public abstract class Step implements Runnable {

    private final String name;

    private boolean skipped;
    
    public Step(StepName name) {
        this.name = name.toString();
    }

    @Override
    public void run() {
        currentGame().perform(new BeginStepEvent(this));
        
        if (isSkipped()) {
            return;
        }
        
        runStep();
        
        currentGame().perform(new EndStepEvent(this));
    }

    public boolean isSkipped() {
        return skipped;
    }

    public void setSkipped(boolean skipped) {
        this.skipped = skipped;
    }

    public String getName() {
        return name;
    }
    
    protected abstract void runStep();

}

package com.github.parisoft.magic.engine.game.step;

import static com.github.parisoft.magic.engine.game.Games.currentGame;

import com.github.parisoft.magic.engine.core.event.BeginStepEvent;
import com.github.parisoft.magic.engine.core.event.EndStepEvent;

public abstract class Step implements Runnable {

    private boolean skipped;
    
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

    protected abstract void runStep();

}

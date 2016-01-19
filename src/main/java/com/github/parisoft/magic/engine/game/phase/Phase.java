package com.github.parisoft.magic.engine.game.phase;

import static com.github.parisoft.magic.engine.game.Games.currentGame;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

import java.util.Deque;

import com.github.parisoft.magic.engine.event.BeginPhaseEvent;
import com.github.parisoft.magic.engine.event.EndPhaseEvent;
import com.github.parisoft.magic.engine.game.step.Step;

public abstract class Phase implements Runnable {

    private final String name;
    
    private boolean skipped;
    private Step currentStep;
    
    public Phase(PhaseName name) {
        this.name = name.toString();
    }
    
    @Override
    public void run() {
        currentGame().perform(new BeginPhaseEvent(this));
        
        if (isSkipped()) {
            return;
        }
        
        runPhase();
        
        currentGame().perform(new EndPhaseEvent(this));
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
    
    public Step getCurrentStep() {
        return currentStep;
    }

    protected abstract void runPhase();

    protected void run(Deque<? extends Step> steps) {
        while (isNotEmpty(steps)) {
            currentStep = steps.pop();
            currentStep.run();
        }
    }
}

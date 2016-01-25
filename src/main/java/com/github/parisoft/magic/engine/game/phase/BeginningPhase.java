package com.github.parisoft.magic.engine.game.phase;

import static com.github.parisoft.magic.engine.game.Turns.newSteps;

import java.util.Deque;

import com.github.parisoft.magic.engine.game.step.DrawStep;
import com.github.parisoft.magic.engine.game.step.UntapStep;
import com.github.parisoft.magic.engine.game.step.UpkeepStep;

public class BeginningPhase extends Phase {

    private final Deque<UntapStep> untapSteps = newSteps(UntapStep.class);
    private final Deque<UpkeepStep> upkeepSteps = newSteps(UpkeepStep.class);
    private final Deque<DrawStep> drawSteps = newSteps(DrawStep.class);
    
    @Override
    protected void runPhase() {
        run(untapSteps);
        run(upkeepSteps);
        run(drawSteps);
    }
    
}

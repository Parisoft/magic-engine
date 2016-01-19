package com.github.parisoft.magic.engine.game.phase;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import com.github.parisoft.magic.engine.game.step.DrawStep;
import com.github.parisoft.magic.engine.game.step.UntapStep;
import com.github.parisoft.magic.engine.game.step.UpkeepStep;

public class BeginningPhase extends Phase {

    private final List<UntapStep> untapSteps = newArrayList(new UntapStep());
    private final List<UpkeepStep> upkeepSteps = newArrayList(new UpkeepStep());
    private final List<DrawStep> drawSteps = newArrayList(new DrawStep());
    
    public BeginningPhase() {
        super(PhaseName.BEGINNING);
    }

    @Override
    protected void runPhase() {
        run(untapSteps);
        run(upkeepSteps);
        run(drawSteps);
    }
    
}

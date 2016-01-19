package com.github.parisoft.magic.engine.game.phase;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import com.github.parisoft.magic.engine.game.step.DrawStep;
import com.github.parisoft.magic.engine.game.step.Step;
import com.github.parisoft.magic.engine.game.step.UntapStep;
import com.github.parisoft.magic.engine.game.step.UpkeepStep;

public class BeginningPhase extends Phase {

    private final Deque<Step> untapSteps = new ArrayDeque<>(Arrays.asList(new UntapStep()));
    private final Deque<Step> upkeepSteps = new ArrayDeque<>(Arrays.asList(new UpkeepStep()));
    private final Deque<Step> drawSteps = new ArrayDeque<>(Arrays.asList(new DrawStep()));
    
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

package com.github.parisoft.magic.engine.game.phase;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import com.github.parisoft.magic.engine.game.step.BeginningOfCombatStep;
import com.github.parisoft.magic.engine.game.step.DeclareAttackersStep;
import com.github.parisoft.magic.engine.game.step.Step;

public class CombatPhase extends Phase {

    private final Deque<Step> beginningOfCombatSteps = new ArrayDeque<>(Arrays.asList(new BeginningOfCombatStep()));
    private final Deque<Step> declareAttackersSteps = new ArrayDeque<>(Arrays.asList(new DeclareAttackersStep()));
    
    public CombatPhase() {
        super(PhaseName.COMBAT);
    }

    @Override
    protected void runPhase() {
        run(beginningOfCombatSteps);
        run(declareAttackersSteps);
    }

}

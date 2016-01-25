package com.github.parisoft.magic.engine.game.phase;

import static com.github.parisoft.magic.engine.game.Games.currentTurn;
import static com.github.parisoft.magic.engine.game.Turns.newSteps;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

import java.util.Deque;

import com.github.parisoft.magic.engine.game.step.BeginningOfCombatStep;
import com.github.parisoft.magic.engine.game.step.CombatDamageStep;
import com.github.parisoft.magic.engine.game.step.DeclareAttackersStep;
import com.github.parisoft.magic.engine.game.step.DeclareBlockersStep;
import com.github.parisoft.magic.engine.game.step.EndOfCombatStep;

public class CombatPhase extends Phase {

    private final Deque<BeginningOfCombatStep> beginningOfCombatSteps = newSteps(BeginningOfCombatStep.class);
    private final Deque<DeclareAttackersStep> declareAttackersSteps = newSteps(DeclareAttackersStep.class);
    private final Deque<DeclareBlockersStep> declareBlockersSteps = newSteps(DeclareBlockersStep.class);
    private final Deque<CombatDamageStep> combatDamageSteps = newSteps(CombatDamageStep.class);
    private final Deque<EndOfCombatStep> endOfCombatSteps = newSteps(EndOfCombatStep.class);
    
    @Override
    protected void runPhase() {
        run(beginningOfCombatSteps);
        run(declareAttackersSteps);
        
        if (isNotEmpty(currentTurn().getAttackers())) {
            run(declareBlockersSteps);
            run(combatDamageSteps);
        }
        
        run(endOfCombatSteps);
    }

}

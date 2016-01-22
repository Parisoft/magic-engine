package com.github.parisoft.magic.engine.game.step;

import static com.github.parisoft.magic.engine.game.Games.currentGame;

public class BeginningOfCombatStep extends Step {

    public BeginningOfCombatStep() {
        super(StepName.BEGINNING_OF_COMBAT);
    }

    @Override
    protected void runStep() {
        currentGame().givePriority();        
    }

}

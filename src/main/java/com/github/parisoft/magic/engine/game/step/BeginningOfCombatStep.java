package com.github.parisoft.magic.engine.game.step;

import static com.github.parisoft.magic.engine.game.Games.currentGame;

public class BeginningOfCombatStep extends Step {

    @Override
    protected void runStep() {
        currentGame().givePriority();        
    }

}

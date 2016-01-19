package com.github.parisoft.magic.engine.game.step;

import static com.github.parisoft.magic.engine.game.Games.currentGame;


public class UpkeepStep extends Step {

    public UpkeepStep() {
        super(StepName.UPKEEP);
    }

    @Override
    protected void runStep() {
        currentGame().givePriority();
    }

}

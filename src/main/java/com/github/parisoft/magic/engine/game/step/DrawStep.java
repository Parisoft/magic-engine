package com.github.parisoft.magic.engine.game.step;

import static com.github.parisoft.magic.engine.game.Games.activePlayer;
import static com.github.parisoft.magic.engine.game.Games.currentGame;

import com.github.parisoft.magic.engine.core.event.DrawEvent;

public class DrawStep extends Step {

    public DrawStep() {
        super(StepName.DRAW);
    }

    @Override
    protected void runStep() {
        currentGame().perform(new DrawEvent(activePlayer(), 1));
        currentGame().givePriority();
    }
}

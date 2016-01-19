package com.github.parisoft.magic.engine.game.phase;

import static com.github.parisoft.magic.engine.game.Games.currentGame;


public class MainPhase extends Phase {

    public MainPhase() {
        super(PhaseName.MAIN);
    }

    @Override
    protected void runPhase() {
        currentGame().givePriority();
    }

}

package com.github.parisoft.magic.engine.game.phase;

import static com.github.parisoft.magic.engine.game.Games.currentGame;


public class MainPhase extends Phase {

    @Override
    protected void runPhase() {
        currentGame().givePriority();
    }

}

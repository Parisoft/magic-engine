package com.github.parisoft.magic.engine.game.step;

import static com.github.parisoft.magic.engine.game.Games.activePlayer;
import static com.github.parisoft.magic.engine.game.Games.currentGame;
import static com.github.parisoft.magic.engine.game.Games.currentTurn;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.event.DeclareAttackersEvent;
import com.github.parisoft.magic.engine.core.event.TapEvent;
import com.github.parisoft.magic.engine.game.question.combat.DeclareAttackersQuestion;

public class DeclareAttackersStep extends Step {

    @Override
    protected void runStep() {
        declareAttackers();
        tapAttackers();
        currentGame().givePriority();
    }

    private void declareAttackers() {
        DeclareAttackersEvent event;
        
        do {
            event = new DeclareAttackersEvent(activePlayer().answer(new DeclareAttackersQuestion()));
            currentGame().perform(event);
        } while (event.isIllegal());
    }

    private void tapAttackers() {
        for (Card attacker : currentTurn().getAttackers()) {
            currentGame().perform(new TapEvent(attacker));
        }
    }

}

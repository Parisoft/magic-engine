package com.github.parisoft.magic.engine.game.step;

import static com.github.parisoft.magic.engine.game.Games.attackingPlayer;
import static com.github.parisoft.magic.engine.game.Games.currentGame;
import static com.github.parisoft.magic.engine.game.Games.currentTurn;
import static com.github.parisoft.magic.engine.game.Games.not;

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
            event = new DeclareAttackersEvent(attackingPlayer().answer(new DeclareAttackersQuestion()));
        } while (not(currentGame().perform(event)));
    }

    private void tapAttackers() {
        for (Card attacker : currentTurn().getAttackers()) {
            currentGame().perform(new TapEvent(attacker));
        }
    }

}

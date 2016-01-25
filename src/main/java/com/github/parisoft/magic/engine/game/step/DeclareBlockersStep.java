package com.github.parisoft.magic.engine.game.step;

import static com.github.parisoft.magic.engine.game.Games.activePlayer;
import static com.github.parisoft.magic.engine.game.Games.currentGame;
import static com.github.parisoft.magic.engine.game.Games.currentTurn;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.event.DeclareBlockersEvent;
import com.github.parisoft.magic.engine.game.question.combat.DeclareBlockersQuestion;

public class DeclareBlockersStep extends Step {

    @Override
    protected void runStep() {
        declareBlockers();
        assignAttackDamageOrder();
    }

    private void declareBlockers() {
        DeclareBlockersEvent event;
        
        do {
            event = new DeclareBlockersEvent(activePlayer().answer(new DeclareBlockersQuestion()));
            currentGame().perform(event);
        } while (event.isIllegal());
    }
    
    private void assignAttackDamageOrder() {
        for (Card attacker : currentTurn().getAttackers()) {
            if (attacker.getBlockedBy().size() > 1) {
                
            }
        }
    }

}

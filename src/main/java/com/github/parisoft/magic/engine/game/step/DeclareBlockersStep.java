package com.github.parisoft.magic.engine.game.step;

import static com.github.parisoft.magic.engine.game.Games.attackingPlayer;
import static com.github.parisoft.magic.engine.game.Games.currentGame;
import static com.github.parisoft.magic.engine.game.Games.currentTurn;
import static com.github.parisoft.magic.engine.game.Games.defendingPlayer;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.event.DeclareBlockersEvent;
import com.github.parisoft.magic.engine.game.question.combat.AssignAttackDamageOrderQuestion;
import com.github.parisoft.magic.engine.game.question.combat.AssignBlockDamageOrderQuestion;
import com.github.parisoft.magic.engine.game.question.combat.DeclareBlockersQuestion;

public class DeclareBlockersStep extends Step {

    @Override
    protected void runStep() {
        declareBlockers();
        assignAttackDamageOrder();
        assignBlockDamageOrder();
        currentGame().givePriority();
    }

    private void declareBlockers() {
        DeclareBlockersEvent event;
        
        do {
            event = new DeclareBlockersEvent(defendingPlayer().answer(new DeclareBlockersQuestion()));
            currentGame().perform(event);
        } while (event.isIllegal());
    }
    
    private void assignAttackDamageOrder() {
        for (Card attacker : currentTurn().getAttackers()) {
            if (attacker.getBlocked().size() > 1) {
                attacker.getBlocked().addAll(attackingPlayer().answer(new AssignAttackDamageOrderQuestion(attacker)));
            }
        }
    }
    
    private void assignBlockDamageOrder() {
        for (Card blocker : currentTurn().getBlockers()) {
            if (blocker.getBlocking().size() > 1) {
                blocker.getBlocking().addAll(defendingPlayer().answer(new AssignBlockDamageOrderQuestion(blocker)));
            }
        }
    }

}

package com.github.parisoft.magic.engine.game.step;

import static com.github.parisoft.magic.engine.game.Games.attackingPlayer;
import static com.github.parisoft.magic.engine.game.Games.currentGame;
import static com.github.parisoft.magic.engine.game.Games.currentTurn;
import static com.github.parisoft.magic.engine.game.Games.defendingPlayer;
import static com.github.parisoft.magic.engine.game.Games.not;

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
        } while (not(currentGame().perform(event)));
    }
    
    private void assignAttackDamageOrder() {
        for (Card attacker : currentTurn().getAttackers()) {
            if (attacker.getBlockedBy().size() > 1) {
                for (Card blocker : attackingPlayer().answer(new AssignAttackDamageOrderQuestion(attacker))) {
                    attacker.getBlockedBy().remove(blocker);
                    attacker.getBlockedBy().put(blocker, 0);
                }
            }
        }
    }
    
    private void assignBlockDamageOrder() {
        for (Card blocker : currentTurn().getBlockers()) {
            if (blocker.getAttackedBy().size() > 1) {
                for (Card attacker : defendingPlayer().answer(new AssignBlockDamageOrderQuestion(blocker))) {
                    blocker.getAttackedBy().remove(attacker);
                    blocker.getAttackedBy().put(attacker, 0);
                }
            }
        }
    }

}

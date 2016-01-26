package com.github.parisoft.magic.engine.game.step;

import static com.github.parisoft.magic.engine.game.Games.activePlayer;
import static com.github.parisoft.magic.engine.game.Games.currentGame;
import static com.github.parisoft.magic.engine.game.Games.currentTurn;
import static com.github.parisoft.magic.engine.game.Games.not;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.event.AssignAttackDamageEvent;
import com.github.parisoft.magic.engine.game.question.combat.AssignAttackDamageQuestion;

public class CombatDamageStep extends Step {

    @Override
    protected void runStep() {
        for (Card attacker : currentTurn().getAttackers()) {
            if (attacker.isBlocked()) {
                if (attacker.getBlockedBy().size() > 1) {
                    AssignAttackDamageEvent event;
                    
                    do {
                        event = new AssignAttackDamageEvent(attacker, activePlayer().answer(new AssignAttackDamageQuestion(attacker)));
                    } while (not(currentGame().perform(event)));
                } else {

                }
            } else {
                //assign all damage to entity
            }
        }
    }

}

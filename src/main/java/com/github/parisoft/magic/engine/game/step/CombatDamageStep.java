package com.github.parisoft.magic.engine.game.step;

import static com.github.parisoft.magic.engine.game.Games.currentTurn;

import com.github.parisoft.magic.engine.core.entity.Card;

public class CombatDamageStep extends Step {

    @Override
    protected void runStep() {
        for (Card attacker : currentTurn().getAttackers()) {
            if (attacker.isBlocked()) {
                
            } else {
                //assign all damage to entity
            }
        }
    }

}

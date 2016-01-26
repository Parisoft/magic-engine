package com.github.parisoft.magic.engine.game.step;

import static com.github.parisoft.magic.engine.game.Games.attackingPlayer;
import static com.github.parisoft.magic.engine.game.Games.currentTurn;
import static java.lang.Math.min;

import java.util.Map.Entry;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.game.question.combat.AssignAttackDamageQuestion;

public class CombatDamageStep extends Step {

    @Override
    protected void runStep() {
        for (Card attacker : currentTurn().getAttackers()) {
            if (attacker.isBlocked()) {
                if (attacker.getBlockedBy().size() > 1) {
                    int remainingPower = attacker.getPower();
                    
                    for (Entry<Card, Integer> entry : attacker.getBlockedBy().entrySet()) {
                        if (remainingPower <= 0) {
                            break;
                        }
                        
                        Card blocker = entry.getKey();
                        int remainingToug = blocker.getToughness() - blocker.getDamage();
                        
                        if (remainingToug <= 0) {
                            continue;
                        }
                        
                        int damage = min(remainingPower, remainingToug);
                        //assign damage to blocker
                        remainingPower -= damage;
                    }
                    
                    if (remainingPower > 0) {
                        attackingPlayer().answer(new AssignAttackDamageQuestion(attacker));
                        //reassign damage
                    }
                } else {
                    //assign all damage to single blocker
                }
            } else {
                //assign all damage to entity
            }
        }
    }

}

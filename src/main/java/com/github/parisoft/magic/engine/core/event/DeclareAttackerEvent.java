package com.github.parisoft.magic.engine.core.event;

import static com.github.parisoft.magic.engine.game.Games.currentTurn;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.entity.Entity;

public class DeclareAttackerEvent extends Event {

    private final Card attacker;
    private final Entity attacked;

    public DeclareAttackerEvent(Card attacker, Entity attacked) {
        this.attacker = attacker;
        this.attacked = attacked;
    }

    @Override
    public void perform() {
        attacker.setAttackedEntity(attacked);
        currentTurn().getAttackers().add(attacker);
    }

    public Card getAttacker() {
        return attacker;
    }
    
    public Entity getAttacked() {
        return attacked;
    }
}

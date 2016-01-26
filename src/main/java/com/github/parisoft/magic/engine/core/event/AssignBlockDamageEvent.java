package com.github.parisoft.magic.engine.core.event;

import java.util.Map;
import java.util.Map.Entry;

import com.github.parisoft.magic.engine.core.entity.Card;

public class AssignBlockDamageEvent extends Event {

    private final Card blocker;
    private final Map<Card, Integer> attackers;

    public AssignBlockDamageEvent(Card blocker, Map<Card, Integer> attackers) {
        this.blocker = blocker;
        this.attackers = attackers;
    }

    @Override
    public void perform() {
        for (Entry<Card, Integer> entry : attackers.entrySet()) {
            Card attacker = entry.getKey();
            Integer damage = entry.getValue();
            blocker.getAttackedBy().replace(attacker, damage);
        }
    }

    public Card getBlocker() {
        return blocker;
    }
    
    public Map<Card, Integer> getAttackers() {
        return attackers;
    }
}

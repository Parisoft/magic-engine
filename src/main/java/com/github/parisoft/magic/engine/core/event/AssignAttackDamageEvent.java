package com.github.parisoft.magic.engine.core.event;

import static java.util.Collections.emptyMap;

import java.util.Map;
import java.util.Map.Entry;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.entity.Entity;

public class AssignAttackDamageEvent extends Event {

    private final Card attacker;
    private final Map<Card, Integer> blockers;

    public AssignAttackDamageEvent(Card attacker) {
        this.attacker = attacker;
        this.blockers = emptyMap();
    }
    
    public AssignAttackDamageEvent(Card attacker, Map<Card, Integer> blockers) {
        this.attacker = attacker;
        this.blockers = blockers;
    }

    @Override
    public void perform() {
        if (attacker.isBlocked()) {
            for (Entry<Card, Integer> entry : blockers.entrySet()) {
                Card blocker = entry.getKey();
                Integer damage = entry.getValue();
                attacker.getBlockedBy().replace(blocker, damage);
            }
        } else {
            for (Entity entity : attacker.getAttackedEntity().keySet()) {
                attacker.getAttackedEntity().replace(entity, attacker.getPower());
            }
        }
    }

    public Card getAttacker() {
        return attacker;
    }

    public Map<Card, Integer> getBlockers() {
        return blockers;
    }
}

package com.github.parisoft.magic.engine.game.question.combat;

import java.util.Map;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.game.question.Question;

public class AssignAttackDamageQuestion extends Question<Map<Card, Integer>> {

    private final Card attacker;
    private final Map<Card, Integer> blockers;
    
    public AssignAttackDamageQuestion(Card attacker) {
        super("Assign the attacker damage among blockers");
        this.attacker = attacker;
        this.blockers = attacker.getBlockedBy();
    }

    public Card getAttacker() {
        return attacker;
    }
    
    public Map<Card, Integer> getBlockers() {
        return blockers;
    }
}

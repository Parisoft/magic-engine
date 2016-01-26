package com.github.parisoft.magic.engine.game.question.combat;

import java.util.Map;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.game.question.Question;

public class AssignBlockDamageQuestion extends Question<Map<Card, Integer>> {

    private final Card blocker;
    private final Map<Card, Integer> attackers;
    
    public AssignBlockDamageQuestion(Card blocker) {
        super("Assign the blocker damager among attackers");
        this.blocker = blocker;
        this.attackers = blocker.getAttackedBy();
    }
    
    public Card getBlocker() {
        return blocker;
    }
    
    public Map<Card, Integer> getAttackers() {
        return attackers;
    }

}

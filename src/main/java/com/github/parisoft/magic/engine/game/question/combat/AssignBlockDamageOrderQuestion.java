package com.github.parisoft.magic.engine.game.question.combat;

import java.util.List;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.game.question.Question;

public class AssignBlockDamageOrderQuestion extends Question<List<Card>> {

    private final Card blocker;
    private final List<Card> attackers;
    
    public AssignBlockDamageOrderQuestion(Card blocker) {
        super("Choose the order your creature will deal damage");
        this.blocker = blocker;
        this.attackers = blocker.getBlocking();
    }

    public Card getBlocker() {
        return blocker;
    }
    
    public List<Card> getAttackers() {
        return attackers;
    }
    
}

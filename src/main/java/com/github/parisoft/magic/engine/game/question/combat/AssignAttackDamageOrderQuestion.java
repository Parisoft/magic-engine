package com.github.parisoft.magic.engine.game.question.combat;

import java.util.List;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.game.question.Question;

public class AssignAttackDamageOrderQuestion extends Question<List<Card>> {

    private final Card attacker;
    private final List<Card> blockers;
    
    
    public AssignAttackDamageOrderQuestion(Card attacker) {
        super("Choose the order your creature will deal damage");
        this.attacker = attacker;
        this.blockers = attacker.getBlocked();
    }

    public Card getAttacker() {
        return attacker;
    }
    
    public List<Card> getBlockers() {
        return blockers;
    }
}

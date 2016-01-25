package com.github.parisoft.magic.engine.core.event;

import static com.github.parisoft.magic.engine.game.Games.currentGame;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import java.util.ArrayList;
import java.util.List;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.entity.Player;
import com.github.parisoft.magic.engine.game.question.combat.Attack;
import com.github.parisoft.magic.engine.game.question.combat.DeclareAttackersQuestion;

public class DeclareAttackersEvent extends Event {

    private List<Attack> attackList = new ArrayList<>();
    
    public DeclareAttackersEvent(List<Attack> attackList) {
        this.attackList.addAll(emptyIfNull(attackList));
    }
    
    public DeclareAttackersEvent(DeclareAttackersQuestion question) {
        attackList.addAll(emptyIfNull(question.getAnswer()));
    }
    
    public DeclareAttackersEvent(Card attacker, Object attacked) {
        attackList.add(new Attack(attacker, attacked));
    }
    
    @Override
    public void perform() {
        for (Attack attack : attackList) {
            Card attacker = (Card) attack.getAttacker();
            
            if (attack.getAttacked() instanceof Player) {
                currentGame().perform(new DeclareAttackerEvent(attacker, (Player) attack.getAttacked()));
            } else {
                currentGame().perform(new DeclareAttackerEvent(attacker, (Card) attack.getAttacked()));
            }
        }
    }
    
    public List<Attack> getAttackList() {
        return attackList;
    }
}

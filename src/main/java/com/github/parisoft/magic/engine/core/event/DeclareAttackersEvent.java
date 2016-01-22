package com.github.parisoft.magic.engine.core.event;

import static com.github.parisoft.magic.engine.game.Games.currentTurn;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.entity.Player;
import com.github.parisoft.magic.engine.game.combat.AttackerDeclaration;

public class DeclareAttackersEvent extends Event {

    private Map<Card, Object> attackers = new HashMap<>();
    
    public DeclareAttackersEvent(AttackerDeclaration declaration) {
        for (Entry<Card, Card> attack : declaration.getPlaneswalkerAttackers().entrySet()) {
            attackers.put(attack.getKey(), attack.getValue());
        }
        
        for (Entry<Card, Player> attack : declaration.getPlayerAttackers().entrySet()) {
            attackers.put(attack.getKey(), attack.getValue());
        }
    }
    
    public DeclareAttackersEvent(Card attacker, Object attacked) {
        attackers.put(attacker, attacked);
    }
    
    @Override
    public void perform() {
        for (Card attacker : attackers.keySet()) {
            attacker.setAttacking(true);
            currentTurn().getAttackers().add(attacker);
        }
    }
    
    public Map<Card, Object> getAttackers() {
        return attackers;
    }
}

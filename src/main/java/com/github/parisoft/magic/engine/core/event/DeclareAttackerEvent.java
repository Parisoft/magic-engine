package com.github.parisoft.magic.engine.core.event;

import static com.github.parisoft.magic.engine.game.Games.currentTurn;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.entity.Player;

public class DeclareAttackerEvent extends Event {

    private final Card attacker;
    private final Card attackedPlaneswalker;
    private final Player attackedPlayer;

    public DeclareAttackerEvent(Card attacker, Player attacked) {
        this.attacker = attacker;
        this.attackedPlayer = attacked;
        this.attackedPlaneswalker = null;
    }

    public DeclareAttackerEvent(Card attacker, Card attacked) {
        this.attacker = attacker;
        this.attackedPlayer = null;
        this.attackedPlaneswalker = attacked;
    }

    @Override
    public void perform() {
        currentTurn().getAttackers().add(attacker);
    }

    public Card getAttacker() {
        return attacker;
    }
    
    public Player getAttackedPlayer() {
        return attackedPlayer;
    }
    
    public Card getAttackedPlaneswalker() {
        return attackedPlaneswalker;
    }
}

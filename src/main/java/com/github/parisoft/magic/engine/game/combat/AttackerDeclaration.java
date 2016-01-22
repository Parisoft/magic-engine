package com.github.parisoft.magic.engine.game.combat;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.entity.Player;

public class AttackerDeclaration {

    private final Map<Card, Player> playerAttackers = new HashMap<>();
    private final Map<Card, Card> planeswalkerAttackers = new HashMap<>();

    public Map<Card, Player> getPlayerAttackers() {
        return playerAttackers;
    }

    public Map<Card, Card> getPlaneswalkerAttackers() {
        return planeswalkerAttackers;
    }

    public Collection<Card> getAttackers() {
        Set<Card> attackers = new HashSet<>();
        attackers.addAll(playerAttackers.keySet());
        attackers.addAll(planeswalkerAttackers.keySet());
        
        return attackers;
    }
}

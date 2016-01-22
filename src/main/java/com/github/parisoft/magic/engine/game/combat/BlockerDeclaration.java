package com.github.parisoft.magic.engine.game.combat;

import java.util.HashMap;
import java.util.Map;

import com.github.parisoft.magic.engine.core.entity.Card;

public class BlockerDeclaration {

    private final Map<Card, Card> blockers = new HashMap<>();

    public Map<Card, Card> getBlockers() {
        return blockers;
    }
}

package com.github.parisoft.magic.engine.core.event;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.zone.Zone;

public class MoveEvent extends Event {

    protected Card card;
    protected Zone<Card> fromZone;
    protected Zone<Card> toZone;
    
    public MoveEvent(Card card, Zone<Card> fromZone, Zone<Card> toZone) {
        this.card = card;
        this.fromZone = fromZone;
        this.toZone = toZone;
    }

    @Override
    public void resolve() {
        fromZone.remove(card);
        toZone.add(card);
    }

}

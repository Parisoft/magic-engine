package com.github.parisoft.magic.engine.core.event;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.zone.Zone;

public class LeaveZoneEvent extends Event {

    protected Card card;
    protected Zone<Card> fromZone;
    
    public LeaveZoneEvent(Card card, Zone<Card> fromZone) {
        this.card = card;
        this.fromZone = fromZone;
    }

    @Override
    public void perform() {
        fromZone.remove(card);
    }
    
}

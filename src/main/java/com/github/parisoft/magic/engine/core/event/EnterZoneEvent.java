package com.github.parisoft.magic.engine.core.event;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.zone.Zone;

public class EnterZoneEvent extends Event {

    private Card card;
    private Zone<Card> toZone;

    public EnterZoneEvent(Card card, Zone<Card> toZone) {
        this.card = card;
        this.toZone = toZone;
    }

    @Override
    public void perform() {
        toZone.add(card);
    }

}

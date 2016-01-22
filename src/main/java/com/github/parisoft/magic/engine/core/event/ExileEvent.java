package com.github.parisoft.magic.engine.core.event;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.zone.Exile;
import com.github.parisoft.magic.engine.core.zone.Zone;


public class ExileEvent extends ZoneChangeEvent {

    public ExileEvent(Card card, Zone<Card> fromZone, Exile exile) {
        super(card, fromZone, exile);
    }

}

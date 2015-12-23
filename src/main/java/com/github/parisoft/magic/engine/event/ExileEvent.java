package com.github.parisoft.magic.engine.event;

import com.github.parisoft.magic.engine.entity.Card;
import com.github.parisoft.magic.engine.zone.Exile;
import com.github.parisoft.magic.engine.zone.Zone;


public class ExileEvent extends MoveEvent {

    public ExileEvent(Card card, Zone<Card> fromZone, Exile exile) {
        super(card, fromZone, exile);
    }

}

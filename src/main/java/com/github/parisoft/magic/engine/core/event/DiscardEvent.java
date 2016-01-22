package com.github.parisoft.magic.engine.core.event;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.zone.Graveyard;
import com.github.parisoft.magic.engine.core.zone.Hand;

public class DiscardEvent extends ZoneChangeEvent {

    public DiscardEvent(Card card, Hand hand, Graveyard graveyard) {
        super(card, hand, graveyard);
    }
    
}

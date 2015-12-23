package com.github.parisoft.magic.engine.event;

import com.github.parisoft.magic.engine.entity.Card;
import com.github.parisoft.magic.engine.zone.Graveyard;
import com.github.parisoft.magic.engine.zone.Hand;

public class DiscardEvent extends MoveEvent {

    public DiscardEvent(Card card, Hand hand, Graveyard graveyard) {
        super(card, hand, graveyard);
    }
    
}

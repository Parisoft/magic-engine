package com.github.parisoft.magic.engine.core.event;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.zone.Battlefield;
import com.github.parisoft.magic.engine.core.zone.Graveyard;


public class DestroyEvent extends MoveEvent {

    public DestroyEvent(Card card, Battlefield battlefield, Graveyard graveyard) {
        super(card, battlefield, graveyard);
    }

}

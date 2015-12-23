package com.github.parisoft.magic.engine.event;

import com.github.parisoft.magic.engine.entity.Card;
import com.github.parisoft.magic.engine.zone.Battlefield;
import com.github.parisoft.magic.engine.zone.Graveyard;


public class DestroyEvent extends MoveEvent {

    public DestroyEvent(Card card, Battlefield battlefield, Graveyard graveyard) {
        super(card, battlefield, graveyard);
    }

}

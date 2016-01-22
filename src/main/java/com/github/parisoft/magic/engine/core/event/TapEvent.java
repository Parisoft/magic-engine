package com.github.parisoft.magic.engine.core.event;

import com.github.parisoft.magic.engine.core.entity.Card;

public class TapEvent extends Event {

    private Card card;

    public TapEvent(Card card) {
        this.card = card;
    }

    @Override
    public void perform() {
        card.setTapped(true);
    }

}

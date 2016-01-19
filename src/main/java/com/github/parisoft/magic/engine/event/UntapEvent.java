package com.github.parisoft.magic.engine.event;

import com.github.parisoft.magic.engine.entity.Card;

public class UntapEvent extends Event {

    private Card card;

    public UntapEvent(Card card) {
        this.card = card;
    }

    @Override
    public void resolve() {
        card.setTapped(false);
    }

}

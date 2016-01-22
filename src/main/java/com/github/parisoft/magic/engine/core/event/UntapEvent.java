package com.github.parisoft.magic.engine.core.event;

import com.github.parisoft.magic.engine.core.entity.Card;

public class UntapEvent extends Event {

    private Card card;

    public UntapEvent(Card card) {
        this.card = card;
    }

    @Override
    public void perform() {
        card.setTapped(false);
    }

}

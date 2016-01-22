package com.github.parisoft.magic.engine.core.event;

import com.github.parisoft.magic.engine.core.entity.Card;

public class PhaseOutEvent extends Event {

    private Card card;
    
    public PhaseOutEvent(Card card) {
        this.card = card;
    }
    
    @Override
    public void perform() {
        card.setPhased(true);
    }

}

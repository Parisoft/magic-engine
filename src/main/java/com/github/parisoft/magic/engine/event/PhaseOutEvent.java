package com.github.parisoft.magic.engine.event;

import com.github.parisoft.magic.engine.entity.Card;

public class PhaseOutEvent extends Event {

    private Card card;
    
    public PhaseOutEvent(Card card) {
        this.card = card;
    }
    
    @Override
    public void resolve() {
        card.setPhased(true);
    }

}

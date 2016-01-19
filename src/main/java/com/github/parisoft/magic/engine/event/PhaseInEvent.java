package com.github.parisoft.magic.engine.event;

import com.github.parisoft.magic.engine.entity.Card;

public class PhaseInEvent extends Event {

    private Card card;
    
    public PhaseInEvent(Card card) {
        this.card = card;
    }
    
    @Override
    public void resolve() {
        card.setPhased(false);
    }

}

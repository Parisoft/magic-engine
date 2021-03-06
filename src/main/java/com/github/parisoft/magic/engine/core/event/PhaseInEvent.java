package com.github.parisoft.magic.engine.core.event;

import com.github.parisoft.magic.engine.core.entity.Card;

public class PhaseInEvent extends Event {

    private Card card;
    
    public PhaseInEvent(Card card) {
        this.card = card;
    }
    
    @Override
    public void perform() {
        card.setPhased(false);
    }

}

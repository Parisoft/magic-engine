package com.github.parisoft.magic.engine.core.event;

import static com.github.parisoft.magic.engine.game.Games.currentGame;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.zone.Zone;

public class ZoneChangeEvent extends Event {

    protected Card card;
    protected Zone<Card> fromZone;
    protected Zone<Card> toZone;
    
    public ZoneChangeEvent(Card card, Zone<Card> fromZone, Zone<Card> toZone) {
        this.card = card;
        this.fromZone = fromZone;
        this.toZone = toZone;
    }

    @Override
    public void perform() {
        LeaveZoneEvent leaveZoneEvent = new LeaveZoneEvent(card, fromZone);
        
        currentGame().perform(leaveZoneEvent);
        
        if (leaveZoneEvent.isIllegal() 
                || leaveZoneEvent.isReplaced()) {
            return;
        }
        
        currentGame().perform(new EnterZoneEvent(card, toZone));
    }

}

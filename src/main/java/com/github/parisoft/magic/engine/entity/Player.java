package com.github.parisoft.magic.engine.entity;

import static com.github.parisoft.magic.engine.game.Games.currentGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.parisoft.magic.engine.zone.Graveyard;
import com.github.parisoft.magic.engine.zone.Hand;
import com.github.parisoft.magic.engine.zone.Library;

public class Player {

    private String name;
    private int life;
    private Hand hand;
    private Graveyard graveyard;
    private Library library;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Graveyard getGraveyard() {
        return graveyard;
    }

    public void setGraveyard(Graveyard graveyard) {
        this.graveyard = graveyard;
    }
    
    public Library getLibrary() {
        return library;
    }

    public Collection<Card> getPermanents() {
        List<Card> permanents = new ArrayList<>();
        
        for (Card card : currentGame().getBattlefield()) {
            if (card.getController().equals(this)) {
                permanents.add(card);
            }
        }
        
        return permanents;
    }
}

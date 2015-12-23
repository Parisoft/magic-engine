package com.github.parisoft.magic.engine.entity;

import com.github.parisoft.magic.engine.zone.Graveyard;
import com.github.parisoft.magic.engine.zone.Hand;

public class Player {

    private String name;
    private int life;
    private Hand hand;
    private Graveyard graveyard;

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

}

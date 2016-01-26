package com.github.parisoft.magic.engine.core.entity;

import static com.github.parisoft.magic.engine.game.Games.currentGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.parisoft.magic.engine.core.zone.Graveyard;
import com.github.parisoft.magic.engine.core.zone.Hand;
import com.github.parisoft.magic.engine.core.zone.Library;
import com.github.parisoft.magic.engine.game.question.Question;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Player {

    private String name;
    private int life;
    private int maximumHandSize;
    private Hand hand;
    private Graveyard graveyard;
    private Library library;
    private Player opponent;
    
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
    
    public int getMaximumHandSize() {
        return maximumHandSize;
    }
    
    public void setMaximumHandSize(int maximumHandSize) {
        this.maximumHandSize = maximumHandSize;
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

    public Player getOpponent() {
        return opponent;
    }
    
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
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
    
    public <T> T answer(Question<T> question) {
        //TODO mtg: implement question request
        return question.getAnswer();
    }
}

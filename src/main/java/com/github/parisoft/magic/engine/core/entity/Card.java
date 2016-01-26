package com.github.parisoft.magic.engine.core.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Card extends MtgObject {

    private boolean tapped = false;
    private boolean phased = false;
    private boolean blocked = false;
    private @JsonIgnore Entity attackedEntity;
    private @JsonIgnore final Map<Card, Integer> blockedBy = new LinkedHashMap<>();
    private @JsonIgnore final Map<Card, Integer> attackedBy = new LinkedHashMap<>();

    public boolean isTapped() {
        return tapped;
    }

    public void setTapped(boolean tapped) {
        this.tapped = tapped;
    }

    public boolean isPhased() {
        return phased;
    }

    public void setPhased(boolean phased) {
        this.phased = phased;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Entity getAttackedEntity() {
        return attackedEntity;
    }

    public void setAttackedEntity(Entity attackedEntity) {
        this.attackedEntity = attackedEntity;
    }

    public Map<Card, Integer> getBlockedBy() {
        return blockedBy;
    }

    public Map<Card, Integer> getAttackedBy() {
        return attackedBy;
    }

}

package com.github.parisoft.magic.engine.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Entity {

    protected String id;
    protected long timestamp = 0;
    protected int damage = 0;
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    public boolean isEarlierThan(Entity other) {
        return this.timestamp < other.timestamp;
    }
    
    public boolean isEarlierOrSameThan(Entity other) {
        return this.timestamp <= other.timestamp;
    }
    
    public boolean isLaterThan(Entity other) {
        return this.timestamp > other.timestamp;
    }
    
    public boolean isLaterOrSameThan(Entity other) {
        return this.timestamp >= other.timestamp;
    }
    
    public boolean isSameThan(Entity other) {
        return this.timestamp == other.timestamp;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }
}

package com.github.parisoft.magic.engine.core.entity;


public class Timestampable {

    protected long timestamp = 0;
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    public boolean isEarlierThan(Timestampable other) {
        return this.timestamp < other.timestamp;
    }
    
    public boolean isEarlierOrSameThan(Timestampable other) {
        return this.timestamp <= other.timestamp;
    }
    
    public boolean isLaterThan(Timestampable other) {
        return this.timestamp > other.timestamp;
    }
    
    public boolean isLaterOrSameThan(Timestampable other) {
        return this.timestamp >= other.timestamp;
    }
    
    public boolean isSameThan(Timestampable other) {
        return this.timestamp == other.timestamp;
    }
}

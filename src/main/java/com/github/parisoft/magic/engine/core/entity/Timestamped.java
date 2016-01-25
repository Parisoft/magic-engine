package com.github.parisoft.magic.engine.core.entity;


public class Timestamped {

    protected long timestamp = 0;
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    public boolean isEarlierThan(Timestamped other) {
        return this.timestamp < other.timestamp;
    }
    
    public boolean isEarlierOrSameThan(Timestamped other) {
        return this.timestamp <= other.timestamp;
    }
    
    public boolean isLaterThan(Timestamped other) {
        return this.timestamp > other.timestamp;
    }
    
    public boolean isLaterOrSameThan(Timestamped other) {
        return this.timestamp >= other.timestamp;
    }
    
    public boolean isSameThan(Timestamped other) {
        return this.timestamp == other.timestamp;
    }
}

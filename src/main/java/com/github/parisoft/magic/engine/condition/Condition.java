package com.github.parisoft.magic.engine.condition;

public abstract class Condition<T> {

    public abstract boolean meets(T object);
}

package com.github.parisoft.magic.engine.interpreter;

public abstract class Expression<T> {

    public abstract T interpret(Token token);
}

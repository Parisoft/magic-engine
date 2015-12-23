package com.github.parisoft.magic.engine.interpreter;

import static org.apache.commons.lang3.StringUtils.split;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

public class Token implements ListIterator<String> {

    private static final Pattern SEPARATORS_PATTERN = Pattern.compile("((?<=,)|(?=,)|(?<=:)|(?=:)|(?<=\\.)|(?=\\.))");
    
    private List<String> tokenList;
    private ListIterator<String> iterator;
    private String current;
    private String lastCurrent;
    private int checkpoint;
    
    public Token(String text) {
        tokenize(text);
        iterator = tokenList.listIterator();
    }
    
    private void tokenize(String string) {
        tokenList = new ArrayList<>();
        
        for (String substring : SEPARATORS_PATTERN.split(string)) {
            tokenList.addAll(Arrays.asList(split(substring)));
        }
    }
    
    public String current() {
        return current;
    }
    
    public void checkpoint() {
        checkpoint = iterator.nextIndex();
        lastCurrent = current;
    }
    
    public void rewind() {
        iterator = tokenList.listIterator(checkpoint);
        current = lastCurrent;
    }
    
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public String next() {
        if (hasNext()) {
            return current = iterator.next();
        }
        
        return current = null;
    }
    
    @Override
    public boolean hasPrevious() {
        return iterator.hasPrevious();
    }

    @Override
    public String previous() {
        if (hasPrevious()) {
            return current = iterator.previous();
        }
        
        return current = null;
    }

    @Override
    public int nextIndex() {
        return iterator.nextIndex();
    }

    @Override
    public int previousIndex() {
        return iterator.previousIndex();
    }

    @Override
    public void remove() {
        iterator.remove();
    }

    @Override
    public void set(String e) {
        iterator.set(e);
    }

    @Override
    public void add(String e) {
        iterator.add(e);
    }

    @Override
    public String toString() {
        return current;
    }
}

package com.github.parisoft.magic.engine.core.oracle;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.parisoft.magic.engine.core.entity.Card;

@Component
public class Oracle {

    private final Map<String, Card> cards = new HashMap<>();

    @PostConstruct
    public void init() throws Exception {
        InputStream setStream = getClass().getClassLoader().getResourceAsStream("AllCards.json");
        cards.putAll(new ObjectMapper().readValue(setStream, new TypeReference<Map<String, Card>>(){}));
    }

    public Card getCard(String name) {
        return cards.get(name);
    }

    public Collection<Card> getCards() {
        return cards.values();
    }
}

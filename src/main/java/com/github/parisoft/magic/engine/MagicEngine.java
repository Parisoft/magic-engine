package com.github.parisoft.magic.engine;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;
import static org.apache.commons.lang3.StringUtils.replace;
import static org.apache.commons.lang3.StringUtils.split;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.parisoft.magic.engine.entity.Card;
import com.github.parisoft.magic.engine.interpreter.AbilityExpression;
import com.github.parisoft.magic.engine.interpreter.Token;

@SpringBootApplication
@ComponentScan("com.github.parisoft.magic")
public class MagicEngine {

    private static final Logger log = LoggerFactory.getLogger(MagicEngine.class);

    private static ConfigurableApplicationContext ctx;

    public static void main(String[] args) throws IOException {
        ctx = SpringApplication.run(MagicEngine.class, args);

        search();
    }

    static void search() throws IOException {
        for (Card card : getOracle().values()) {
            String name = card.getName();
            String text = card.getText();

            boolean condition = 
                    containsIgnoreCase(text, " divid ");

            if (condition) {
                log.info("Card '{}' text '{}'", name, text);
            }
        }
    }

    static void testInterpret() throws IOException {
        AbilityExpression abilityExpression = ctx.getBean(AbilityExpression.class);
        Card card = getOracle().get("Brood of Cockroaches");
        String textBox = card.getText();
        String[] texts = split(textBox, '\n');

        log.info("Card '{}' text '{}'", card.getName(), card.getText());

        for (String text : texts) {
            text = replace(text, card.getName(), "THIS");
            log.info(abilityExpression.interpret(new Token(text)));
        }
    }

    private static Map<String, Card> getOracle() throws IOException {
        File setFile = new ClassPathResource("AllCards.json").getFile();
        return new ObjectMapper().readValue(setFile, new TypeReference<Map<String, Card>>(){});
    }
}

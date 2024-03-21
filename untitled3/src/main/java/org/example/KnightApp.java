package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class KnightApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        String knightName = "strongKnight";
        Knight knight = (Knight) context.getBean(knightName);
        knight.fight();

        String knightName2 = "weakKnight";
        Knight knight2 = (Knight) context.getBean(knightName2);
        knight2.fight();

        String knightName3 = "kingOfKnights";
        Knight knight3 = (Knight) context.getBean(knightName3);
        knight3.fight();
    }
}

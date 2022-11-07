package com.chrisom;

import java.lang.Thread;
import java.util.Random;

public class BolaOcho {

    private int getSleepTimeInMs(Pregunta.Dificultad dificultad) {
        switch (dificultad) {
            case FACIL:
                return 1000;
            case MEDIO:
                return 2000;
            case DIFICIL:
                return 3000;
            default:
                return 500;
        }
    }

    private String answer() {
        String[] answers = {
                "Para mi parece que si!",
                "Por su pollo!",
                "Sin comentarios",
                "Esta dura de contestar, intenta de nuevo.",
                "Seguramente.",
                "No.",
                "Para mi parece que no.",
                "Seria muy bueno!"
        };
        return answers[new Random().nextInt(answers.length)];
    }

    private void think(Pregunta pregunta) {
        System.out.println("Dejame ver... Pensando");
        try {
            Thread.sleep(this.getSleepTimeInMs(pregunta.getDificultad()));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Listo!");
    }

    public void ask(Pregunta pregunta) {
        System.out.println("Buena pregunta! Preguntaste: " + pregunta.getPregunta());
        this.think(pregunta);
        System.out.println("Respuesta: " + this.answer());
    }

}

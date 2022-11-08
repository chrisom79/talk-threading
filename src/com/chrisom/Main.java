package com.chrisom;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Pregunta> preguntas = Arrays.asList(
                new Pregunta(Pregunta.Dificultad.FACIL, "Soy un buen programador?"),
                new Pregunta(Pregunta.Dificultad.MEDIO, "Acabaremos a tiempo esta sesion?"),
                new Pregunta(Pregunta.Dificultad.DIFICIL, "Pasara la seleccion al quinto partido?"),
                new Pregunta(Pregunta.Dificultad.FACIL, "Algun dia hare threading?"),
                new Pregunta(Pregunta.Dificultad.DIFICIL, "Me ganare la loteria?"),
                new Pregunta(Pregunta.Dificultad.MEDIO, "Algun dia le ganare en dinero a Elon Musk?")
        );

        preguntas.stream().forEach(q -> {
            BolaOcho c = new BolaOcho(q);
            c.start();
        });
    }
}

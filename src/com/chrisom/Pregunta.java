package com.chrisom;

public record Pregunta(Dificultad dificultad, String pregunta) {
    enum Dificultad {
        FACIL, MEDIO, DIFICIL
    }
}

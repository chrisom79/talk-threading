package com.chrisom;

public class Pregunta {
    enum Dificultad {
        FACIL, MEDIO, DIFICIL

    }

    public Pregunta(Dificultad dificultad, String pregunta) {
        this.dificultad = dificultad;
        this.pregunta = pregunta;
    }

    Dificultad dificultad;
    String pregunta;

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}

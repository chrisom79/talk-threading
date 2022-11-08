package com.chrisom;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static Thread createMonitor(List<Thread> threads) {
        return new Thread(() -> {
            while (true) {
                List<String> runningThreads = threads.stream().filter(Thread::isAlive).map(Thread::getName).collect(Collectors.toList());
                System.out.println(Thread.currentThread().getName() + " - Actualmente corriendo: " + runningThreads);
                if (runningThreads.isEmpty()) {
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + " - Todos los hilos completados!");
        });
    }

    public static void main(String[] args) {
        List<Pregunta> preguntas = Arrays.asList(
                new Pregunta(Pregunta.Dificultad.FACIL, "Soy un buen programador?"),
                new Pregunta(Pregunta.Dificultad.MEDIO, "Acabaremos a tiempo esta sesion?"),
                new Pregunta(Pregunta.Dificultad.DIFICIL, "Pasara la seleccion al quinto partido?"),
                new Pregunta(Pregunta.Dificultad.FACIL, "Algun dia hare threading?"),
                new Pregunta(Pregunta.Dificultad.DIFICIL, "Me ganare la loteria?"),
                new Pregunta(Pregunta.Dificultad.MEDIO, "Algun dia le ganare en dinero a Elon Musk?")
        );

        BolaOcho bolaOcho = new BolaOcho();

        List<Thread> threads = preguntas.stream().map(q -> new Thread(() -> {
            bolaOcho.ask(q);
        })).collect(Collectors.toList());

        Thread monitor = Main.createMonitor(threads);
        threads.forEach(t -> t.start());
        monitor.start();
    }
}

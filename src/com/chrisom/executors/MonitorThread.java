package com.chrisom.executors;

import java.util.concurrent.ThreadPoolExecutor;

public class MonitorThread implements Runnable {
    private ThreadPoolExecutor executor;
    private int seconds;
    private boolean run = true;

    public MonitorThread(ThreadPoolExecutor executor, int delay) {
        this.executor = executor;
        this.seconds = delay;
    }

    public void shutdown() {
        this.run=false;
    }
    @Override
    public void run() {
        while(run) {
            System.out.println(
                    String.format("[monitor] [%d/%d] Activo: %d, Completados: %d, Conteo de tareas: %d, Apagado: %s, Terminado: %s",
                            this.executor.getPoolSize(), this.executor.getCorePoolSize(), this.executor.getActiveCount(),
                            this.executor.getCompletedTaskCount(), this.executor.getTaskCount(), this.executor.isShutdown(),
                            this.executor.isTerminated()));
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

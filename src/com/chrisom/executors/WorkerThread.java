package com.chrisom.executors;

public class WorkerThread implements Runnable {
    private String command;

    public WorkerThread(String s){
        this.command=s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" comienza. Command = " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+" termina.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}

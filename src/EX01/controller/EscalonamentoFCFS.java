package EX01.controller;

import java.util.concurrent.Semaphore;

public class EscalonamentoFCFS extends Thread {
    /*Considerando o esquema de escalonamento não preemptivo chamado FCFS, faça uma
    simulação de execução de processos, em Java com Threads e Semáforos, considerando
    que 20 processos foram carregados na memória, cada um deles pode durar de 4 a 120
    segundos para rodar*/

    private static final Semaphore semaphore = new Semaphore(1);


    private int id=0;
    public EscalonamentoFCFS(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Thread " + id+ " iniciada");
        processo();

    }

    private void processo(){
        try {
            semaphore.acquire();
            System.out.println("Thread " + id+ " passou no semaphore");
            sleep((int)(Math.random()*117000)+4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("Thread " + id+ " saindo do semaphore");
            semaphore.release();
        }
    }





}

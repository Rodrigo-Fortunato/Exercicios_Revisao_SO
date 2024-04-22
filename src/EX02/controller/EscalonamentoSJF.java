package EX02.controller;

import java.util.concurrent.Semaphore;

public class EscalonamentoSJF extends Thread {

/*    Considerando o esquema de escalonamento não preemptivo chamado SJF, faça uma
    simulação de execução de processos, em Java com Threads e Semáforos, considerando
    que 20 processos foram carregados na memória, cada um deles pode durar de 4 a 120
    segundos para rodar*/

    private Semaphore semaphore;
    int id = 0;

    public int getDuracao() {
        return duracao;
    }



    private int duracao = (int) ((Math.random() * 4000) + 4000);

    public EscalonamentoSJF(int id, Semaphore semaphore) {
        this.id = id;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Thread " + id + " iniciada");
        processo();

    }

    private void processo() {

        try {

            System.out.println("Thread " + id + " passou no semaphore");
            System.out.println("Duração do processo "+duracao/1000+"s");
            sleep(duracao);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Thread " + id + " saindo do semaphore");
            semaphore.release();
        }
    }


}

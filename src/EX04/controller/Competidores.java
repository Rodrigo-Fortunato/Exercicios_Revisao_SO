package EX04.controller;

import java.util.concurrent.Semaphore;

public class Competidores extends Thread {

    private static final Semaphore semaphore = new Semaphore(1);
    private static int colocacao = 0;
    int id;
    private static int premio = 5000;

    public Competidores(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        competidor();
    }

    public void competidor() {
        int dado1;
        int dado2;
        int score = 0;

        while (score < 5) {
            dado1 = (int) ((Math.random() * 6) + 1);
            dado2 = (int) ((Math.random() * 6) + 1);

            if (dado1 + dado2 == 7 || dado1 + dado2 == 11) {
                score++;
            }
        }

        try {
            semaphore.acquire();
            colocacao++;
            System.out.println("O competidor " + id + " Conseguiu 5 pontos\n" + "Colocação " + colocacao);

            if (colocacao <= 3) {
                System.out.println("Premio: " + premio);
                premio -= 1000;
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }


    }
}

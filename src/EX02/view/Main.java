package EX02.view;

import EX02.controller.EscalonamentoSJF;
import EX02.controller.ModifiedQuick_Sort;

import java.util.concurrent.Semaphore;


public class Main {
    public static void main(String[] args) {

        EscalonamentoSJF[] vet = new EscalonamentoSJF[20];
        ModifiedQuick_Sort quickSort = new ModifiedQuick_Sort();
        Semaphore semaphore = new Semaphore(1);

        for (int cont = 0; cont < 20; cont++) {
            EscalonamentoSJF sjf = new EscalonamentoSJF(cont,semaphore);
            vet[cont] = sjf;
        }
        quickSort.quickSort(vet, 0, vet.length-1 );


        for (int cont=0;cont<20;cont++) {
            try {
                semaphore.acquire();
                vet[cont].start();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }










    }

}

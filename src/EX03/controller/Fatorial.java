package EX03.controller;

public class Fatorial extends Thread {

    /*Considere que o cálculo de um número fatorial (usando varáveis tipo long) podem ser
    calculados, em Java, de maneira recursiva ou não. Faça duas threads (Uma que calcule
     Fatorial de maneira recursiva e outra não recursiva), onde cada Thread vai receber o
    número que se quer calcular o fatorial, vai exibir o valor do fatorial do número e o tempo
    que cada thread leva para realizar a operação. Considere usar o System.nanoTime() ao
    invés do System.currentTimeMillis(), o resultado sairá em nano segundos.*/

    private long tempoFinal;
    private long tempoInicial;
    private final int numFat;
    private final int id;

    public Fatorial(int numFat,int id) {
        this.id = id;
        this.numFat = numFat;


    }

    @Override
    public void run() {
        if (id == 0) {
            System.out.println("O Fatorial Recursivo de " + numFat + " é: " + fatorialRec(numFat));
        }
        if (id == 1) {
            System.out.println("O Fatorial não Recursivo de " + numFat + " é: " + fatorialSimples(numFat));
        }
    }

    private long fatorialRec(int numFat) {
        tempoInicial = System.nanoTime();
        if (numFat == 0) {
            tempoFinal = System.nanoTime();
            System.out.println("Tempo de execução Recursivo: " + (tempoFinal - tempoInicial) * Math.pow(10, 9) + "s");
            return 1;
        }
        return numFat * fatorialRec(numFat - 1);
    }

    private long fatorialSimples(int numFat) {
        tempoInicial = System.nanoTime();
        long resultado = 1;
        if (numFat == 0) {
            return 1;
        }
        for (int cont = 1; cont <= numFat; cont++) {
            resultado *= cont;
        }
        tempoFinal = System.nanoTime();

        System.out.println("Tempo de execução não Recursivo: " + (tempoFinal - tempoInicial) * Math.pow(10, 9) + "s");
        return resultado;
    }


}

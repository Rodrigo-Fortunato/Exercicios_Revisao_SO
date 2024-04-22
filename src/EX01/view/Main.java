package EX01.view;

import EX01.controller.EscalonamentoFCFS;

public class Main {
    public static void main(String[] args) {
        for (int cont =0;cont <20;cont++) {
            EscalonamentoFCFS noNome = new EscalonamentoFCFS(cont);
            noNome.start();

        }



    }
}

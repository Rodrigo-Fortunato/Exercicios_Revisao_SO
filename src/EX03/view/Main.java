package EX03.view;

import EX03.controller.Fatorial;

public class Main {
    public static void main(String[] args) {

        for (int i=0;i<2;i++){
            Fatorial fatorial = new Fatorial(10, i);
            fatorial.start();
        }
    }
}

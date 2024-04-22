package EX04.view;

import EX04.controller.Competidores;

public class MainCassino {
    public static void main(String[] args) {

        for (int cont=0;cont < 10;cont++){
            Competidores competidores = new Competidores(cont);
            competidores.start();
        }
    }
}

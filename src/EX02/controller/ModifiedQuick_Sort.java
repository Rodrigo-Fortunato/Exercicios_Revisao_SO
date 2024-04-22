package EX02.controller;

public class ModifiedQuick_Sort {
    public ModifiedQuick_Sort(){
        super();
    }

    public EscalonamentoSJF[] quickSort(EscalonamentoSJF[]vetor, int inicio, int fim){
        if (fim > inicio){
            int posicaoPivo = dividir(vetor,inicio,fim);
            quickSort(vetor,inicio,posicaoPivo-1);
            quickSort(vetor,posicaoPivo+1, fim);

        }
        return vetor;

    }

    private int dividir (EscalonamentoSJF[] vetor, int inicio, int fim){
        int ponteiroEsquerda = inicio +1;
        int ponteiroDireita = fim;
        int pivo = vetor[inicio].getDuracao();

        while (ponteiroEsquerda <= ponteiroDireita){
            while ( ponteiroEsquerda <= ponteiroDireita &&vetor[ponteiroEsquerda].getDuracao() <= pivo ){
                ponteiroEsquerda++;
            }
            while (ponteiroDireita >= ponteiroEsquerda && vetor[ponteiroDireita].getDuracao() > pivo ){
                ponteiroDireita--;
            }
            if (ponteiroEsquerda< ponteiroDireita){
                trocar(vetor,ponteiroEsquerda,ponteiroDireita);
                ponteiroEsquerda++;
                ponteiroDireita--;
            }
        }
        trocar(vetor,inicio,ponteiroDireita);
        return ponteiroDireita;
    }

    private void trocar(EscalonamentoSJF[] vetor, int ponteiroEsquerda, int ponteiroDireita) {
        EscalonamentoSJF aux = vetor[ponteiroEsquerda];
        vetor[ponteiroEsquerda] = vetor[ponteiroDireita];
        vetor[ponteiroDireita] = aux;
    }


}

package com.jesse.boeira.ds1jogodavelha.jogodavelha;

public interface InterfaceJogo {
    Jogador temVencedor  (Jogador j1, Jogador j2);
    void    novoJogo     ();
    void    atualizaTela ();
    boolean ehEmpate     ();
    boolean ehFimDoJogo  ();
}

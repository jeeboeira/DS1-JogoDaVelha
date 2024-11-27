package com.jesseboeira.Old.ds1jogodavelha.comm;

import com.jesseboeira.Old.ds1jogodavelha.core.Jogador;

//import java.rmi.Remote;
import java.rmi.RemoteException;

    public interface JogoDaVelhaRMI  {
    void fazerJogada(int posicao, String nomeJogador) throws RemoteException;
    boolean ehFimdoJogo() throws RemoteException;
    Jogador temVencedor() throws RemoteException;
    void iniciarNovoJogo() throws RemoteException;
    String obterPlacar() throws RemoteException;
}

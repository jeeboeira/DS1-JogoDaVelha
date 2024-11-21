package com.jesseboeira.ds1jogodavelha.comm;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPComm {
    private final int port;
    private String host;
    private byte[] buffer = new byte[256];

    public UDPComm(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public UDPComm(int port){
        this.port = port;
    }

    public void sendMsg(String msg){
        try {
            buffer = msg.getBytes();
            InetAddress address = InetAddress.getByName(host);
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            socket.close();
        } catch (IOException e) {
            System.err.println("Erro ao enviar mensagem: " + e.getMessage());
        }
    }


    public String receiveMsg(){
        try {
            DatagramSocket socket = new DatagramSocket(port);
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            socket.close();
            host = packet.getAddress().getHostName();
            return new String(packet.getData(), 0, packet.getLength());
        } catch (IOException e) {
            System.err.println("Erro ao receber mensagem: " + e.getMessage());
            return null;
        }
    }

    public String getHost(){
        return host;
    }
}

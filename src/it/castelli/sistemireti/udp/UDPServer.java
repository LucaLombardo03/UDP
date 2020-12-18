package it.castelli.sistemireti.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        int port = 2080;    // Integer.parseInt(args[0]);

        System.out.println("-- Running Server at " + InetAddress.getLocalHost() + "-- port:"+port);

        DatagramSocket udpSocket = new DatagramSocket(port);

        byte[] buf = new byte[256];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        // blocks until a packet is received
        udpSocket.receive(packet);
        String msg = new String(packet.getData()).trim();
        System.out.println("Message from " + packet.getAddress().getHostAddress() + ":" + packet.getPort()+" = "+msg);

        // send response
        udpSocket.send(packet);
    }
}
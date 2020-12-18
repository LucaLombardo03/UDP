package it.castelli.sistemireti.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class UDPClient {
    public static void main(String[] args) throws NumberFormatException, IOException {
        String host = "localhost";  //args[0];
        int port = 2080;    // Integer.parseInt(args[1]);
        InetAddress IPAddress = InetAddress.getByName(host);

        if (args.length >0) {
            host = args[0];
        }
        System.out.println("-- Running UDP Client at " + InetAddress.getLocalHost() + " -- calling server at "+ host+" port:"+port);

        // send packet
        DatagramSocket udpSocket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        DatagramPacket p = new DatagramPacket(in.getBytes(), in.getBytes().length, IPAddress, port);
        udpSocket.send(p);

        // receive Packet
        byte[] buf = new byte[256];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        // blocks until a packet is received
        udpSocket.receive(packet);
        String msg = new String(packet.getData()).trim();
        System.out.println("Message from " + packet.getAddress().getHostAddress() + ": " + msg);
    }

}

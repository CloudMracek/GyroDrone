package me.seager.tellocontroll;

import java.io.IOException;
import java.net.*;

public class Tello {

    public static DatagramSocket socket;
    private String output;
    private InetAddress ip;
    private int port = 8889;

    public Tello() throws IOException {
        socket = new DatagramSocket();
        ip = InetAddress.getByName("192.168.10.1");
        byte[] initData = new byte[1024];
        initData = "command".getBytes();
        DatagramPacket initPacket = new DatagramPacket(initData, initData.length, ip, port);
        socket.send(initPacket);
    }

    public void takeoff() {
        byte[] takeoffData = "takeoff".getBytes();
        DatagramPacket takeoffPacket = new DatagramPacket(takeoffData, takeoffData.length, ip, port);
        try {
            socket.send(takeoffPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void land() {
        byte[] landData = "land".getBytes();
        DatagramPacket landPacket = new DatagramPacket(landData, landData.length, ip, port);
        try {
            socket.send(landPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flip(Direction dir) {
        byte[] flipData = ("flip " + dir.getDirection()).getBytes();
        DatagramPacket flipPacket = new DatagramPacket(flipData, flipData.length, ip, port);
        try {
            socket.send(flipPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ascend(int cm) {
        byte[] ascendData = ("up " + cm).getBytes();
        DatagramPacket ascendPacket = new DatagramPacket(ascendData, ascendData.length, ip, port);
        try {
            socket.send(ascendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void descend(int cm) {
        byte[] descendData = ("down " + cm).getBytes();
        DatagramPacket descendPacket = new DatagramPacket(descendData, descendData.length, ip, port);
        try {
            socket.send(descendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flyHorizontally(Direction dir, int cm) {
        byte[] flyData;
        DatagramPacket flyPacket = null;
        switch (dir) {
            case FORWARD:
                flyData = ("forward " + cm).getBytes();
                flyPacket = new DatagramPacket(flyData, flyData.length, ip, port);
                break;
            case LEFT:
                flyData = ("left " + cm).getBytes();
                flyPacket = new DatagramPacket(flyData, flyData.length, ip, port);
                break;
            case RIGHT:
                flyData = ("right " + cm).getBytes();
                flyPacket = new DatagramPacket(flyData, flyData.length, ip, port);
                break;
            case BACK:
                flyData = ("back " + cm).getBytes();
                flyPacket = new DatagramPacket(flyData, flyData.length, ip, port);
                break;
        }
        try {
            socket.send(flyPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendControlls(int a, int b, int c, int d){
        byte[] controllData = ("rc " + a + " " + b + " " + c + " " + d).getBytes();
        DatagramPacket controllsPacket = new DatagramPacket(controllData, controllData.length, ip, port);
        try {
            socket.send(controllsPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flyTo(int x, int y, int z, int speed) {
        byte[] flyToData = ("go " + x + " " + y + " " + z + " " + speed).getBytes();
        DatagramPacket flyToPacket = new DatagramPacket(flyToData, flyToData.length, ip, port);
        try {
            socket.send(flyToPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}

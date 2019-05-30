package me.seager.tellocontroll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static Tello tello;

    private int a, b, c, d;

    static String filename = "C:\\Users\\DzendaWindows\\Documents\\SaveFile.txt";

    public static void main(String args[]) throws IOException, InterruptedException {
        tello = new Tello();
        Thread.sleep(2000);
        tello.takeoff();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(true) {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            if(line != null && line != "") {
                String[] s = line.split(",");
                System.out.println(Arrays.toString(s));
                System.out.println(s[0]);
                br.close();
                fr.close();
                if(Integer.parseInt(s[5]) == 1){
                    tello.land();
                }
                int lift = 0;
                if(Integer.parseInt(s[3]) > Integer.parseInt(s[4])){
                    lift = Integer.parseInt(s[3]);
                }

                if(Integer.parseInt(s[3]) < Integer.parseInt(s[4])){
                    lift = -Integer.parseInt(s[4]);
                }

                tello.sendControlls(-Integer.parseInt(s[0]), -Integer.parseInt(s[1]), lift, Integer.parseInt(s[2]));
            }
            Thread.sleep(50);
        }

    }
}

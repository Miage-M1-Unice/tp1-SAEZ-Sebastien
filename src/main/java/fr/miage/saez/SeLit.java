package fr.miage.saez;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class SeLit {
    void lecture(Scanner source) {

        while(source.hasNextLine()) {
            String s = source.nextLine(); //test
            if(s.trim().contains("\"//\"") || !s.trim().startsWith("//")){
                if(s.trim().contains("//") && !s.trim().contains("\"//\"")){
                    System.out.println(s.split("//")[0]);
                }else{
                    System.out.println(s);
                }

            }

        }
    }

    static public void main(String[] args) {
        // A compléter
        PrintStream ps = System.out;
        File output = new File("./output.txt");
        try {
            output.createNewFile();
            System.setOut(new PrintStream(output));
        } catch (IOException e) {
            e.printStackTrace();
        }



        SeLit seLit = new SeLit();
        try {
            Scanner sc = new Scanner(new File("./src/main/java/fr/miage/saez/SeLit.java"));
            seLit.lecture(sc);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.setOut(ps);

    }
}
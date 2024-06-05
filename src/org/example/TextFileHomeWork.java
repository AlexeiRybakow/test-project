package org.example;

import java.io.*;
import java.util.Scanner;
import static org.example.Main.returnedInWords;


public class TextFileHomeWork {
    public static void main(String[] args) throws Exception  {

        Scanner scanner = new Scanner(System.in);
        File file = new File("test.txt");
        System.out.println("Введите количество цифр которое нужно сгенерировать ");
        int numbers = scanner.nextInt();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for (int  i = 1; i <= numbers; i ++){
                writer.write("" + i);
                writer.newLine();
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            for(int i = 1; i <=numbers; i++){
            String line = reader.readLine();
            int number = Integer.parseInt(line);
            System.out.print(returnedInWords(number));
            }
        }


    }
}

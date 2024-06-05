package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class TextFileBinarCode {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите положительное количество цифр ");
        short number = scanner.nextShort();

        try(BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("test.bin"))){
            ByteBuffer buffer = ByteBuffer.allocate(2 * number);
            for (short i = 1; i <= number ; i++ ){
            buffer.putShort(i);
            }
            byte[] data = buffer.array();
            stream.write(data);
        }

        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream("test.bin"))) {
            byte[] data = new byte[2];
            int actualByte = stream.read(data);

            while (stream.read(data) != - 1){
                short x = ByteBuffer.wrap(data).getShort();
                System.out.println(x * 3);
            }


        }
    }

}


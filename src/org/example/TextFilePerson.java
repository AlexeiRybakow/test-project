package org.example;

import org.example.Person.MyPerson;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFilePerson {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<MyPerson> listOfPeopleOut = new ArrayList<>();
        ArrayList<MyPerson> listOfPeopleIN = new ArrayList<>();

        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("testfile.bin"))){

        System.out.println("Please enter LastName: ");
        String lastName = scanner.nextLine();

        while (!lastName.equals("exit")){

            System.out.println("Please enter Age: ");
            short age = scanner.nextShort();
            scanner.nextLine();

            MyPerson person = new MyPerson(lastName, age);
            listOfPeopleOut.add(person);

            byte[] name = person.name.getBytes();

            ByteBuffer buffer = ByteBuffer.allocate(1+ name.length + 2);

            buffer.put((byte) name.length );
            buffer.put(name);
            buffer.putShort(person.age);

            byte[] data = buffer.array();

            stream.write(data);

            System.out.println("Please enter LastName if you need stop enter exit ");
            lastName = scanner.nextLine();
        }
    }
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream("testfile.bin"))){
            byte[] data = new byte[1];

            while(stream.read(data) != -1){

                ByteBuffer buffer2 = ByteBuffer.wrap(data);
                

                int nameLength = buffer2.get();
                byte[] name2 = new byte[nameLength];
                stream.read(name2);
                //buffer2 = ByteBuffer.wrap(name2);
                //buffer2.get(name2);
                String nameString = new String(name2);

                byte[] ages = new byte[2];
                stream.read(ages);
                buffer2 = ByteBuffer.wrap(ages);
                short age = buffer2.getShort();

                MyPerson test2 = new MyPerson(nameString, age);

                listOfPeopleIN.add(test2);
                //data = new byte[1] ;
            }
        }
        System.out.println(listOfPeopleIN);

        System.out.println("Введите фамилию для поиска: ");
        String searchName = scanner.nextLine();

        boolean check = false;
        int value = 0;
        for (int i = 0; i < listOfPeopleIN.size(); i++) {
            if (listOfPeopleIN.get(i).name.equals(searchName)) {
                check = true;
                value = listOfPeopleIN.get(i).age;
                break;
            }
        }
        if (check){
            System.out.println("'" + value + "'");
        } else {
            System.out.println("Человека с такой фамилией нет");
        }

    }

}


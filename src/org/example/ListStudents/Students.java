package org.example.ListStudents;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Person.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Students {

    private static final Scanner scanner = new Scanner(System.in);
    private static  final ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("data.json");



        boolean isRunning = true;
        while (isRunning){


            mainMenu();

            System.out.println("Выберите пункт меню ");

            int menuItem = 0;
            if (scanner.hasNextInt()){
                 menuItem = scanner.nextInt();
            }
            scanner.nextLine();

            if (menuItem == 1){
                showStudentList();

            } else if (menuItem == 2) {

                addaStudent();
                objectMapper.writeValue(file,students);

            } else if (menuItem == 3 ) {
                editStudent();


            } else if (menuItem == 4) {

            } else if (menuItem == 5) {

            } else if (menuItem == 6) {

            } else if (menuItem == 7) {
                isRunning = false;
            } else {
                System.out.println("Вы ввели недопустимый символ");
            }


        }
    }

    public static void addaStudent (){

        System.out.println("Введите Фамилию студента");
        String surname = scanner.nextLine();
        System.out.println("Введите Имя студента");
        String name = scanner.nextLine();
        System.out.println("Введите Отчество студента");
        String middleName = scanner.nextLine();
        System.out.println("Введите Группу студента");
        String group = scanner.nextLine();

        Student student = new Student(surname,name,middleName,group);
        students.add(student);
    }

    public static void mainMenu(){
        System.out.println("1. Список студентов\n" +
                "2. Добавить студента\n" +
                "3. Редактировать студента\n" +
                "4. Удалить студента\n" +
                "5. Показать отличников\n" +
                "6. Показать неуспевающих\n" +
                "7. Выход");
    }
    public static void subMenu(){
        System.out.println("1. Изменить фамилию\n" +
                "2. Изменить имя\n" +
                "3. Изменить отчество\n" +
                "4. Изменить группу\n" +
                "5. Добавить оценку\n" +
                "6. Изменить оценку\n" +
                "7. Удалить оценку");

    }
    private static void editStudent() {
        if (!students.isEmpty()) {

            showShortStudentsList();
            System.out.println("Введите номер студента ");
            int studentNumber = scanner.nextInt();
            while (studentNumber < 1 || studentNumber > students.size()) {
                studentNumber = scanner.nextInt();
                System.out.println("Некоректное число");
            }
            boolean isSubMenu = true;
            while (isSubMenu) {

                 printStudent(studentNumber);
                 subMenu();

                 int menuNumber = scanner.nextInt();

                 if(menuNumber == 1){
                     System.out.println("Изменить фамилию");
                 }
                 else if (menuNumber == 8){
                     isSubMenu = false;
                 } else {
                     System.out.println("Неверный пункт меню ");
                 }
            }

        }

        }



    private static void showShortStudentsList(){
        for (int i = 0; i < students.size() ; i++){
            int count = i+1;
            System.out.print(""+ count +". ");
            System.out.print(students.get(i).Surname +" ");
            System.out.print(students.get(i).Name+" ");
            System.out.print(students.get(i).MiddleName+" ");
            System.out.print("(" + students.get(i).group + ")");
            System.out.println();

        }
    }
    private static void showStudentList(){
        for (int i = 1; i <= students.size() ; i ++){
            printStudent(i);
        }
        if(students.isEmpty()){
            System.out.println("Список студентов пуст. Сначала добавьте студента.\n");
        }
    }
    private static void printStudent(int studentNumber) {

            System.out.println("    ===" + (studentNumber) + "===");
            System.out.println("Фамилия : " + students.get(studentNumber-1).Surname);
            System.out.println("Имя : " + students.get(studentNumber-1).Name);
            System.out.println("Отчества : " + students.get(studentNumber-1).Surname);
            System.out.println("Группа : " + students.get(studentNumber-1).group);
            System.out.println("Оценки : " + "\n" + students.get(studentNumber-1).AcademicPerformance.keySet()
                    + "\n" +students.get(studentNumber-1).AcademicPerformance.values() + "\n");
    }


}


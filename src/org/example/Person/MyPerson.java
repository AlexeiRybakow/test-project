package org.example.Person;

public class MyPerson {

        public String name;
        public short age;

        public  MyPerson(String name, short age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
}


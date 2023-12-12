package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Person person = new Person();
        Realization realization = new Realization();

        realization.run(person, new Scanner(System.in) );

    }
}

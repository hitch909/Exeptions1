package org.example;

import lombok.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString @Setter
public class Person extends Realization {

    private Integer id;
    private String surname;
    private String name;
    private String patronymic;
    private String dateOfBirth;
    private String phoneNumber;
    private String gender;

    public void showPersonDate() throws IOException {
        Scanner scanner1 = new Scanner(System.in);
        int lineNumber = scanner1.nextInt();
        String line32 = Files.readAllLines(Paths.get("file.txt")).get(lineNumber);
        System.out.println(line32);
    }

    public void showListPerson() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writerPerson(Person person) throws IOException {
        try (FileWriter fw = new FileWriter("file.txt", true)) {
            fw.write(" \n" + person.toString());
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

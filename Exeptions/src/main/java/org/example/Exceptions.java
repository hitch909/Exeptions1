package org.example;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

@NoArgsConstructor
@ToString
public class Exceptions {
    public void exceptEnterData(Person person) {
        if (person.getId() == null || person.getSurname().isEmpty() || person.getName().isEmpty() || person.getPatronymic().isEmpty()
                || person.getDateOfBirth().isEmpty() || person.getPhoneNumber().isEmpty() || person.getGender().isEmpty()) {
            throw new RuntimeException("введены не все данные");
        }
    }

    public String checkingFormatData() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if (!NumberUtils.isParsable(string)) {
            return string;
        } else {
            throw new RuntimeException(" ввод не правильного формата");
        }
    }

    public String checkingBirthday(Scanner scanner) {
        String string = scanner.nextLine();
        if (string.length() != 10) {
            throw new RuntimeException("не верное количество знаков");
        } else {
            return string;
        }
    }

    public String checkingNumber(Scanner scanner) {
        String string = scanner.nextLine();
        if (NumberUtils.isParsable(string)) {
            return string;
        } else {
            throw new RuntimeException("введено не число");
        }
    }

    public String checkingGender(Scanner scanner) {
        String string = scanner.nextLine();
        if (string.contains("m")) {
            return string;
        }
        if (string.contains("f")) {
            return string;
        } else {
            throw new RuntimeException("введите ' f ' или ' m ' .");
        }
    }

    public Integer checkingId() {
        Scanner scanner = new Scanner(System.in);
        Integer i = scanner.nextInt();
        if (i.equals(" ")) {
            throw new RuntimeException("введите число");
        } else {
            return i;
        }
    }

}







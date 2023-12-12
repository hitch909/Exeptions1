package org.example;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;
import java.util.Scanner;

/*Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
 разделенные пробелом:

Фамилия Имя Отчество датарождения номертелефона пол
Форматы данных:
фамилия, имя, отчество - строки
    датарождения - строка формата dd.mm.yyyy
    номертелефона - целое беззнаковое число без форматирования
    пол - символ латиницей f или m.
Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
    вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если
    форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать
    встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение
     с информацией, что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны
    записаться полученные данные, вида
    <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
пользователь должен увидеть стектрейс ошибки.
 */
@NoArgsConstructor
@ToString
public class Realization extends Exception {

    Exceptions exceptions = new Exceptions();
    Scanner scanner = new Scanner(System.in);

    public void run(Person person, Scanner scanner) throws IOException {

        System.out.println(" 1 -- внести данные на нового сотрудника");
        System.out.println(" 2 -- хотите просмотреть данные на старого сотрудника");
        System.out.println(" 3 -- хотите посмтреть список всех сотрудников");
        System.out.println();
        System.out.print("введите номер необходимой операции:  ");
        int number = scanner.nextInt();
        switch (number) {
            case 1:
                enterData(person);
                break;
            case 2:
                System.out.println("введите id сотрудника:  ");
                person.showPersonDate();
                break;
            case 3:
                person.showListPerson();
                break;
        }
    }

    public Person enterData(Person person) throws IOException {

        System.out.print("введите id сотрудника:  ");
        person.setId(exceptions.checkingId());

        System.out.print("введите фамилию:  ");
        person.setSurname(exceptions.checkingFormatData());

        System.out.print("введите имя:  ");
        person.setName(exceptions.checkingFormatData());

        System.out.println("введите отчество:  ");
        person.setPatronymic(exceptions.checkingFormatData());

        System.out.println("дату рождения в форате: dd.mm.yyyy :   ");
        person.setDateOfBirth(exceptions.checkingBirthday(scanner));

        System.out.println("введите  номертелефона - целое беззнаковое число без форматирования:    ");
        person.setPhoneNumber(exceptions.checkingNumber(scanner));

        System.out.println("введите пол - символ латиницей f или m :  ");
        person.setGender(exceptions.checkingGender(scanner));

        System.out.println(person);
        exceptions.exceptEnterData(person);
        person.writerPerson(person);

        return new Person();
    }

    public void show(Person person) {
        System.out.println(person);
    }
}



















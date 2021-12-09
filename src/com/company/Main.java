package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static Quadrates quadrates = new Quadrates();

    public static int CheckCorrectFunction(String value) {
        int func = -1;
        try {
            func = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            func = -1;
        }
        return func;
    }

    public static void main(String[] args) throws IOException {
        int function ;
        Scanner scan = new Scanner(System.in);


        quadrates.add(new Quadrate(1,2,3,4,5,6,4,4));
        quadrates.add(new Quadrate(3,3,2,4,2,6,9,1));
        quadrates.add(new Quadrate(4,5,6,7,8,9,4,2));

        do {
            System.out.println("\nСписок функций: ");
            System.out.println("[1] Вывод массива на экран");
            System.out.println("[2] Сохранение в файл");
            System.out.println("[3] Сериализация базы данных");
            System.out.println("[4] Десериализация базы данных");
            System.out.println("[5] Сериализация Jackson базы данных");
            System.out.println("[6] Десериализация Jackson базы данных");
            System.out.println("[7] Очистка базы данных");
            System.out.println("[8] Ввод данных");
            System.out.println("[9] Выход из программы");
            do {
                System.out.print("Введите номер функции: ");
                function = CheckCorrectFunction(scan.nextLine());
            } while (function == -1);

            switch (function) {
                case 1:
                    System.out.println(quadrates);
                    break;
                case 2:
                    System.out.println("Введите путь к файлу:");
                    String saveFileName = scan.nextLine();
                    quadrates.saveFile(saveFileName);
                    break;
                case 3:
                    System.out.print("\nВведите путь для сохранения файла:");
                    String serializeFileName = scan.nextLine();
                    quadrates.serializeFile(serializeFileName);
                    break;
                case 4:
                    System.out.print("\nВведите путь к базе данных:");
                    String deserializeFileName = scan.nextLine();
                    quadrates.deserializeFile(deserializeFileName);
                    break;
                case 5:
                    System.out.print("\nВведите путь для сохранения файла:");
                    String jacksonSerializeFileName = scan.nextLine();
                    quadrates.JacksonSerializeFile(jacksonSerializeFileName);
                    break;
                case 6:
                    System.out.print("\nВведите путь к базе данных:");
                    String jacksonDeserializeFileName = scan.nextLine();
                    quadrates.jacksonDeserializeFile(jacksonDeserializeFileName);
                    break;
                case 7:
                    quadrates.quadrates.clear();
                    break;
                case 8:
                    Quadrates quadratesInput = new Quadrates();
                    quadratesInput.dataInput();
                    System.out.println(quadrates);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("\nТакой функции нету");
            }
        } while (function != 0);
    }
}

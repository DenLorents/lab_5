package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Quadrates implements Serializable{
    int inCountQuadrate = 2;
    int numberQuadrate = 0;
    @JsonProperty("quadrates")
    ArrayList<Quadrate> quadrates;
    @JsonProperty("description")
    String description;
    static final long serialVersionUID = 656565665L;

    public Quadrates() {
        description = LocalDate.now().toString();
        this.quadrates = new ArrayList<Quadrate>();
    }

    public Quadrates(Quadrates quadrates) {
        this.quadrates = quadrates.quadrates;
        this.description = quadrates.description;
    }

    void add(Quadrate quadrate) {
        quadrates.add(quadrate);
    }

    @Override
    public String toString() {
        return "Quadrates{" +
                "inCountQuadrate=" + inCountQuadrate +
                ", numberQuadrate=" + numberQuadrate +
                ", quadrates=" + quadrates +
                ", description='" + description + '\'' +
                '}';
    }

    void serializeFile(String fileName) {
        FileWork.serialize(this, fileName);
    }

    void deserializeFile(String fileName) {
        Quadrates er = new Quadrates(FileWork.deserialize(fileName));
        this.quadrates = er.quadrates;
        this.description = er.description;
    }

    void JacksonSerializeFile(String fileName) throws IOException {
        FileWork.jacksonSerialize(this, fileName);
        quadrates.clear();
    }

    void jacksonDeserializeFile(String fileName) throws IOException {
        this.quadrates = FileWork.jacksonDeSerialize(fileName);
    }

    void saveFile(String fileName) throws IOException {
        FileWork.save(quadrates, fileName);
    }

    public void dataInput() throws IOException {

        Quadrate[] quadrates = new Quadrate[inCountQuadrate];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < quadrates.length; i++) {
            quadrates[i] = new Quadrate();

            System.out.print("Введите x1 для четырёхугольника №" + (i + 1) + ": ");
            quadrates[i].setX1(scan.nextInt());
            System.out.print("Введите y1 для четырёхугольника №" + (i + 1) + ": ");
            quadrates[i].setY1(scan.nextInt());

            System.out.print("Введите x2 для четырёхугольника №" + (i + 1) + ": ");
            quadrates[i].setX2(scan.nextInt());
            System.out.print("Введите y2 для четырёхугольника №" + (i + 1) + ": ");
            quadrates[i].setY2(scan.nextInt());

            System.out.print("Введите x3 для четырёхугольника №" + (i + 1) + ": ");
            quadrates[i].setX3(scan.nextInt());
            System.out.print("Введите y3 для четырёхугольника №" + (i + 1) + ": ");
            quadrates[i].setY3(scan.nextInt());

            System.out.print("Введите x4 для четырёхугольника №" + (i + 1) + ": ");
            quadrates[i].setX4(scan.nextInt());
            System.out.print("Введите y4 для четырёхугольника №" + (i + 1) + ": ");
            quadrates[i].setY4(scan.nextInt());
        }
        for (int i = 0; i < quadrates.length; i++) {
            // d = √((x2-x1)²+(y2-y1)²),
            quadrates[i].side1 = Math.sqrt((Math.pow(quadrates[i].x2 - quadrates[i].x1, 2)) + Math.pow(quadrates[i].y2 - quadrates[i].y1, 2));
            quadrates[i].side2 = Math.sqrt((Math.pow(quadrates[i].x3 - quadrates[i].x2, 2)) + Math.pow(quadrates[i].y3 - quadrates[i].y2, 2));
            quadrates[i].side3 = Math.sqrt((Math.pow(quadrates[i].x4 - quadrates[i].x3, 2)) + Math.pow(quadrates[i].y4 - quadrates[i].y3, 2));
            quadrates[i].side4 = Math.sqrt((Math.pow(quadrates[i].x4 - quadrates[i].x1, 2)) + Math.pow(quadrates[i].y4 - quadrates[i].y1, 2));

            quadrates[i].diagonal1 = Math.sqrt((Math.pow(quadrates[i].x3 - quadrates[i].x1, 2)) + Math.pow(quadrates[i].y3 - quadrates[i].y1, 2));
            quadrates[i].diagonal2 = Math.sqrt((Math.pow(quadrates[i].x2 - quadrates[i].x4, 2)) + Math.pow(quadrates[i].y2 - quadrates[i].y4, 2));

            quadrates[i].perimeter = quadrates[i].side1 + quadrates[i].side2 + quadrates[i].side3 + quadrates[i].side4;

            System.out.println("Сторона (1) четырёхугольника №" + quadrates[i].numberQuadrate + ": " + quadrates[i].side1);
            System.out.println("Сторона (2) четырёхугольника №" + quadrates[i].numberQuadrate + ": " + quadrates[i].side2);
            System.out.println("Сторона (3) четырёхугольника №" + quadrates[i].numberQuadrate + ": " + quadrates[i].side3);
            System.out.println("Сторона (4) четырёхугольника №" + quadrates[i].numberQuadrate + ": " + quadrates[i].side4);

            System.out.println("Диагональ (1) четырёхугольника №" + quadrates[i].numberQuadrate + ": " + quadrates[i].diagonal1);
            System.out.println("Диагональ (1) четырёхугольника №" + quadrates[i].numberQuadrate + ": " + quadrates[i].diagonal2);

            System.out.println("Периметр четырёхугольника №" + quadrates[i].numberQuadrate + ": " + quadrates[i].perimeter);

            if (quadrates[i].side1 == quadrates[i].side2 || quadrates[i].side1 == quadrates[i].side4 && quadrates[i].side3 == quadrates[i].side2 || quadrates[i].side3 == quadrates[i].side4 && quadrates[i].diagonal1 != quadrates[i].diagonal2) {
                quadrates[i].rhombus = true;
            }
        }
        System.out.println("Выполнить сохранение данных в файл? (Введите 1 - Да)");
        int saveData = scan.nextInt();
        if (saveData == 1) {
            ArrayList<Quadrate> quadrateArrayList = new ArrayList<>(Arrays.asList(quadrates));
            FileWork.save(quadrateArrayList, "d:\\1.txt");
            System.out.println("Файл сохранён");


        }
    }
}


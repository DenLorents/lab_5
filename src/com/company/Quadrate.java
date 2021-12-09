package com.company;
import java.io.Serializable;
import java.util.Scanner;

public class Quadrate implements Serializable {
    static final long serialVersionUID = 454564564564564L;
    public long numberQuadrate;
    int x1, x2, x3, x4;
    int y1, y2, y3, y4;
    double side1, side2, side3, side4;
    double diagonal1, diagonal2;
    double perimeter;
    boolean rhombus;

    Scanner scan = new Scanner(System.in);

    public Quadrate(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4) {
    }

    public Quadrate() {

    }

    public long getNumberQuadrate() {
        return numberQuadrate;
    }

    public void setNumberQuadrate(long numberQuadrate) {
        this.numberQuadrate = numberQuadrate;
    }

  public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getX4() {
        return x4;
    }

    public void setX4(int x4) {
        this.x4 = x4;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public int getY4() {
        return y4;
    }

    public void setY4(int y4) {
        this.y4 = y4;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getSide4() {
        return side4;
    }

    public void setSide4(double side4) {
        this.side4 = side4;
    }

    public double getDiagonal1() {
        return diagonal1;
    }

    public void setDiagonal1(double diagonal1) {
        this.diagonal1 = diagonal1;
    }

    public double getDiagonal2() {
        return diagonal2;
    }

    public void setDiagonal2(double diagonal2) {
        this.diagonal2 = diagonal2;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public boolean isRhombus() {
        return rhombus;
    }

    public void setRhombus(boolean rhombus) {
        this.rhombus = rhombus;
    }

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    @Override
    public String toString() {
        return "Quadrate{" +
                "numberQuadrate=" + numberQuadrate +
                ", x1=" + x1 +
                ", x2=" + x2 +
                ", x3=" + x3 +
                ", x4=" + x4 +
                ", y1=" + y1 +
                ", y2=" + y2 +
                ", y3=" + y3 +
                ", y4=" + y4 +
                ", side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", side4=" + side4 +
                ", diagonal1=" + diagonal1 +
                ", diagonal2=" + diagonal2 +
                ", perimeter=" + perimeter +
                ", rhombus=" + rhombus +
                ", scan=" + scan +
                '}';
    }
}


    /* 1
    public void setX1(int x1) {
        this.x1 = x1;
    }
    public int getX1() {
        return (int) x1;
    }
    public void setY1(int y1) {
        this.y1 = y1;
    }
    public int getY1() {
        return (int) y1;
    }

    // 2
    public void setX2(int x2) {
        this.x2 = x2;
    }
    public int getX2() {
        return (int) x2;
    }
    public void setY2(int y2) {
        this.y2 = y2;
    }
    public int getY2() {
        return (int) y2;
    }

    // 3
    public void setX3(int x3) {
        this.x3 = x3;
    }
    public int getX3() {
        return (int) x3;
    }
    public void setY3(int y3) {
        this.y3 = y3;
    }
    public int getY3() {
        return (int) y3;
    }

    // 4
    public void setX4(int x4) {
        this.x4 = x4;
    }
    public int getX4() {
        return (int) x4;
    }
    public void setY4(int y4) {
        this.y4 = y4;
    }
    public int getY4() {
        return (int) y4;
    }

    @Override
    public String toString() {
        return "Quadrate{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", x3=" + x3 +
                ", x4=" + x4 +
                ", y1=" + y1 +
                ", y2=" + y2 +
                ", y3=" + y3 +
                ", y4=" + y4 +
                ", side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", side4=" + side4 +
                ", diagonal1=" + diagonal1 +
                ", diagonal2=" + diagonal2 +
                ", perimeter=" + perimeter +
                ", rhombus=" + rhombus +
                ", scan=" + scan +
                '}';
    }
}

  */
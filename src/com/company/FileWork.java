package com.company;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    public static void serialize(Quadrates quadrates, String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream outOOS = new ObjectOutputStream(fileOut);
            outOOS.writeObject(quadrates);
            outOOS.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Quadrates deserialize(String fileName) {
        Quadrates quadrates = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream inOIS = new ObjectInputStream(fileIn);
            quadrates = (Quadrates) inOIS.readObject();
            inOIS.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Не найден");
            c.printStackTrace();
        }
        return quadrates;
    }
    public static void jacksonSerialize(Quadrates quadrates, String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.writeValue(new File(fileName), quadrates);
    }
    public static ArrayList<Quadrate> jacksonDeSerialize(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Quadrates newQuadrates = objectMapper.readValue(new File(fileName), Quadrates.class);
        return newQuadrates.quadrates;
    }
    public static void save(ArrayList<Quadrate> quadrates, String fileWay) throws IOException {
        byte[] bytesToWrite;
        byte[] x1, x2, x3, x4, y1, y2, y3, y4, razdel;
        String razdelitel = "&";

        for (Quadrate object : quadrates) {
            String s1 = Double.toHexString(object.getX1());
            x1 = s1.getBytes(StandardCharsets.UTF_8);

            String s2 = Double.toHexString(object.getX2());
            x2 = s2.getBytes(StandardCharsets.UTF_8);

            String s3 = Double.toHexString(object.getX3());
            x3 = s3.getBytes(StandardCharsets.UTF_8);

            String s4 = Double.toHexString(object.getX4());
            x4 = s4.getBytes(StandardCharsets.UTF_8);

            String s5 = Double.toHexString(object.getY1());
            y1 = s5.getBytes(StandardCharsets.UTF_8);

            String s6 = Double.toHexString(object.getY2());
            y2 = s6.getBytes(StandardCharsets.UTF_8);

            String s7 = Double.toHexString(object.getY3());
            y3 = s7.getBytes(StandardCharsets.UTF_8);

            String s8 = Double.toHexString(object.getY4());
            y4 = s8.getBytes(StandardCharsets.UTF_8);

            razdel = razdelitel.getBytes(StandardCharsets.UTF_8);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            outputStream.write(x1);
            outputStream.write(razdel);
            outputStream.write(x2);
            outputStream.write(razdel);
            outputStream.write(x3);
            outputStream.write(razdel);
            outputStream.write(x4);
            outputStream.write(razdel);
            outputStream.write(y1);
            outputStream.write(razdel);
            outputStream.write(y2);
            outputStream.write(razdel);
            outputStream.write(y3);
            outputStream.write(razdel);
            outputStream.write(y4);

            bytesToWrite = outputStream.toByteArray();
            FileOutputStream outFile = null;
            boolean isOpened = false;
            try {
                outFile = new FileOutputStream(fileWay, true);
                isOpened = true;
                outFile.write(bytesToWrite);
            } catch (FileNotFoundException e) {
                System.out.println("Невозможно произвести запись в файл:" + fileWay);
            } catch (IOException e) {
                System.out.println("Ошибка ввода/вывода:" + e);
            }
            if (isOpened) {
                outFile.close();
            }
        }
    }
    public static void load(ArrayList<Quadrate> quadrates, String fileWay) {
        quadrates.clear();
        byte[] readData = new byte[0];
        int number = 0;
        try {
            FileInputStream inFile = new FileInputStream(fileWay);
            int bytesAvailable = inFile.available();
            System.out.println("Available: " + bytesAvailable);
            byte[] bytesRead = new byte[bytesAvailable];
            int count = inFile.read(bytesRead, 0, bytesAvailable);

            System.out.println("Было считано байт: " + count);
            System.out.println(Arrays.toString(bytesRead));
            readData = bytesRead;
            number = count;
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно произвести чтение из файла:" + fileWay);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода:" + e);
        }

        byte[] data = readData;
        int x1 = 0;
        int x2 = 0;
        int x3 = 0;
        int x4 = 0;
        int y1 = 0;
        int y2 = 0;
        int y3 = 0;
        int y4 = 0;
        int q = 0;

        for (int i = 0; i < number; i++) {

            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
            }

            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                x1 = Integer.parseInt(String.valueOf(x1), 2);
            }
            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                x2 = Integer.parseInt(String.valueOf(x2), 2);
            }
            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                x3 = Integer.parseInt(String.valueOf(x3), 2);
            }
            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                x4 = Integer.parseInt(String.valueOf(x4), 2);
            }

            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                y1 = Integer.parseInt(String.valueOf(y1), 2);
            }
            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                y2 = Integer.parseInt(String.valueOf(y2), 2);
            }
            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                y3 = Integer.parseInt(String.valueOf(y3), 2);
            }
            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                y4 = Integer.parseInt(String.valueOf(y4), 2);
            }
            if (i == number - 1) {
                break;
            }
        }
    }
}

package ru.geekbrains.home_study;

import java.util.Random;
import java.util.Scanner;

public class Lesson_3 {
    public static void getNumder() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int dop;
        do {
            int y = 0;
            int x = rand.nextInt(9);
            System.out.println("Нужно отгадать число от 0 до 9.У Вас есть три попытки");
            for (int i = 0; i < 3; i++) {
                System.out.println("Введите число от 0 до 9");
                int x1 = sc.nextInt();
                if (x1 < x) System.out.println("Число,которое Вы ввели - меньше");
                else if (x1 > x) System.out.println("Число,которое Вы ввели - больше");
                else {
                    System.out.println("Вы выиграли");
                 break;}
                y++;
                if (y == 3) System.out.println("Попытки закончились.Вы проиграли!");
            }
            System.out.println("Повторить игру ещё раз? 1 - да / 0 - нет");
            dop = sc.nextInt();
        } while (dop == 1) ;
        System.out.println("Игра окончена.");

    }

    public static void main(String[] args) {

        getNumder();
    }
}
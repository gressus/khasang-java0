package ru.mashkovpro.homework4;

public class MultiplicationTable {

    public static void main(String[] args) {
        System.out.println("******* Вариант1 ***********");
        printTable1();

        System.out.println("******* Вариант2 ***********");
        printTable2(2, 5);
        printTable2(6, 9);
    }

    private static void printTable1() {
        int from;
        int to;
        for (int r = 1; r <= 2; r++) {
            from = r == 1 ? 2 : 6;
            to = r == 1 ? 5 : 9;
            for (int i = 1; i <= 10; i++) {
                for (int j = from; j <= to; j++) {
                    System.out.printf("%d*%d=%d\t\t", j, i, i * j);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static void printTable2(int from, int to) {
        for (int i = 1; i <= 10; i++) {
            for (int j = from; j <= to; j++) {
                System.out.printf("%d*%d=%d\t\t", j, i, i * j);
            }
            System.out.println();
        }
        System.out.println();
    }
}

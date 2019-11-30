package ru.mashkovpro.homework4;

public class TicTacToe {
    // свободное поле
    private static final char EMPTY_DOT = '.';
    // игрок №1
    private static char gamer1;
    // игрок №2
    private static char gamer2;
    // текущий игрок
    private static char currentGamer;
    // игровое поле
    private static char[][] playingField;
    // размер игрового поля
    private static int sizeFields;
    // максимальное кол-во ходов
    private static int maxCountMoves;
    // кол-во совершенных ходов.
    private static int completedCountMoves;

    public static void main(String[] args) {
        sizeFields = 3;
        createPlayers();
        fillingField();
        runGame();
    }

    /**
     * Создание игроков.
     */
    private static void createPlayers() {
        gamer1 = 'X';
        gamer2 = 'O';
        // игру начинаем с первого игрока.
        currentGamer = gamer1;
    }

    /**
     * Создание игорового поля.
     */
    private static void fillingField() {
        playingField = new char[sizeFields][sizeFields];
        for (int x = 0; x < playingField.length; x++) {
            for (int y = 0; y < playingField[x].length; y++) {
                playingField[x][y] = EMPTY_DOT;
            }
        }
        maxCountMoves = sizeFields * sizeFields;
    }


    /**
     * Отрисовка игрового поля.
     */
    private static void printPlayingField() {
        for (int x = 0; x < playingField.length; x++) {
            for (int y = 0; y < playingField[x].length; y++) {
                System.out.print(playingField[x][y]);
            }
            System.out.println();
        }
    }

    /**
     * Запуск игры.
     */
    private static void runGame() {
        int x, y;

        do {
            do {
                x = (int) (Math.random() * sizeFields);
                y = (int) (Math.random() * sizeFields);
            } while (!checkEmptyField(x, y));

            makeMove(x, y);
        } while (completedCountMoves < maxCountMoves);
    }

    /**
     * Сделать ход.
     */
    private static void makeMove(int x, int y) {
        playingField[x][y] = currentGamer;
        System.out.println("Игрок " + currentGamer + " сделал ход:");
        // увеличиваем кол-во выполненных ходов
        completedCountMoves++;
        // отрисовка поля
        printPlayingField();
        // проверка на победу
        if (checkVictory()) {
            System.out.println("Игрок " + currentGamer + " выиграл.");
            // для выхода из игры
            completedCountMoves = maxCountMoves;
            return;
        }
        if (completedCountMoves == maxCountMoves) {
            System.out.println("*** Ничья ***");
        }
        // передаем ход другому игроку
        currentGamer = currentGamer == gamer1 ? gamer2 : gamer1;
        System.out.println();
    }

    /**
     * Проверка на победу.
     */
    private static boolean checkVictory() {

        boolean diagonalRight, diagonalLeft, cols, rows;

        // проверка диагоналей
        diagonalRight = true;
        diagonalLeft = true;
        for (int i = 0; i < sizeFields; i++) {
            diagonalRight &= (playingField[i][i] == currentGamer);
            diagonalLeft &= (playingField[sizeFields - i - 1][i] == currentGamer);
        }
        if (diagonalRight || diagonalLeft) return true;

        // проверка горизонтальных и вертикальных линий
        for (int col = 0; col < sizeFields; col++) {
            cols = true;
            rows = true;
            for (int row = 0; row < sizeFields; row++) {
                cols &= (playingField[col][row] == currentGamer);
                rows &= (playingField[row][col] == currentGamer);
            }
            if (cols || rows) return true;
        }

        return false;
    }

    /**
     * Поверка свободного поля.
     */
    private static boolean checkEmptyField(int x, int y) {
        boolean returnResult = true;
        if (x < 0 || y < 0 || x > sizeFields - 1 || y > sizeFields - 1) {
            returnResult = false;
        }
        if (playingField[x][y] != EMPTY_DOT) {
            returnResult = false;
        }
        return returnResult;
    }

}

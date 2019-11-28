package ru.mashkovpro.homework4;

public class CalcMBI {

    public static void main(String[] args) {
        int height = 170;
        int weight = 75;
        double bmi;
        bmi = calcBMI(height, weight);
        System.out.printf("Индекс массы тела = %.2f", bmi);
    }

    /**
     * Расчет индекса массы тела.
     *
     * @param height - Рост в сантиметрах.
     * @param weight - Вес в киллограммах.
     * @return индекс массы тела.
     */
    private static double calcBMI(int height, int weight) {
        return weight / Math.pow(height / 100.0, 2);
    }
}

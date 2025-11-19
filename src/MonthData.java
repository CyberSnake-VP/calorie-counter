public class MonthData {
    // индекс массива: день, а значение: кол-во шагов
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.printf("%d день: %d \n", i + 1, days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sum = 0;
        for(int steps : days) {
            sum += steps;
        }
        return sum;
    }

    int maxSteps() {
        int max = 0;
        for(int steps : days) {
            if(steps > max) {
                max = steps;
            }
        }
        return max;
    }

    int bestSeries(int goalByStepsPerDay) {
        int series = 0;
        int finalSeries = 0;

        for(int steps : days) {
            /*Увеличиваем серию при условии достижения цели.
            * Как только серия заканчивается сбрасываем ее,
            *  а кол-во проходов записано в finalSeries */
            if(steps >= goalByStepsPerDay) {
               ++series;
               if(series > finalSeries) {
                   finalSeries = series;
               }
            } else {
                series = 0;
            }
        }
        return finalSeries;
    }


}

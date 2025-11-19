public class Converter {
    int convertToKm(int steps) {
       int oneStepPerSm = 75;
       int oneKmPerSm = 100000;
       return steps * oneStepPerSm / oneKmPerSm;
    }

    int convertStepsToKilocalories(int steps) {
         int oneStepOfCalories = 50;
         int caloriesInOneKilocalories = 1000;
         return steps * oneStepOfCalories / caloriesInOneKilocalories;
    }
}

import java.util.Scanner;

public class StepTracker {
    // массив объектов месяц. Количество - 12.
    //Индекс массива номер месяца, значение - объект месяц.
    MonthData[] monthToData = new MonthData[12];
    final Scanner scanner;
    // по-умолчанию количество шагов в день
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();


    StepTracker(Scanner scanner) {
        this.scanner = scanner;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца:");
        System.out.println("1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5 - Май, 6 - Июнь, " +
                "7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь");
        System.out.print("--> ");
        int monthNumber = scanner.nextInt();
        if (monthNumber >= 1 && monthNumber <= 12) {
            System.out.println("Введите день от 1 до 30 (включительно)");
            System.out.print("--> ");
            int dayNumber = scanner.nextInt();
            if (dayNumber >= 1 && dayNumber <= 30) {
                System.out.println("Введите количество шагов");
                System.out.print("--> ");
                int stepsPerDay = scanner.nextInt();
                if (stepsPerDay < 0) {
                    System.out.println("Количество шагов не может быть отрицательным числом ¯\\__(ツ)__/¯");
                    System.out.println("Вы ввели: " + stepsPerDay);
                    return;
                }

                MonthData monthData = monthToData[monthNumber - 1];
                monthData.days[dayNumber - 1] = stepsPerDay;

            } else {
                System.out.println("День с таким номером отсутствует ¯\\__(ツ)__/¯");
                System.out.println("Номер вводимого дня должен быть от 1 до 30 включительно, а вы ввели: " + dayNumber);

            }
        } else {
            System.out.println("Месяца с таким номером не существует ¯\\__(ツ)__/¯");
            System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно, а вы ввели: " + monthNumber);
        }
    }

    void changeStepGoal() {
        System.out.println("Ваша текущая цель: " + goalByStepsPerDay);
        System.out.print("Новая цель: --> ");
        int newGoal = scanner.nextInt();
        if (newGoal > 0) {
            goalByStepsPerDay = newGoal;
            System.out.println("Цель установлена: " + newGoal);
        } else {
            System.out.println("Ваша цель, должна быть больше 0");
        }
    }

    void printStatistic() {
        System.out.println("Введите номер месяца:");
        System.out.println("1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5 - Май, 6 - Июнь, 7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь");
        System.out.print("--> ");
        int monthNumber = scanner.nextInt();
        if (monthNumber >= 1 && monthNumber <= 12) {
            String[] arrayMonth = new String[]{
                    "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                    "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
            };

            System.out.printf("Ваша статистика за %s: \n", arrayMonth[monthNumber - 1]);
            MonthData monthData = monthToData[monthNumber - 1];
            monthData.printDaysAndStepsFromMonth();
            System.out.printf("*** Общее количество шагов: %d \n", monthData.sumStepsFromMonth());
            System.out.printf("*** Максимальное пройденное количество шагов в день за месяц: %d \n", monthData.maxSteps());
            System.out.printf("*** Среднее количество шагов: %d \n", monthData.sumStepsFromMonth() / monthData.days.length);
            System.out.printf("*** Пройденная дистанция (в км): %d \n", converter.convertToKm(monthData.sumStepsFromMonth()));
            System.out.printf("*** Количество сожжённых килокалорий: %d \n", converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));
            System.out.printf("*** Лучшая серия: %d \n", monthData.bestSeries(goalByStepsPerDay));


        } else {
            System.out.println("Месяца с таким номером не существует ¯\\__(ツ)__/¯");
            System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно, а вы ввели:" + monthNumber);

        }
    }

}

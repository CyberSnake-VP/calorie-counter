import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        boolean isExisted = false;

        while (!isExisted) {
            printMenu();
            int input = scanner.nextInt();


            switch (input) {
                case 1:
                    stepTracker.addNewNumberStepsPerDay();
                    System.out.println("_".repeat(50));
                    break;
                case 2:
                    stepTracker.changeStepGoal();
                    System.out.println("_".repeat(50));
                    break;
                case 3:
                    stepTracker.printStatistic();
                    System.out.println("_".repeat(50));
                    break;
                case 4:
                    System.out.println("До скорой встречи!(◕‿◕)");
                    isExisted = true;
                    break;
                default:
                    System.out.println("Вы ввели несуществующую команду! ¯\\__(ツ)__/¯ Попробуйте снова!");
                    System.out.println("_".repeat(50));
            }
        }
    }

    static void printMenu() {
        // вывод доступных команд
        System.out.println("Добро пожаловать в счётчик калорий!");
        System.out.println("Выберите действие: ");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Напечатать статистику за определённый месяц");
        System.out.println("4. Выйти из приложения");
        System.out.print("->> ");
    }
}
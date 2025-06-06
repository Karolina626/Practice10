import java.util.Scanner;

public class Main {
    private static final int MAX_USERS = 15; // Ліміт котиків! Більше 15 — і сервер накриється(!
    private static String[] usernames = new String[MAX_USERS]; // Імена наших пухнастих друзів
    private static String[] passwords = new String[MAX_USERS]; // Секретні паролі для котячого клубу
    private static int userCount = 0; // Лічильник муркотунів

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nМеню про Котиків!");
            System.out.println("1 - Додати Котика");
            System.out.println("2 - Видалити Котика (ой-ой, а точно треба?)");
            System.out.println("3 - Аутентифікація (Вхід до котячого клубу!)");
            System.out.println("4 - Переглянути всіх Котиків");
            System.out.println("5 - Вихід (не покидайте нас...)");
            System.out.print("Оберіть дію: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Помилочка: введіть число від 1 до 5. Букви тут не працюють, на жаль!");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addUser(scanner);
                    break;
                case 2:
                    removeUser(scanner);
                    break;
                case 3:
                    authenticate(scanner);
                    break;
                case 4:
                    listUsers();
                    break;
                case 5:
                    System.out.println("Вихід... Котики будуть сумувати");
                    running = false;
                    break;
                default:
                    System.out.println("Невірний вибір. Котики ображені!");
            }
        }
        scanner.close();
    }

    private static void addUser(Scanner scanner) {
        if (userCount >= MAX_USERS) {
            System.out.println("Забагато Котиків! Ще один — і система лусне!");
            return;
        }

        System.out.print("Введіть ім'я Котика: ");
        String username = scanner.nextLine().trim();

        if (username.length() < 5 || username.contains(" ")) {
            System.out.println("Ім'я має містити не менше 5 символів і не мати пробілів! Навіть Барсик розуміє!");
            return;
        }

        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine().trim();

        if (!isValidPassword(password)) {
            System.out.println("Пароль має бути не менше 10 символів, містити 3 цифри і 1 спецсимвол. Безпека понад усе!");
            return;
        }

        usernames[userCount] = username;
        passwords[userCount] = password;
        userCount++;
        System.out.println("Котика додано! Він муркоче від щастя!");
    }

    private static void removeUser(Scanner scanner) {
        listUsers();
        System.out.print("Введіть ім'я Котика для видалення (ви точно цього хочете?): ");
        String username = scanner.nextLine().trim();

        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(username)) {
                usernames[i] = usernames[userCount - 1];
                passwords[i] = passwords[userCount - 1];
                userCount--;
                System.out.println("Котика видалено... Він образився і пішов до іншої сім'ї!");
                return;
            }
        }
        System.out.println("Котика не знайдено. Може, він просто сховався під ліжко?");
    }

    private static void authenticate(Scanner scanner) {
        System.out.print("Введіть ім'я Котика: ");
        String username = scanner.nextLine().trim();
        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine().trim();

        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
                System.out.println("Аутентифікація успішна! Котик вітає вас!");
                return;
            }
        }
        System.out.println("Помилочка аутентифікації. Котик шипить на вас!");
    }

    private static void listUsers() {
        if (userCount == 0) {
            System.out.println("Немає зареєстрованих Котиків. Як так? Додавайте хоч одного!");
            return;
        }
        System.out.println("Список Котиків:");
        for (int i = 0; i < userCount; i++) {
            System.out.println((i + 1) + ". " + usernames[i] + " (найкращий у світі Котик!)");
        }
    }

    private static boolean isValidPassword(String password) {
        if (password.length() < 10 || password.contains(" ")) return false;
        int digits = 0;
        boolean special = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) digits++;
            else if (!Character.isLetter(c)) special = true;
        }
        return digits >= 3 && special; //  Котики рекомендують складні паролі!
    }
}
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menuska();
    }

    public static void menuska() {
        String menu = "1.~Додати користувача~" + "\n2.~Перевірити користувача~";
        System.out.println(menu);
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Оберіть функцію: ");
            int fc = sc.nextInt();
            if (fc == 1) {
                cor();
            } else if (fc == 2) {
                System.out.println("В розробці");
            }
        } catch (InputMismatchException e) {
            System.out.println("Введіть цифру для вибору функції");
        }
    }

    public static void cor() {
        char str = ' ';
        int a = 0;
        String[] names = new String[15];
        try {
            while (true) {
                if (a < 16) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Введіть ім'я(щоб повернутися на головне меню, напишіть Повернутися): ");
                    String name = sc.nextLine();
                    if (name.equals("Повернутися")) {
                        menuska();
                    }
                    if (name.length() < 5) {
                        System.out.println("Мале ім'я, введіть ім'я більше 5-ти символів.");
                    } else if (name.indexOf(str) != -1) {
                        System.out.println("Без пробілів");
                    } else {
                        names[a] = name;
                        System.out.println("Ім'я: " + name);
                        password();
                        a++;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Масимально користувачів може бути 15, ви можете видалити щоб додати нових");
            try {
                while (true) {
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Введіть кого хочете видалити?(щоб повернутися на головне меню, напишіть Повернутися): ");
                    String per = sc1.nextLine();
                    if (per.equals("Повернутися")) {
                        menuska();
                    }
                    if (per.equals(names[0])) {
                        names[0] = null;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    } else if (per.equals(names[1])) {
                        names[1] = null;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    } else if (per.equals(names[2])) {
                        names[2] = null;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    } else if (per.equals(names[3])) {
                        names[3] = null;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    } else if (per.equals(names[4])) {
                        names[4] = null;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    } else if (per.equals(names[5])) {
                        names[5] = null;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    } else if (per.equals(names[6])) {
                        names[6] = null;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    } else if (per.equals(names[7])) {
                        names[7] = null;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    } else if (per.equals(names[8])) {
                        names[8] = null;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    } else if (per.equals(names[9])) {
                        names[9] = null;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    } else if (per.equals(names[10])) {
                        names[10] = null;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    } else if (per.equals(names[11])) {
                        names[11] = null;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    } else if (per.equals(names[12])) {
                        names[12] = null;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    } else if (per.equals(names[13])) {
                        names[13] = null;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    } else if (per.equals(names[14])) {
                        names[14] = null;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    } else if (per.equals(names[15])) {
                        names[15] = null;
                        System.out.println("\nСписок");
                        for (String name1 : names) {
                            System.out.println(name1);
                        }
                    } else if (names[a] == null) {
                        cor();
                    }
                }
            } catch (ArrayIndexOutOfBoundsException x) {
                System.out.println("Щоб видалити користувача потрібно ввести його ім'я.");
            }
        }
    }

    public static void password() {
        char str = ' ';
            Scanner sc = new Scanner(System.in);
            System.out.println("Введіть пароль: ");
            String pass = sc.nextLine();
            String lat = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
            for (char c : pass.toCharArray()) {
                if (lat.indexOf(c) != -1 ) {
            } else  {
                    System.out.println("Пароль повинен бути з латинських символів");
                    password();
                    break;
                }
            }
            if (pass.indexOf(str) != -1) {
                System.out.println("Без пробілів");
                password();
            }
            if (pass.length() < 10) {
                System.out.println("Малий пароль");
                password();
        }
            }
    }

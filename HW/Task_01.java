import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_01 {

    static Map<String, ArrayList<String>> phoneBookMap = new HashMap<>();
    static String str = "";
    static Scanner sc = new Scanner(System.in, "cp866");

    public static void main(String[] args) {
        printNote();
        while (!str.equalsIgnoreCase("exit")) {
            System.out.print("Ваше слово: ");
            str = sc.nextLine();
            if (str.startsWith("write")) {
                createEntryPHB();
            } else if (str.startsWith("read")) {
                printPhoneBook();
            } else {
                if (!str.equalsIgnoreCase("exit")) {
                    printNote();
                }
            }
        }
        System.out.println("Работа программы завершена.\n");

    }

    public static void printNote() {
        System.out.println("Для записи данных в телефонную книгу введите \"write\".\n" +
                "Для отображения записей введите \"read\".\n" +
                "Для выхода из программы введите \"exit\".\n");
    }

    public static void createEntryPHB() {
        System.out.print("Введите фамилию: ");
        String surname = sc.nextLine();
        System.out.print("Введите номер телефона: ");
        String phone = sc.nextLine();
        if (phoneBookMap.containsKey(surname)) {
            phoneBookMap.get(surname).add(phone);
        } else {
            ArrayList<String> tempArrayList = new ArrayList<>();
            tempArrayList.add(phone);
            phoneBookMap.put(surname, tempArrayList);
        }
        System.out.printf("%s: %s\n", surname, phoneBookMap.get(surname));
    }

    public static void printPhoneBook() {
        int max_phone_count = GetMax();
        for (int i = max_phone_count; i > 0; i--) {
            for (var item : phoneBookMap.entrySet()) {
                if (item.getValue().size() == i) {
                    for (int j = 0; j < i; j++) {
                        System.out.printf("%s: %s\n", item.getKey(), item.getValue().get(j));
                    }
                }
            }
        }
    }

    public static Integer GetMax() {
        int max_phone_count = 0;
        for (var item : phoneBookMap.entrySet()) {
            if (item.getValue().size() > max_phone_count) {
                max_phone_count = item.getValue().size();
            }
        }
        return max_phone_count;
    }

}
import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    private Scanner scanner;

    public ConsoleUserInterface() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("1. Просмотр всех событий");
        System.out.println("2. Обновить данные события");
        System.out.println("3. Создать новое событие");
        System.out.println("4. Удалить событие");
        System.out.println("5. Выход из программы");
    }

    @Override
    public int getUserChoice() {
        return scanner.nextInt();
    }

    public void displayMessage(String message) {
        showMessage(message);
    }

    public void displayHeader(String header) {
        UserInterface.printHeader(header);
    }
}
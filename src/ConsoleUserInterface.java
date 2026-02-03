import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    private Scanner scanner;

    public ConsoleUserInterface() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("1. Показать список участников");
        System.out.println("2. Изменить данные участника");
        System.out.println("3. Создать нового участника");
        System.out.println("4. Удалить участника");
        System.out.println("5. Выход");
    }

    @Override
    public int getUserChoice() {
        return scanner.nextInt();
    }
}
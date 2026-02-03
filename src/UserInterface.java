public interface UserInterface {
    void showMenu();
    int getUserChoice();

    default void showMessage(String message) {
        System.out.println(message);
    }

    static void printHeader(String header) {
        System.out.println("***** " + header + " *****");
    }
}
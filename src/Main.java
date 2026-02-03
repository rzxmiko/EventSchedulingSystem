public class Main {
    private UserInterface userInterface;
    private EventService eventService;

    public Main(UserInterface userInterface, EventService eventService) {
        this.userInterface = userInterface;
        this.eventService = eventService;
    }

    public void run() throws Exception {
        boolean running = true;

        while (running) {
            userInterface.showMenu();
            int command = userInterface.getUserChoice();

            switch (command) {
                case 1:
                    eventService.showEvents();
                    break;
                case 2:
                    eventService.updateEvent();
                    break;
                case 3:
                    eventService.createEvent();
                    break;
                case 4:
                    eventService.deleteEvent();
                    break;
                case 5:
                    running = false;
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверная команда, попробуйте снова.");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        UserInterface userInterface = new ConsoleUserInterface();
        EventDAO eventDAO = new EventDAO(DatabaseUtils.getConnection());
        EventService eventService = new EventService(eventDAO);
        Main app = new Main(userInterface, eventService);
        app.run();
    }
}
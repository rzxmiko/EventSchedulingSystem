public class Main {
    private UserInterface userInterface;
    private ParticipantService participantService;

    public Main(UserInterface userInterface, ParticipantService participantService) {
        this.userInterface = userInterface;
        this.participantService = participantService;
    }

    public void run() throws Exception {
        while (true) {
            userInterface.showMenu();
            int command = userInterface.getUserChoice();

            switch (command) {
                case 1:
                    participantService.showParticipants();
                    break;
                case 2:
                    participantService.updateParticipant();
                    break;
                case 3:
                    participantService.createParticipant();
                    break;
                case 4:
                    participantService.deleteParticipant();
                    break;
                case 5:
                    return; // Выход
                default:
                    System.out.println("Неверная команда, попробуйте снова.");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        UserInterface userInterface = new ConsoleUserInterface();
        ParticipantDAO participantDAO = new ParticipantDAO(DatabaseUtils.getConnection());
        ParticipantService participantService = new ParticipantService(participantDAO);
        Main app = new Main(userInterface, participantService);
        app.run();
    }
}
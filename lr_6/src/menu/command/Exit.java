package menu.command;

public class Exit implements Command {
    @Override
    public void execute() {
        System.out.println("Вихід з програми...");
        System.exit(0);
    }

    @Override
    public String getName() {
        return "Вихід";
    }
}

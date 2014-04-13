package rover;

public class Rover {

    private Location location;
    private SignalsToCommandsTable signalsToCommands;

    public Rover(Location location, SignalsToCommandsTable signalsToCommands) {
        this.location = location;
        this.signalsToCommands = signalsToCommands;
    }

    public void receive(String signalsSequence) {
        Commands commands = signalsToCommands.translate(signalsSequence);
        location = commands.apply(location);
    }

    public boolean at(Location location) {
        return this.location.equals(location);
    }

    @Override
    public String toString() {
        return "Rover [location=" + location + "]";
    }
}

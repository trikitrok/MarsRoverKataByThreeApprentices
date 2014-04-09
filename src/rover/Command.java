package rover;

public interface Command {
    public Location apply(Location location);
}

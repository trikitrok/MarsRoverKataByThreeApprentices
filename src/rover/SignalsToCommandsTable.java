package rover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rover.commands.Move;
import rover.commands.RotateLeft;
import rover.commands.RotateRight;
import rover.commands.UnknownCommandException;

public class SignalsToCommandsTable {

    private final String ROTATE_LEFT = "l";
    private final String ROTATE_RIGHT = "r";
    private final String MOVE_FORWARDS = "f";
    private final String MOVE_BACKWRDS = "b";

    public Commands translate(String signalsSequence, World world) {
        List<String> signals = extractSignals(signalsSequence);
        return translate(signals, world);
    }

    private Commands translate(List<String> signals, World world) {
        List<Command> commands = new ArrayList<Command>();

        for (String signal : signals) {
            if (signal.isEmpty())
                continue;

            commands.add(createCommand(signal, world));
        }
        return new Commands(commands);
    }

    private List<String> extractSignals(String commandsSequence) {
        return Arrays.asList(commandsSequence.split(""));
    }

    private Command createCommand(String signal, World world) {
        if (ROTATE_LEFT.equals(signal)) {
            return new RotateLeft();
        } else if (ROTATE_RIGHT.equals(signal)) {
            return new RotateRight();
        } else if (MOVE_FORWARDS.equals(signal)) {
            return new Move(world, 1);
        } else if (MOVE_BACKWRDS.equals(signal)) {
            return new Move(world, -1);
        } else {
            throw new UnknownCommandException();
        }
    }
}

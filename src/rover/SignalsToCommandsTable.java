package rover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rover.commands.Command;
import rover.commands.Move;
import rover.commands.RotateLeft;
import rover.commands.RotateRight;
import rover.commands.UnknownCommandException;

public class SignalsToCommandsTable {

    private final String ROTATE_LEFT = "l";
    private final String ROTATE_RIGHT = "r";
    private final String MOVE_FORWARDS = "f";
    private final String MOVE_BACKWARDS = "b";
    private final int FORWARDS_DISPLACEMENT = 1;
    private final int BACKWARDS_DISPLACEMENT = -1;

    private Map<String, Command> commandsBySignal;

    public SignalsToCommandsTable(World world) {
        commandsBySignal = new HashMap<String, Command>();
        commandsBySignal.put(ROTATE_LEFT, new RotateLeft());
        commandsBySignal.put(ROTATE_RIGHT, new RotateRight());
        commandsBySignal.put(MOVE_FORWARDS, new Move(world, FORWARDS_DISPLACEMENT));
        commandsBySignal.put(MOVE_BACKWARDS, new Move(world, BACKWARDS_DISPLACEMENT));
    }

    public Commands translate(String signalsSequence) {
        List<String> signals = extractSignals(signalsSequence);
        return translate(signals);
    }

    private Commands translate(List<String> signals) {
        List<Command> commands = new ArrayList<Command>();

        for (String signal : signals) {
            if (signal.isEmpty())
                continue;

            commands.add(createCommand(signal));
        }
        return new Commands(commands);
    }

    private List<String> extractSignals(String commandsSequence) {
        return Arrays.asList(commandsSequence.split(""));
    }

    private Command createCommand(String signal) {
        Command command = commandsBySignal.get(signal);

        if (command == null) {
            throw new UnknownCommandException();
        }
        return command;
    }
}

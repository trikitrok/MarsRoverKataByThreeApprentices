package rover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rover.commands.MoveBackwards;
import rover.commands.MoveForwards;
import rover.commands.RotateLeft;
import rover.commands.RotateRight;

public class SignalsToCommandsTable {

    public Commands translate(String signalsSequence, World world) {
        List<String> signals = extractSignals(signalsSequence);
        return translate(signals, world);
    }

    private Commands translate(List<String> signals, World world) {
        List<Command> commands = new ArrayList<Command>();

        for (String signal : signals) {
            if (signal.equals(""))
                continue;

            commands.add(createCommand(signal, world));
        }
        return new Commands(commands);
    }

    private List<String> extractSignals(String commandsSequence) {
        return Arrays.asList(commandsSequence.split(""));
    }

    private Command createCommand(String signal, World world) {
        if ("l".equals(signal)) {
            return new RotateLeft();
        } else if ("r".equals(signal)) {
            return new RotateRight();
        } else if (signal.equals("f")) {
            return new MoveForwards(world);
        } else {
            return new MoveBackwards(world);
        }
    }
}

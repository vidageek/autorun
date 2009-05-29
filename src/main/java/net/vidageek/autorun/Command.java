package net.vidageek.autorun;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

final public class Command {

    private final String[] shellCommand;

    public Command(final String... args) {
        shellCommand = args;
    }

    public InputStreamReader run() {
        Log.log("Running command: " + Arrays.toString(shellCommand));
        try {

            Process process = new ProcessBuilder(shellCommand).redirectErrorStream(true).start();

            return new InputStreamReader(process.getInputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

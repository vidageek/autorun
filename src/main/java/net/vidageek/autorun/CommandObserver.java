package net.vidageek.autorun;

import java.io.IOException;
import java.io.InputStreamReader;

final public class CommandObserver implements Runnable {

    private final Command command;
    private volatile boolean shouldStop;

    public CommandObserver(final Command command) {
        this.command = command;
    }

    public void stop() {
        shouldStop = true;
    }

    public void run() {

        InputStreamReader reader = command.run();

        int c;
        try {

            while (((c = reader.read()) != -1) && !shouldStop) {
                System.out.print((char) c);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

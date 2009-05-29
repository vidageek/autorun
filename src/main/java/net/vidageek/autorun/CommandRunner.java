package net.vidageek.autorun;

final public class CommandRunner {

    private final Command command;

    private CommandObserver observer;

    public CommandRunner(final Command command) {
        this.command = command;
    }

    public void startNewExecution() {
        observer = new CommandObserver(command);
        new Thread(observer).start();
    }

    public void stopExecution() {
        observer.stop();
        System.out.println();
    }

}

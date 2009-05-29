package net.vidageek.autorun;

final public class DirectoryListener {

    private final Directory directory;
    private final Command command;

    public DirectoryListener(final Directory directory, final Command command) {
        this.directory = directory;
        this.command = command;
    }

    public void startListening() {
        new Thread(new Runnable() {

            public void run() {
                DirStatus initialState = directory.readState();
                CommandRunner runner = new CommandRunner(command);
                runner.startNewExecution();

                while (true) {
                    DirStatus atual = directory.readState();

                    if (!atual.equals(initialState)) {
                        initialState = atual;
                        runner.stopExecution();
                        runner.startNewExecution();
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }).start();
    }

}

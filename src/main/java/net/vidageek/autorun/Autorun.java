package net.vidageek.autorun;

import java.io.File;

final public class Autorun {

    public static void main(final String[] args) throws InterruptedException {
        if (args.length == 0) {
            printUsage();
        }

        System.out.println("Monitoring directory: " + new File(".").getAbsolutePath());

        new DirectoryListener(new Directory(new File(".")), new Command(args)).startListening();

    }

    private static void printUsage() {
        System.out.println("Usage for autorun:");
        System.out.println("java -jar autorun.jar command_to_run");
        System.exit(0);
    }

}

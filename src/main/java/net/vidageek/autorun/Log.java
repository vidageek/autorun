package net.vidageek.autorun;

final public class Log {

    private static boolean enabled = false;

    public static void disable() {
        enabled = false;
    }

    public static void enable() {
        enabled = true;
    }

    public static void log(final String message) {
        if (enabled) {
            System.out.println(message);
        }
    }

}

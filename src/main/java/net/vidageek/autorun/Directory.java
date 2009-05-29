package net.vidageek.autorun;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

final public class Directory {

    private final File rootDir;

    public Directory(final File rootDir) {
        this.rootDir = rootDir;
    }

    public DirStatus readState() {
        Log.log("===========Reading state of monitored directory.===============");
        return new DirStatus(readState(rootDir));
    }

    private Map<String, Long> readState(final File root) {
        Map<String, Long> map = new HashMap<String, Long>();

        for (File file : root.listFiles()) {
            Log.log("Reading state for: " + file.getAbsolutePath());
            if (file.isDirectory()) {
                map.putAll(readState(file));
            } else {
                map.put(file.getAbsolutePath(), file.lastModified());
            }
        }

        return map;
    }
}

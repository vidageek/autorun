package net.vidageek.autorun;

import java.util.Map;

final public class DirStatus {

    private final Map<String, Long> state;

    public DirStatus(final Map<String, Long> state) {
        this.state = state;
    }

    @Override
    public boolean equals(final Object obj) {
        Map<String, Long> other = ((DirStatus) obj).state;

        if (state.size() != other.size()) {
            return false;
        }

        for (String key : state.keySet()) {
            if (!state.get(key).equals(other.get(key))) {
                return false;
            }
        }

        return true;
    }

}

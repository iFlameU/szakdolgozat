package szakdolgozat.checker;

import java.util.Arrays;

public class Checker {
    public boolean isResolution(String guess, int currentBlockHash) {
        return Arrays.hashCode(new String[]{String.valueOf(currentBlockHash), guess}) % 100000 == 0;
    }
}

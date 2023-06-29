import java.util.Collections;
import java.util.List;

public class DESU {
    private final KeyGenerator keygenerator = new KeyGenerator();
    private final Processor processor = new Processor();

    public int[] encrypt(int[] input, int[] key) {
        List<int[]> keys = keygenerator.generateKeys(key);
        keys.forEach(ArrayUtils::displayBits);
        return processor.process(input, keys);
    }

    public int[] decrypt(int[] input, int[] key) {
        List<int[]> keys = keygenerator.generateKeys(key);
        Collections.reverse(keys);
        return processor.process(input, keys);
    }

}

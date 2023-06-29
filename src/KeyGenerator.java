import java.util.ArrayList;
import java.util.List;

public class KeyGenerator {

    public List<int[]> generateKeys(int[] key) {
        List<int[]> keys = new ArrayList<>(16);
        final int[] compressedKey = ArrayUtils.permutation(key, Constants.PC1, 56);

        int[] left = new int[28];
        int[] right = new int[28];
        System.arraycopy(compressedKey, 0, left, 0, 28);
        System.arraycopy(compressedKey, 28, right, 0, 28);

        for (int i = 0; i < 16; i++) {
            left = ArrayUtils.rotateLeft(left, Constants.ROTATIONS[i]);
            right = ArrayUtils.rotateLeft(right, Constants.ROTATIONS[i]);
            final int[] concat = new int[56];
            System.arraycopy(left, 0, concat, 0, 28);
            System.arraycopy(right, 0, concat, 28, 28);

            final int[] compressedConcat = ArrayUtils.permutation(concat, Constants.PC2, 48);
            keys.add(compressedConcat);
        }

        return keys;
    }
}

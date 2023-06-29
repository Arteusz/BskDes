import java.util.List;

public class Processor {
    private final Feistel feistel = new Feistel();

    public int[] process(int[] input, List<int[]> keys) {
        final int[] initialPerm = ArrayUtils.permutation(input, Constants.IP, 64);

        int[] left = new int[32];
        int[] right = new int[32];
        System.arraycopy(initialPerm, 0, left, 0, 32);
        System.arraycopy(initialPerm, 32, right, 0, 32);

        for (int i = 0; i < 16; i++) {
            final int[] feistelResult = feistel.feistel(right, keys.get(i));
            final int[] feistelXorLeft = ArrayUtils.xor(left, feistelResult, 32);
            left = right;
            right = feistelXorLeft;
        }

        final int[] concat = new int[64];
        System.arraycopy(right, 0, concat, 0, 32);
        System.arraycopy(left, 0, concat, 32, 32);

        return ArrayUtils.permutation(concat, Constants.FP, 64);
    }
}

public class Feistel {

    public int[] feistel(int[] right, int[] key) {
        final int[] rightExpand = ArrayUtils.permutation(right, Constants.E, 48);
        final int[] rightXorKey = ArrayUtils.xor(rightExpand, key, 48);
        final int[] sBlockResult = sBlock(rightXorKey);
        final int[] permuteSblock = ArrayUtils.permutation(sBlockResult, Constants.P, 32);
        return permuteSblock;
    }

    private int[] sBlock(int[] input) {
        final int[] output = new int[32];

        for (int i = 0; i < 8; i++) {
            final int[] block = new int[6];
            System.arraycopy(input, 6 * i, block, 0, 6);
            final int[] result = processBlock(block, i);
            System.arraycopy(result, 0, output, 4 * i, 4);
        }
        return output;
    }

    private int[] processBlock(int[] block, int i) {
        int row = BinaryUtils.from2BitArray(new int[]{
                block[0],
                block[5]
        });

        int col = BinaryUtils.from4BitArray(new int[]{
                block[1],
                block[2],
                block[3],
                block[4]
        });

        byte result = Constants.S[i][(row * 16) + col];
        return BinaryUtils.toBitArray(result);
    }
}

public class ArrayUtils {

    public static int[] permutation(int[] input, byte[] permutation, int size) {
        final int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = input[permutation[i] - 1];
        }
        return result;
    }

    public static int[] rotateLeft(int[] input, int rotation) {
        final int length = input.length;
        final int[] result = new int[length];
        for (int i = 0; i < length; i++)
            result[i] = input[(rotation + i) % length];
        return result;
    }

    public static int[] xor(int[] left, int[] right, int length) {
        final int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = left[i] ^ right[i];
        }
        return result;
    }

    public static void displayBits(int[] bits) {
        // Method to display int array bits as a hexadecimal string.
        for (int i = 0; i < bits.length; i += 4) {
            String output = "";
            for (int j = 0; j < 4; j++) {
                output += bits[i + j];
            }
            System.out.print(Integer.toHexString(Integer.parseInt(output, 2)));
        }
        System.out.println();
    }
}

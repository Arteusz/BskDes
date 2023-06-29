public class BinaryUtils {
    public static int[] toBitArray(byte value) {
        return new int[] {
                ((value >> 3) & 1),
                ((value >> 2) & 1),
                ((value >> 1) & 1),
                ((value >> 0) & 1),
        };
    }

    public static int from4BitArray(int[] bits) {
        return ((bits[0] & 0x1) << 3) |
                ((bits[1] & 0x1) << 2) |
                ((bits[2] & 0x1) << 1) |
                ((bits[3] & 0x1) << 0);
    }

    public static int from2BitArray(int[] bits) {
        return ((bits[0] & 0x1) << 1) |
                ((bits[1] & 0x1) << 0);
    }
}

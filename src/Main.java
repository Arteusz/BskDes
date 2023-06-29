public class Main {
    public static void main(String[] args) {
        final DESU desu = new DESU();

        String keyString = "AABB09182736CCDD";
        int[] key = toBinArray(keyString, 64);

        String inputString = "123456ABCD132536";
        int[] input = toBinArray(inputString, 64);

        int[] encrypted = desu.encrypt(input, key);
        System.out.println("Encrypted:");
        ArrayUtils.displayBits(encrypted);

        int[] decrypted = desu.decrypt(encrypted, key);
        System.out.println("Decrypted:");
        ArrayUtils.displayBits(decrypted);
    }

    private static int[] toBinArray(String keyString, int arraySize) {
        int[] result = new int[arraySize];
        for (int i = 0; i < 16; i++) {
            String s = Integer.toBinaryString(Integer.parseInt(keyString.charAt(i) + "", 16));
            while (s.length() < 4) {
                s = "0" + s;
            }
            for (int j = 0; j < 4; j++) {
                result[(4 * i) + j] = Integer.parseInt(s.charAt(j) + "");
            }
        }
        return result;
    }
}

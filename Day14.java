import java.math.BigInteger;

public class Day14 {

    public static final int DISK_SIZE = 128;

    private static int fill(boolean[][] disk, int i, int j) {
        if (i < 0 || j < 0 || i >= DISK_SIZE || j >= DISK_SIZE || !disk[i][j]) {
            return 0;
        }
        disk[i][j] = false;
        fill(disk, i + 1, j);
        fill(disk, i - 1, j);
        fill(disk, i, j + 1);
        fill(disk, i, j - 1);
        return 1;
    }

    public static void main(String[] args) {
        String input = "stpzcrnm";

        int used = 0;
        boolean[][] disk = new boolean[DISK_SIZE][DISK_SIZE];
        for (int i = 0; i < DISK_SIZE; i++) {
            String knotHex = Day10.part2(input + "-" + i);
            String binary = new BigInteger(knotHex, 16).toString(2);
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(binary.length() - 1 - j) == '1') {
                    used++;
                    disk[i][DISK_SIZE - 1 - j] = true;
                }
            }
        }
        // part 1
        System.out.println(used);

        // part 2
        int groups = 0;
        for (int i = 0; i < DISK_SIZE; i++) {
            for (int j = 0; j < DISK_SIZE; j++) {
                groups += fill(disk, i, j);
            }
        }
        System.out.println(groups);
    }
}

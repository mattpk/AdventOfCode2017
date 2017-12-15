public class Day15 {

    public static int part1(int startingA, int startingB) {
        long a = startingA;
        long b = startingB;
        int count = 0;
        for (int i = 0; i < 40000000; i++) {
            a = (a * 16807) % 2147483647;
            b = (b * 48271) % 2147483647;
            if ((a & 0xFFFF) == (b & 0xFFFF)) {
                count++;
            }
        }
        return count;
    }

    public static int part2(int startingA, int startingB) {
        long a = startingA;
        long b = startingB;
        int count = 0;
        for (int i = 0; i < 5000000; i++) {
            do {
                a = (a * 16807) % 2147483647;
            } while (a % 4 != 0);
            do {
                b = (b * 48271) % 2147483647;
            } while (b % 8 != 0);
            if ((a & 0xFFFF) == (b & 0xFFFF)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int startingA = 699;
        int startingB = 124;

        System.out.println(part1(startingA, startingB));
        System.out.println(part2(startingA, startingB));
    }

}

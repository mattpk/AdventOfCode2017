import java.io.FileReader;
import java.util.Scanner;

public class Day11 {

    public static int distance(int n, int nw) {
        if (Math.abs(n) < Math.abs(nw)) {
            // swap so we have only one case
            int tmp = n;
            n = nw;
            nw = tmp;
        }
        if (n < 0) {
            // swap to simplify mirrored cases
            n = -n;
            nw = -nw;
        }
        if (nw > 0) {
            return n + nw;
        } else {
            return n;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new FileReader("src/input/day11.in"));
        String input = in.next();
        String[] moves = input.split(",");
        int nw = 0;
        int n = 0;

        int maxDistance = 0;
        for (String move : moves) {
            switch (move) {
                case "n":
                    n++;
                    break;
                case "ne":
                    n++;
                    nw--;
                    break;
                case "nw":
                    nw++;
                    break;
                case "s":
                    n--;
                    break;
                case "se":
                    nw--;
                    break;
                case "sw":
                    n--;
                    nw++;
                    break;
            }
            maxDistance = Math.max(maxDistance, distance(n, nw));
        }
        // Part 1
        System.out.println(distance(n, nw));
        // Part 2
        System.out.println(maxDistance);

    }
}

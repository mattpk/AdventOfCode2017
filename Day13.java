import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day13 {

    public static int part1(List<Integer> depths, List<Integer> ranges) {
        int severity = 0;
        for (int i = 0; i < depths.size(); i++) {
            if (depths.get(i) % (ranges.get(i) * 2 - 2) == 0) {
                severity += depths.get(i) * ranges.get(i);
            }
        }
        return severity;
    }

    public static int part2(List<Integer> depths, List<Integer> ranges) {
        outer:
        for (int delay = 0;; delay++) {
            for (int i = 0; i < depths.size(); i++) {
                if ((delay + depths.get(i)) % (ranges.get(i) * 2 - 2) == 0) {
                    continue outer;
                }
            }
            return delay;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new FileReader("src/input/day13.in"));
        List<Integer> depths = new ArrayList<>();
        List<Integer> ranges = new ArrayList<>();
        while (in.hasNextLine()) {
            String[] split = in.nextLine().split(": ");
            depths.add(Integer.parseInt(split[0]));
            ranges.add(Integer.parseInt(split[1]));
        }

        System.out.println(part1(depths, ranges));
        System.out.println(part2(depths, ranges));
    }
}

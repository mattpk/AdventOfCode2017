import java.io.FileReader;
import java.util.*;

public class Day6 {

    public static int maxIndex(List<Integer> input) {
        int maxIdx = 0;
        for (int i = 1; i < input.size(); i++) {
            if (input.get(maxIdx) < input.get(i)) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    public static int part1(List<Integer> input) {
        Set<List<Integer>> seenConfigs = new HashSet<>();
        while (!seenConfigs.contains(input)) {
            seenConfigs.add(new ArrayList<>(input));
            int maxIdx = maxIndex(input);
            int mem = input.get(maxIdx);
            input.set(maxIdx, 0);
            int i = maxIdx + 1;
            while (mem > 0) {
                if (i >= input.size()) {
                    i = 0;
                }
                input.set(i, input.get(i) + 1);
                i++;
                mem--;
            }
        }
        return seenConfigs.size();
    }

    public static int part2(List<Integer> input) {
        Map<List<Integer>, Integer> seenConfigs = new HashMap<>();
        for (int iteration = 0;;iteration++) {
            if (seenConfigs.containsKey(input)) {
                return iteration - seenConfigs.get(input);
            }
            seenConfigs.put(new ArrayList<>(input), iteration);
            int maxIdx = maxIndex(input);
            int mem = input.get(maxIdx);
            input.set(maxIdx, 0);
            int i = maxIdx + 1;
            while (mem > 0) {
                if (i >= input.size()) {
                    i = 0;
                }
                input.set(i, input.get(i) + 1);
                i++;
                mem--;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new FileReader("src/input/day6.in"));
        List<Integer> input = new ArrayList<>();
        while (in.hasNextInt()) {
            input.add(in.nextInt());
        }
        System.out.println(part1(new ArrayList<>(input)));
        System.out.println(part2(new ArrayList<>(input)));
    }
}

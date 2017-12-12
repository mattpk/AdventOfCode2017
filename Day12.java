import java.io.FileReader;
import java.util.*;

public class Day12 {

    public static int part1(int program, Map<Integer, Set<Integer>> pipes, Set<Integer> av) {
        if (av.contains(program)) {
            return 0;
        }
        av.add(program);
        int sum = 1;
        for (int i : pipes.get(program)) {
            sum += part1(i, pipes, av);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new FileReader("src/input/day12.in"));
        Map<Integer, Set<Integer>> pipes = new HashMap<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] split = line.split(" <-> ");
            int from = Integer.parseInt(split[0]);
            Set<Integer> set = new HashSet<>();
            set.add(from);
            Arrays.stream(split[1].split(", ")).forEach(s -> {
                set.add(Integer.parseInt(s));
            });
            pipes.put(from, set);
        }
        Set<Integer> alreadyVisited = new HashSet<>();
        System.out.println(part1(0, pipes, alreadyVisited));

        // taking advantage of part 1
        int part2 = 1;
        for (int i : pipes.keySet()) {
            if (part1(i, pipes, alreadyVisited) > 0) {
                part2++;
            }
        }
        System.out.println(part2);
    }
}

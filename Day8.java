import java.io.FileReader;
import java.util.*;

public class Day8 {


    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new FileReader("src/input/day8.in"));
        List<String> input = new ArrayList<>();
        Map<String, Integer> registries = new HashMap<>();

        int part2 = 0;

        while(in.hasNextLine()) {
            String[] command = in.nextLine().split(" ");
            String reg = command[0];
            int incr = Integer.parseInt(command[2]);
            if (command[1].equals("dec")) {
                incr = -incr;
            }
            String left = command[4];
            String operator = command[5];
            int right = Integer.parseInt(command[6]);

            int cur = registries.getOrDefault(reg, 0);
            int operand = registries.getOrDefault(left, 0);
            if (operator.equals(">") && operand > right ||
                    operator.equals("<") && operand < right ||
                    operator.equals("==") && operand == right ||
                    operator.equals("!=") && operand != right ||
                    operator.equals(">=") && operand >= right ||
                    operator.equals("<=") && operand <= right) {
                registries.put(reg, cur + incr);
                part2 = Math.max(part2, cur + incr);
            }
        }

        int part1 = registries.values().stream().mapToInt(i -> i).max().getAsInt();
        System.out.println(part1);
        System.out.println(part2);
    }
}

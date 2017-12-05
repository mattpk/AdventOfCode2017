import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5 {

    public static int part1(List<Integer> input) {
        int index = 0;
        int steps = 0;
        while (index >= 0 && index < input.size()) {
            steps++;
            int num = input.get(index);
            input.set(index, num + 1);
            index += num;
        }
        return steps;
    }

    public static int part2(List<Integer> input) {
        int index = 0;
        int steps = 0;
        while (index >= 0 && index < input.size()) {
            steps++;
            int num = input.get(index);
            if (num >= 3) {
                input.set(index, num - 1);
            } else {
                input.set(index, num + 1);
            }
            index += num;
        }
        return steps;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new FileReader("src/input/day5.in"));
        List<Integer> input = new ArrayList<>();
        while (in.hasNextInt()) {
            input.add(in.nextInt());
        }
        System.out.println(part1(new ArrayList<>(input)));
        System.out.println(part2(new ArrayList<>(input)));
    }
}

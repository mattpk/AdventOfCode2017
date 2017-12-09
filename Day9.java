import java.io.FileReader;
import java.util.*;

public class Day9 {

    public static int part1(String input) {
        int depth = 0;
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '{') {
                depth++;
            } else if (c == '}') {
                sum += depth;
                depth--;
            }
        }
        return sum;
    }

    public static int removeAndCountGarbage(String input, StringBuilder builder) {
        int count = 0;
        boolean open = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!open && c == '<') {
                open = true;
                count--;
            }
            if (!open) {
                builder.append(c);
            } else {
                count++;
            }
            if (open && c == '>') {
                open = false;
                count--;
            }
            if (open && c == '!') {
                i++; // skip next char
                count--;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new FileReader("src/input/day9.in"));

        String input = in.nextLine();
        StringBuilder output = new StringBuilder();
        int part2 = removeAndCountGarbage(input, output);

        System.out.println(part1(output.toString()));
        System.out.println(part2);
    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day3 {

    public static final int INPUT = 265149;

    // Runs in constant time!
    public static int part1(int input) {
        if (input == 1) {
            return 0;
        }
        int boundingSquare = (int) Math.ceil(Math.sqrt(input));
        int sideLength = boundingSquare % 2 == 0 ? boundingSquare + 1 : boundingSquare;
        int max = sideLength * sideLength;
        int modPad =  (sideLength - 2) - (max % (sideLength - 1));
        int modOnSide = (input + modPad) % (sideLength - 1);
        return modOnSide < (sideLength - 3) / 2 ? sideLength - 2 - modOnSide : modOnSide + 1;
    }

    public static int part2(int input) {
        Map<List<Integer>, Integer> coordinates = new HashMap<>();
        coordinates.put(Arrays.asList(0, 0), 1);
        int x = 1;
        int y = 0;
        int direction = 2;
        int steps = 0;
        int stepSize = 2;
        int legsWalked = 0;
        while (true) {
            int sum = 0;
            // check neighbours
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (coordinates.containsKey(Arrays.asList(x + i, y + j))) {
                        sum += coordinates.get(Arrays.asList(x + i, y + j));
                    }
                }
            }
            if (sum > input) {
                return sum;
            }
            coordinates.put(Arrays.asList(x, y), sum);

            // rotation
            steps++;
            if (steps == stepSize) {
                legsWalked++;
                if (legsWalked == 4) {
                    stepSize+=2;
                    legsWalked = 0;
                    // reposition cursor
                    x++;
                    y--;
                }
                direction++;
                steps = 0;
            }

            // movement
            switch (direction % 4) {
                case 0:
                    y--;
                    break;
                case 1:
                    x++;
                    break;
                case 2:
                    y++;
                    break;
                case 3:
                    x--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(part1(INPUT));
        System.out.println(part2(INPUT));
    }
}

# Advent Of Code 2017 Solutions
My Java solutions to the festive [Advent of Code](http://adventofcode.com/2017) programming puzzles. Please feel free to reach out with any clarifications, as speed was prioritized over elegance.

## Solution Detail

#### Day 1 - [Inverse Captcha](http://adventofcode.com/2017/day/1)
A short and sweet problem to start the month off. Iterate over each digit, adding to the sum if the next digit/ the digit halfway around the list differs. Make use of modulo to handle the circular list. O(n) for the n-digit string.

#### Day 2 - [Corruption Checksum](http://adventofcode.com/2017/day/2)
Coded up a simple O(nm<sup>2</sup>) brute force solution, checking each member of each row against eachother to find the match. Given the small number of rows (n) and columns (m), this is adequate.

#### Day 3 - [Spiral Memory](http://adventofcode.com/2017/day/3)
Part 1 was solved in constant O(1) time with a mathematical formula. My approach was to find the _shell_ that the data occupies, then use modulo to target which of the four sides of the shell that the data exists in.

For part 2, I simulated the coordinate system with a hash table and simulated the allocation order, with careful timing on 'turns' for a passing O(n) solution.

#### Day 4 - [High-Entropy Passphrases](http://adventofcode.com/2017/day/4)
For part 1, using a HashSet filters duplicate words. If the number of unique tokens is equal to the number of tokens, then the passphrase is valid. This runs in O(n) time, given n tokens.

For part 2, I used the same approach, but sorting the tokens beforehand. This way, anagrams will collide in the set. This runs in O(n log m) time, with m being the length of the word. If necessary, the log factor can be reduced to a constant by using a radix sort on the 26-letter alphabet, or by using a (character -> frequency) Map structure to be passed in the set.

#### Day 5 - [A Maze of Twisty Trampolines, All Alike](http://adventofcode.com/2017/day/5)
I solved this problem by simulating the jumps, which is admittedly a naive solution. But it executes in less than a second thanks to the small input size. An interesting problem, will take another look at this later.

#### Day 6 - [Memory Reallocation](http://adventofcode.com/2017/day/6)
Given the small input it is simplest to simulate the debugger routine described in the problem. I used a HashMap in order to record if a previous permutation has been seen before. The extension for part 2 was to augment the HashMap to store the iteration at which the first occurence of the key was found, and return the difference once the loop is detected.

#### Day 7 - [Recursive Circus](http://adventofcode.com/2017/day/7)
I faced a little bit of language friction writing this problem in Java. Now that I know what kind of problems to expect, I might use this opportunity to pick up a new language, such as _Go_.

I built a tree data structure. The first part involves an algorithm to find the root of the tree -- simply follow the parent back from any node. This takes O(n) time, since I need to construct the tree. Of course, this would be O(log n) if a balanced tree was already provided.
The second part was a recursive solution. The idea is to find the first set of children with opposing sums of weights, always checking children before parents.

Unfortunately, there is an edge case in the problem where the solution is ambiguous. An example is
```$xslt
left (10)
right (20)
root (30) -> left, right
```
In this list, exactly one program is the wrong weight. But it is either left or right, and there is no way to determine which. Luckily, this doesn't appear in my input!

#### Day 8 - [I Heard You Like Registers](http://adventofcode.com/2017/day/8)
I simulated the described _CPU_, maintaining registries in a HashMap. This takes linear time complexity and space complexity over the number of instructions. String parsing and matching operators can be tedious, but the puzzle is relatively straightforward.

#### Day 9 - [Stream Processing](http://adventofcode.com/2017/day/9)
I wrote a function that simultaneously filters out, and counts the number of garbage characters removed. If this isn't a better example of a needing a function with multiple return values, I don't know what is! I passed in a StringBuilder reference as a quick workaround. This solves part 2!
Then, my part 1 function simply steps into and out of the brackets, keeping track of the current depth of the bracket tree, and keeping a tally of the depths once each bracket is closed. Both solutions run in linear time and space.

#### Day 10 - [Knot Hash](http://adventofcode.com/2017/day/10)
Follow the instructions given carefully, and transcribe the step-by-step directions into actual code! It was interesting to implement a type of hash. However, I like being challenged and today's puzzle doesn't require much problem solving :c

#### Day 11 - [Hex Ed](http://adventofcode.com/2017/day/11)
This problem was pretty fun. An observation is made that any set of moves reduces to a combination of a number of north moves, and a number of northwest moves. South is represented as a _negative_ north move, and southwest is represented as a negative north move, plus a northwest move.
After writing a O(1) distance function that takes parameters _n_ and _nw_ and returns the distance, both parts can be calculated easily.

#### Day 12 - [Digital Plumber](http://adventofcode.com/2017/day/12)
I used a map to store the graph represented by the pipes, and performed a simple depth-first search on the zeroth program to solve part 1. Passing along a reference to a hash set holding previously visited programs prevents double counting. Part 2 involves applying the part 1 function, on all other root nodes, whilst re-using the same hash set. Any distinct groups will return with size > 0.

#### Day 13 - [Packet Scanners](http://adventofcode.com/2017/day/13)
I solved the first part by iterating over the layers, using modulo to calculate if the scanner catches us, and summing up the severity. This takes O(n) time, given n layers. The second part attempts delays with the part 1 function until we find a winner. This runs nearly instantly due to our small input.

#### Day 14 - [Disk Defragmentation](http://adventofcode.com/2017/day/14)
For part 1, construct the grid as specified and count the number of used cells. The knot hash function from Day 10 comes in handy. Next, implement the flood-fill algorithm on each cell in the grid. Count and return the number of successful fills for the second half of the problem. The flood fill algorithm should take O(n * n) time, where n is the size of the grid (128 in this case).

#### Day 15 - [Dueling Generators](http://adventofcode.com/2017/day/15)
I transcribed the description of the generators into code modelling their behavior. Using a bitmask helps isolate the lowest 16 bits easily. This runs quickly and is simple. In most cases, a do-while loop in a language like Java can be written more clearly as a while loop, but I'd argue part 2's generation function is an exception.
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

I built a tree data structure. The first part involves an algorithm to find the root of the tree -- simply follow the parent back from any node. This takes O(n) time, given n nodes.
The second part was a recursive solution. The idea is to find the first set of children with opposing sums of weights, always checking children before parents.

Unfortunately, there is an edge case in the problem where the solution is ambiguous. An example is
```$xslt
left (10)
right (20)
root (30) -> left, right
```
In this list, exactly one program is the wrong weight. But it is either left or right, and there is no way to determine which. Luckily, this doesn't appear in my input!
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
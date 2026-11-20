import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode Easy Problems 20 to 50: Java Solutions
 * Beginner-friendly solutions using only variables, conditions, loops, Strings, and arrays.
 */
public class LeetCodeSolutions20To50 {

    // 20. To Lower Case
    // Idea: Go through every character. If it is a capital letter (A to Z), add 32 to its ASCII value to make it small.
    public static String toLowerCase(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 32); // 'A' is 65, 'a' is 97, difference is 32
            }
            result = result + c;
        }
        return result;
    }

    // 21. Running Sum of 1d Array
    // Idea: Keep adding the previous answer to the current number. Each position holds the sum of everything up to it.
    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }

    // 22. Richest Customer Wealth
    // Idea: Each row is one customer. Add up each row and remember the biggest total.
    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    // 23. Find Numbers with Even Number of Digits
    // Idea: For each number, count its digits by dividing by 10 until it becomes 0. If the count is even, add one to the answer.
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int digits = 0;
            while (n > 0) {
                digits++;
                n = n / 10;
            }
            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // 24. Number of Good Pairs
    // Idea: Compare every number with every number after it (nested loops). Count the pairs that are equal.
    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // 25. Kids With the Greatest Number of Candies
    // Idea: Find the biggest candy count first. A kid can be the greatest if their candies plus extra candies reach that biggest count.
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }

    // 26. Shuffle the Array
    // Idea: The first half is x values and the second half is y values. Place x1, y1, x2, y2 ... one after the other.
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];         // x goes to even positions
            result[2 * i + 1] = nums[i + n]; // y goes to odd positions
        }
        return result;
    }

    // 27. Concatenation of Array
    // Idea: Make an array of double length. Copy the original twice: once at the start and once after it.
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[i];
            result[i + n] = nums[i];
        }
        return result;
    }

    // 28. Build Array from Permutation
    // Idea: For every index i, the answer is nums[nums[i]]. The value at i is used as an index.
    public static int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }

    // 29. Find the Highest Altitude
    // Idea: Start at altitude 0. Add each gain to the current altitude and remember the highest value seen.
    public static int largestAltitude(int[] gain) {
        int current = 0;
        int highest = 0;
        for (int i = 0; i < gain.length; i++) {
            current = current + gain[i];
            if (current > highest) {
                highest = current;
            }
        }
        return highest;
    }

    // 30. Find Pivot Index
    // Idea: Find the total sum first. At each index, right sum = total - left sum - current number.
    public static int pivotIndex(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = total - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1; // no pivot found
    }

    // 31. Plus One
    // Idea: Start from the last digit. If less than 9, add 1 and stop. If 9, set to 0 and carry. If all 9s, create a larger array.
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // 9 becomes 0 and we carry 1
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;     // all digits were 9, e.g. 99 -> 100
        return result;
    }

    // 32. Remove Element
    // Idea: Use a position k for the next good place. Copy every number that is not val to position k.
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    // 33. Move Zeroes
    // Idea: First move all non-zero numbers to the front, keeping their order. Then fill the remaining positions with 0.
    public static void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 34. Find the Difference of Two Arrays
    // Idea: For each array, collect numbers that are not in the other array. Skip numbers already added so there are no repeats.
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!contains(nums2, nums1[i]) && !first.contains(nums1[i])) {
                first.add(nums1[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (!contains(nums1, nums2[i]) && !second.contains(nums2[i])) {
                second.add(nums2[i]);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(first);
        result.add(second);
        return result;
    }

    // Helper for Problem 34: is x present in the array?
    private static boolean contains(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return true;
            }
        }
        return false;
    }

    // 35. Maximum Number of Words Found in Sentences
    // Idea: Words are separated by single spaces, so words = spaces + 1. Count spaces in each sentence and keep the maximum.
    public static int mostWordsFound(String[] sentences) {
        int max = 0;
        for (int i = 0; i < sentences.length; i++) {
            int words = 1;
            for (int j = 0; j < sentences[i].length(); j++) {
                if (sentences[i].charAt(j) == ' ') {
                    words++;
                }
            }
            if (words > max) {
                max = words;
            }
        }
        return max;
    }

    // 36. Two Sum (nested-loop solution)
    // Idea: Try every pair of numbers. When two numbers add up to the target, return their indexes.
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    // 37. Best Time to Buy and Sell Stock
    // Idea: Walk through the prices. Remember the lowest price so far. Check profit if sold today and keep the best.
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int bestProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]; // cheaper day to buy
            } else if (prices[i] - minPrice > bestProfit) {
                bestProfit = prices[i] - minPrice;
            }
        }
        return bestProfit;
    }

    // 38. Maximum Subarray (basic approach)
    // Idea: Keep a running sum. If the running sum becomes negative, restart from the next number. Remember the biggest sum seen.
    public static int maxSubArray(int[] nums) {
        int current = nums[0];
        int best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (current < 0) {
                current = nums[i]; // drop the negative part
            } else {
                current = current + nums[i];
            }
            if (current > best) {
                best = current;
            }
        }
        return best;
    }

    // 39. Find Smallest Letter Greater Than Target
    // Idea: Letters are sorted. The first letter bigger than the target is the answer. If none is bigger, wrap around to the first letter.
    public static char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                return letters[i];
            }
        }
        return letters[0];
    }

    // 40. Height Checker
    // Idea: Copy the array and sort the copy. Count the positions where the original and sorted arrays differ.
    public static int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        Arrays.sort(sorted);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sorted[i]) {
                count++;
            }
        }
        return count;
    }

    // 41. Assign Cookies
    // Idea: Sort kids' greed and cookie sizes. Give each cookie to the least greedy kid it can satisfy.
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        for (int cookie = 0; cookie < s.length && child < g.length; cookie++) {
            if (s[cookie] >= g[child]) {
                child++; // this child is happy
            }
        }
        return child;
    }

    // 42. Can Make Arithmetic Progression From Sequence
    // Idea: Sort the array. Compare every gap between neighbours with the first gap.
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }

    // 43. Average Salary Excluding the Minimum and Maximum Salary
    // Idea: Find the sum, smallest, and biggest in one loop. Subtract min and max from sum and divide by (count - 2).
    public static double average(int[] salary) {
        int min = salary[0];
        int max = salary[0];
        double sum = 0;
        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            if (salary[i] < min) {
                min = salary[i];
            }
            if (salary[i] > max) {
                max = salary[i];
            }
        }
        return (sum - min - max) / (salary.length - 2);
    }

    // 44. Find the Distance Value Between Two Arrays
    // Idea: For each number in arr1, check against every number in arr2. If none is within distance d, count it.
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean ok = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    ok = false; // too close, do not count
                    break;
                }
            }
            if (ok) {
                count++;
            }
        }
        return count;
    }

    // 45. Count Items Matching a Rule
    // Idea: Each item is [type, color, name]. Pick the column (0, 1, or 2) from ruleKey and count matches with ruleValue.
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0; // type
        if (ruleKey.equals("color")) {
            index = 1;
        } else if (ruleKey.equals("name")) {
            index = 2;
        }
        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).get(index).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }

    // 46. Search a 2D Matrix II (simple nested-loop approach)
    // Idea: Check every cell one by one with two loops. If a cell equals the target, return true.
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // 47. Transpose Matrix
    // Idea: Rows become columns. The number at (i, j) goes to (j, i) of a new matrix with swapped dimensions.
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    // 48. Matrix Diagonal Sum
    // Idea: Add the main diagonal (i, i) and anti-diagonal (i, n-1-i). If n is odd, subtract the centre cell once.
    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - 1 - i];
        }
        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2]; // centre counted twice
        }
        return sum;
    }

    // 49. Lucky Numbers in a Matrix
    // Idea: A lucky number is the smallest in its row and biggest in its column.
    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int minCol = 0; // column of the row minimum
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < matrix[i][minCol]) {
                    minCol = j;
                }
            }
            boolean isMaxInColumn = true;
            for (int r = 0; r < matrix.length; r++) {
                if (matrix[r][minCol] > matrix[i][minCol]) {
                    isMaxInColumn = false;
                }
            }
            if (isMaxInColumn) {
                result.add(matrix[i][minCol]);
            }
        }
        return result;
    }

    // 50. Count Negative Numbers in a Sorted Matrix (simple nested-loop approach)
    // Idea: Check every cell with two loops and count the ones less than 0.
    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // Main method to test all solutions (Problems 20 to 50)
    public static void main(String[] args) {
        System.out.println("20. To Lower Case: " + toLowerCase("Hello"));
        System.out.println("21. Running Sum: " + Arrays.toString(runningSum(new int[] { 1, 2, 3, 4 })));
        System.out.println("22. Richest Customer Wealth: " + maximumWealth(new int[][] { { 1, 2, 3 }, { 3, 2, 1 } }));
        System.out.println("23. Even Number of Digits: " + findNumbers(new int[] { 12, 345, 2, 6, 7896 }));
        System.out.println("24. Number of Good Pairs: " + numIdenticalPairs(new int[] { 1, 2, 3, 1, 1, 3 }));
        System.out.println("25. Kids With Candies: " + kidsWithCandies(new int[] { 2, 3, 5, 1, 3 }, 3));
        System.out.println("26. Shuffle the Array: " + Arrays.toString(shuffle(new int[] { 2, 5, 1, 3, 4, 7 }, 3)));
        System.out.println("27. Concatenation of Array: " + Arrays.toString(getConcatenation(new int[] { 1, 2, 1 })));
        System.out.println("28. Build Array from Permutation: " + Arrays.toString(buildArray(new int[] { 0, 2, 1, 5, 3, 4 })));
        System.out.println("29. Highest Altitude: " + largestAltitude(new int[] { -5, 1, 5, 0, -7 }));
        System.out.println("30. Find Pivot Index: " + pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));
        System.out.println("31. Plus One: " + Arrays.toString(plusOne(new int[] { 1, 2, 9 })));

        int[] nums32 = { 3, 2, 2, 3 };
        int k32 = removeElement(nums32, 3);
        System.out.println("32. Remove Element: k = " + k32 + ", elements = " + Arrays.toString(Arrays.copyOf(nums32, k32)));

        int[] nums33 = { 0, 1, 0, 3, 12 };
        moveZeroes(nums33);
        System.out.println("33. Move Zeroes: " + Arrays.toString(nums33));

        System.out.println("34. Difference of Two Arrays: " + findDifference(new int[] { 1, 2, 3 }, new int[] { 2, 4, 6 }));
        System.out.println("35. Most Words Found: " + mostWordsFound(new String[] {
            "alice and bob love leetcode",
            "i think so too",
            "this is great thanks very much"
        }));
        System.out.println("36. Two Sum: " + Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
        System.out.println("37. Best Time to Buy and Sell Stock: " + maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println("38. Maximum Subarray: " + maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
        System.out.println("39. Next Greatest Letter: " + nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'a'));
        System.out.println("40. Height Checker: " + heightChecker(new int[] { 1, 1, 4, 2, 1, 3 }));
        System.out.println("41. Assign Cookies: " + findContentChildren(new int[] { 1, 2, 3 }, new int[] { 1, 1 }));
        System.out.println("42. Arithmetic Progression: " + canMakeArithmeticProgression(new int[] { 3, 5, 1 }));
        System.out.println("43. Average Salary: " + average(new int[] { 4000, 3000, 1000, 2000 }));
        System.out.println("44. Distance Value: " + findTheDistanceValue(new int[] { 4, 5, 8 }, new int[] { 10, 9, 1, 8 }, 2));

        List<List<String>> items45 = Arrays.asList(
            Arrays.asList("phone", "blue", "pixel"),
            Arrays.asList("computer", "silver", "lenovo"),
            Arrays.asList("phone", "gold", "iphone")
        );
        System.out.println("45. Count Matches: " + countMatches(items45, "color", "silver"));

        int[][] matrix46 = {
            { 1, 4, 7, 11, 15 },
            { 2, 5, 8, 12, 19 },
            { 3, 6, 9, 16, 22 },
            { 10, 13, 14, 17, 24 },
            { 18, 21, 23, 26, 30 }
        };
        System.out.println("46. Search 2D Matrix II: " + searchMatrix(matrix46, 5));
        System.out.println("47. Transpose Matrix: " + Arrays.deepToString(transpose(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } })));
        System.out.println("48. Matrix Diagonal Sum: " + diagonalSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
        System.out.println("49. Lucky Numbers: " + luckyNumbers(new int[][] { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } }));
        System.out.println("50. Count Negatives: " + countNegatives(new int[][] {
            { 4, 3, 2, -1 },
            { 3, 2, 1, -1 },
            { 1, 1, -1, -2 },
            { -1, -1, -2, -3 }
        }));
    }
}

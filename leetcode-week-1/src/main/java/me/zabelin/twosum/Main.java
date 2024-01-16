package me.zabelin.twosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */

/*
bruteforce - O(n^2)
my - O(n*lng(n))
 */
public class Main {
    public static void main(String[] args) {
//        var res  = twoSum(new int[] {2,7,11,15}, 9);
        //var res  = twoSum(new int[] {3, 2, 4}, 6);
        var res  = twoSum(new int[] {3,3}, 6);
        System.out.println(Arrays.toString(res));
    }

    static class Pair<V, P> {
        private V value;
        private P pos;

        public Pair(V value, P pos) {
            this.value = value;
            this.pos = pos;
        }

    }

    static public int[] twoSum(int[] nums, int target) {
        var resNums = new ArrayList<Pair<Integer, Integer>>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            resNums.add(new Pair<>(nums[i], i));
        }
        resNums.sort(Comparator.comparingInt(p -> p.value));

        var resNum1 = -1;
        var resNum2 = -1;
        for (int i = 0; i < resNums.size() - 1; i++) {
            var potentialNum2 = new Pair<>(target - resNums.get(i).value, -1);
            var rightPartArray = resNums.subList(i+1, resNums.size());
            int pos = Collections.binarySearch(rightPartArray, potentialNum2, Comparator.comparingInt(p -> p.value));
            if (pos >= 0) {
                resNum1 = resNums.get(i).pos;
                resNum2 = rightPartArray.get(pos).pos;
                break;
            }
        }

        return new int[] {resNum1, resNum2};
    }
}
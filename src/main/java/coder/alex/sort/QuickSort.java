package coder.alex.sort;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Random;


/**
 * leetcode : https://leetcode.cn/problems/sort-an-array/description/
 */
public class QuickSort {

  public static void sort(int[] nums) {
    qSort(nums, 0, nums.length - 1);
  }

  public static void qSort(int[] nums, int L, int R) {
    if (R <= L) {
      return;
    }
    Pair<Integer, Integer> mid = partition(nums, L, R);
    qSort(nums, L, mid.getKey() - 1);
    qSort(nums, mid.getValue(), R);
  }

  /**
   * 比中轴大的移到尾端，比中轴小的移到中轴之前，中轴和i之间始终保持等于中轴的数据
   * @param nums
   * @param L
   * @param R
   * @return
   */
  public static Pair<Integer, Integer> partition(int[] nums, int L, int R) {
    int pivot = L + new Random().nextInt(R - L + 1);
    int x = nums[pivot];
    swap(nums, pivot, R);
    int less = L;
    int more = R;
    for (int i = L; i < more;) {
      if (nums[i] < x) {
        swap(nums, i, less);
        less++;
        i++;
      } else if(nums[i] == x) {
        i++;
      } else {
        more --;
        swap(nums, i, more);
      }
    }
    swap(nums, more, R);
    return new Pair<>(less, more);
  }

  public static void swap(int[] nums, int i, int p) {
    if (i != p) {
      int c = nums[p];
      nums[p] = nums[i];
      nums[i] = c;
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{9, 7, 5, 4, 6};
    QuickSort.sort(nums);
    System.out.println(Arrays.toString(nums));
  }
}

package coder.alex.sort;

import java.util.Arrays;

/**
 * leetcode : https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/submissions/
 */

public class MergeSort {

  public void sort(int[] nums) {
    int[] ret = mergeSort(nums, 0, nums.length - 1);
    for (int i = 0; i < nums.length; i++) {
      nums[i] = ret[i];
    }
  }

  public int[] mergeSort(int[] nums, int L, int R) {
    if (R == L) {
      return new int[]{nums[L]};
    } else if (R < L) {
      return new int[]{};
    }

    int mid = L + (R - L) / 2;
    int[] left = mergeSort(nums, L, mid);
    int[] right = mergeSort(nums, mid + 1, R);

    int ll = 0, rr = 0, i = 0;
    int[] ret = new int[left.length + right.length];
    while (ll < left.length || rr < right.length) {
      if (ll == left.length) {
        ret[i++] = right[rr++];
        continue;
      }

      if (rr == right.length) {
        ret[i++] = left[ll++];
        continue;
      }

      if (left[ll] <= right[rr]) {
        ret[i++] = left[ll++];
      } else {
        ret[i++] = right[rr++];
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    int[] nums = {9, 5, 6, 4, 7};
    new MergeSort().sort(nums);
    System.out.println(Arrays.toString(nums));
  }
}

package coder.alex.search;

public class BinarySearch {


  boolean check() {
    return false || true;
  }

  int LL = -1; // 下界
  int RR = 99999;  // 上界

  // 最大化答案
  int findLargest() {
    int l = LL - 1;
    int r = RR  + 1;
    while(l + 1 < r) {
      int mid = (l + r) >> 1;
      if(check()) l = mid;
      else r = mid;
    }
    return l;
  }


  // 最小化答案
  int findSmallest() {
    int l = LL - 1;
    int r = RR + 1;
    while(l + 1 < r) {
      int mid = (l + r) >> 1;
      if(check()) r = mid;
      else l = mid;
    }
  }
  return r;
}

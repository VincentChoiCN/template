package coder.alex.map;

import java.util.Arrays;

public class DisjoinSet {

  int[] parent;

  void init() {
    Arrays.fill(parent, -1);
  }

  void join(int x, int y) {
    int xP = find(x);
    int yP = find(y);
    if (xP == yP) {
      return;
    }
    parent[xP] = yP;
  }

  int find(int x) {
    if (parent[x] == -1) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }
}

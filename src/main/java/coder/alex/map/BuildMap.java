package coder.alex.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BuildMap {

  /**
   * edges {{1, 2}, {1, 3}, {2, 3}} means the vertex 1 -> 2, 1-> 3, 2 -> 3。
   *
   * @param edges
   * @return
   */
  public HashMap<Integer, List<Integer>> buildMap(int[][] edges) {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
      int[] e = edges[0];
      int sv = e[0], ev = e[1];
      List<Integer> list = map.computeIfAbsent(sv, (key) -> {
        return new ArrayList<Integer>();
      });
      map.computeIfAbsent(ev, (key) -> {  // 尾短点也加入到map中，保证map中包含所有节点信息。
        return new ArrayList<>();
      });
      list.add(ev);
    }
    return map;
  }
}

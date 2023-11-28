package coder.alex.map;

import sun.reflect.Reflection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologySort {

  public List<Integer> topologySort(int[][] edges) {
    List<Integer> output = new LinkedList<>();
    HashMap<Integer, Integer> inDegree = new HashMap<>();
    HashMap<Integer, List<Integer>> map = buildMap(edges, inDegree);
    Queue<Integer> q = new LinkedList<>();
    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue() == 0) {
        q.add(entry.getKey());
      }
    }

    for (int i = 0; i < q.size(); i++) {
      inDegree.remove(((LinkedList) q).get(i));
    }

    while (!q.isEmpty()) {
      int sv = q.poll();
      output.add(sv);
      for (int ev : map.get(sv)) {
        int count = inDegree.get(ev);
        if (--count == 0) {
          q.add(ev);
          inDegree.remove(ev);
        } else {
          inDegree.put(ev, count);
        }
      }
    }
    return output;
  }

  /**
   * edges {{1, 2}, {1, 3}, {2, 3}} means the vertex 1 -> 2, 1-> 3, 2 -> 3。
   *
   * @param edges
   * @return
   */
  public HashMap<Integer, List<Integer>> buildMap(int[][] edges, HashMap<Integer, Integer> inDegree) {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
      int[] e = edges[i];
      int sv = e[0], ev = e[1];
      List<Integer> list = map.computeIfAbsent(sv, (key) -> {
        return new ArrayList<Integer>();
      });
      map.computeIfAbsent(ev, (key) -> {
        return new ArrayList<>();
      });
      list.add(ev);

      int count = inDegree.getOrDefault(ev, 0);
      inDegree.put(ev, count + 1);

      if (!inDegree.containsKey(sv)) {
        inDegree.put(sv, 0);
      }
    }
    return map;
  }

  public static void main(String[] args) {
    System.out.println(Reflection.getCallerClass(1));
  }

}

package coder.alex.map;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS {

  Map<Integer, List<Integer>> map = new HashMap<>();


  public void bfs(int root) {
    Queue<Integer> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()) {
      int count = q.size();
      while(count-- > 0) {           // 增加一层内层循环，体现出按层处理，也利用统计到底执行了几步。
        int node = q.poll();
        for(int i : map.get(node)) {
          q.add(i);
        }
      }
    }
  }
}

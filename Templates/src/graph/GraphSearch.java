package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Graph {
    // 顶点数量
    private int V;
    // 边数量
    private int E;
    private Queue<Integer>[] adj;
    private boolean[] marked;

    // 初始化图
    public Graph(int n) {
        V = n;
        E = 0;
        adj = new LinkedList[V];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void add(int x, int y) {
        adj[x].offer(y);
        adj[y].offer(x);
        E++;
    }

    // 获取顶点对应的其他顶点队列
    public Queue<Integer> adj(int v) {
        return adj[v];
    }

}

public class GraphSearch {
    public static void main(String[] args) {
        Graph G = new Graph(6);
        G.add(0, 3);
        G.add(0, 1);
        G.add(1, 2);

        GraphBFS search = new GraphBFS(G, 0);
        System.out.println();

        GraphDFS search2 = new GraphDFS(G, 0);
        System.out.println();

    }
}


class GraphBFS {
    int count;
    boolean[] marked;
    Queue<Integer> queue;

    public GraphBFS(Graph G, int s) {
        marked = new boolean[G.V()];
        queue = new LinkedList<>();
        bfs(G, s);
    }

    private void bfs(Graph G, int v) {
        // 先标记顶点，标识已经搜索过
        marked[v] = true;
        // 队列中加入根元素
        queue.offer(v);

        while (!queue.isEmpty()) {
            // 取出第一个
            Integer first = queue.poll();
            // 数量增加
            count++;

            // 遍历first的邻接表 w为邻接表的第一个元素，然后是第二个 直到遍历完毕
            for (Integer w : G.adj(first)) {
                // 若w没有被搜索过
                if (!marked[w]) {
                    // 添加进队列
                    queue.offer(w);
                    // 标记
                    marked[w] = true;
                }
            }
            // 顺便打印出元素遍历的顺序
            System.out.print(first + ",");
        }

    }

    // 返回被搜索过的顶点标记
    public boolean marked(int s) {
        return marked[s];
    }

    // 获取相连的数量
    public int getCount() {
        return count;
    }
}

class GraphDFS {
    int count;
    boolean[] marked;
    Deque<Integer> stack;

    public GraphDFS(Graph G, int s) {
        marked = new boolean[G.V()];
        stack = new ArrayDeque<>();
        dfs(G, s);
    }

    private void dfs(Graph G, int s) {
        // 标记为搜索
        marked[s] = true;
        // 顶点加入栈中
        stack.push(s);
        while (!stack.isEmpty()) {
            // 弹出第一个元素
            Integer first = stack.pop();
            // 相连数量++
            count++;
            // 遍历first的邻接表 w为邻接表的第一个元素，然后是第二个 直到遍历完毕
            for (Integer w : G.adj(first)) {
                // 若w没有被搜索过
                if (!marked[w]) {
                    // 添加进队列
                    stack.push(w);
                    // 标记
                    marked[w] = true;
                }
            }
            // 顺便打印出元素遍历的顺序
            System.out.print(first + ",");
        }
    }
}

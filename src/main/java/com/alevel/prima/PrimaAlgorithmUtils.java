package com.alevel.prima;

import static java.lang.Math.min;
import static java.util.Arrays.fill;

public class PrimaAlgorithmUtils {

    private static final int INF = Integer.MAX_VALUE;

    int mstPrim (int[][] graph) {

        if(graph.length < 1 || (graph.length != graph[0].length)) {
            return 0;
        }

        int vNum = graph.length;
        boolean[] used = new boolean[vNum];                          // массив использованного множества вершин
        int[] dist = new int[vNum];                                  // массив расстояния. dist[v] = вес_ребра(MST, v)

        fill(dist, INF);                                             // устанаавливаем начальное расстояние до всех вершин INF
        dist[0] = 0;                                                 // для начальной вершины положим 0

        for (; ; ) {
            int v = -1;
            for (int nv = 0; nv < vNum; nv++)                        // перебираем вершины
                if (!used[nv] && dist[nv] < INF
                        && (v == -1 || dist[v] > dist[nv]))          // выбираем самую близкую непомеченную вершину
                    v = nv;
            if (v == -1)
                break;                                               // ближайшая вершина не найдена
            used[v] = true;                                          // помечаем ее
            for (int nv = 0; nv < vNum; nv++)
                if (!used[nv] && graph[v][nv] < INF)                 // для всех непомеченных смежных
                    dist[nv] = min(dist[nv], graph[v][nv]);          // улучшаем оценку расстояния (релаксация)
        }
        int ret = 0;                                                 // вес MST
        for (int v = 0; v < vNum; v++)
            ret += dist[v];
        return ret;
    }
}

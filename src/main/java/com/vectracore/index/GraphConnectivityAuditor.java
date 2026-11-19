package com.vectracore.index;

import java.util.*;

/**
 * Audits graph connectivity across HNSW layer topologies to detect disconnected components.
 */
public class GraphConnectivityAuditor {
    public static boolean isFullyConnected(Map<Integer, List<Integer>> adjacencyList) {
        if (adjacencyList == null || adjacencyList.isEmpty()) {
            return true;
        }
        Set<Integer> visited = new HashSet<>();
        Integer startNode = adjacencyList.keySet().iterator().next();

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            List<Integer> neighbors = adjacencyList.getOrDefault(curr, Collections.emptyList());
            for (Integer n : neighbors) {
                if (visited.add(n)) {
                    queue.add(n);
                }
            }
        }

        return visited.size() == adjacencyList.size();
    }
}

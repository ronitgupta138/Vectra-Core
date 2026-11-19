package com.vectracore.index;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class GraphConnectivityAuditorTest {
    @Test
    void testConnectedGraph() {
        Map<Integer, List<Integer>> graph = Map.of(
            1, List.of(2),
            2, List.of(1, 3),
            3, List.of(2)
        );
        assertTrue(GraphConnectivityAuditor.isFullyConnected(graph));
    }

    @Test
    void testDisconnectedGraph() {
        Map<Integer, List<Integer>> graph = Map.of(
            1, List.of(2),
            2, List.of(1),
            3, List.of() // Isolated node
        );
        assertFalse(GraphConnectivityAuditor.isFullyConnected(graph));
    }
}

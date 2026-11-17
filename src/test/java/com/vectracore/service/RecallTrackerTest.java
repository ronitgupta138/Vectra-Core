package com.vectracore.service;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RecallTrackerTest {
    @Test
    void testPerfectRecall() {
        List<String> list = List.of("id_1", "id_2", "id_3");
        double recall = RecallTracker.computeRecallAtK(list, list, 3);
        assertEquals(1.0, recall, 1e-6);
    }

    @Test
    void testPartialRecall() {
        List<String> approx = List.of("id_1", "id_4", "id_3");
        List<String> truth = List.of("id_1", "id_2", "id_3");
        double recall = RecallTracker.computeRecallAtK(approx, truth, 3);
        // 2 matches out of 3 = 0.6667
        assertEquals(2.0 / 3.0, recall, 1e-4);
    }
}

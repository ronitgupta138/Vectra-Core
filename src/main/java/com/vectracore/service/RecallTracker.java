package com.vectracore.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Metric tracker measuring Recall@K between approximate search results and exact ground truth.
 */
public class RecallTracker {
    public static double computeRecallAtK(List<String> approximateIds, List<String> groundTruthIds, int k) {
        if (approximateIds == null || groundTruthIds == null || k <= 0) {
            return 0.0;
        }
        Set<String> groundTruthSet = new HashSet<>(groundTruthIds.subList(0, Math.min(k, groundTruthIds.size())));
        int matches = 0;
        for (int i = 0; i < Math.min(k, approximateIds.size()); i++) {
            if (groundTruthSet.contains(approximateIds.get(i))) {
                matches++;
            }
        }
        return matches / (double) groundTruthSet.size();
    }
}

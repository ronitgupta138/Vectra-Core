package com.vectracore.filter;

/**
 * Calculates predicate selectivity ratio and decides between pre-filtering and post-filtering.
 */
public class BitsetSelectivityEstimator {
    public static final double PRE_FILTER_THRESHOLD = 0.65; // Switch to post-filter when selectivity > 65%

    public static double calculateSelectivity(long matchedCount, long totalCount) {
        if (totalCount <= 0) return 0.0;
        return matchedCount / (double) totalCount;
    }

    public static boolean shouldPreFilter(long matchedCount, long totalCount) {
        return calculateSelectivity(matchedCount, totalCount) <= PRE_FILTER_THRESHOLD;
    }
}

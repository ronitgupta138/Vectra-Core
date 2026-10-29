# Vector Search Prometheus Metrics

## Overview
Architectural specification and design document for the **Vectra-Core** high-performance Java 21 Loom backend engine.

## Engineering Details
Histogram buckets for search latency, visited nodes per query, and cache hit ratios.

## Performance Invariants
- Virtual Threads concurrency scaling (`Thread.ofVirtual().start(...)`).
- Zero locks on hot read/query paths (lock-free / CAS / read-copy-update semantics).
- Predictable GC behavior with off-heap or compact memory layout.

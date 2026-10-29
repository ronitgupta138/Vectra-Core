# Index Build Time for 1M Vectors

## Overview
Architectural specification and design document for the **Vectra-Core** high-performance Java 21 Loom backend engine.

## Engineering Details
Parallel batch index construction completing 1,000,000 128-dim vectors in under 85 seconds.

## Performance Invariants
- Virtual Threads concurrency scaling (`Thread.ofVirtual().start(...)`).
- Zero locks on hot read/query paths (lock-free / CAS / read-copy-update semantics).
- Predictable GC behavior with off-heap or compact memory layout.

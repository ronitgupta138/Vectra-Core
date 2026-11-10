# Java 21 Loom Virtual Thread Invariants for Vectra-Core

## 1. Concurrency Model
- Vectra-Core uses Java 21 Project Loom virtual threads (`Thread.ofVirtual()`) to handle concurrent vector ingestion and query streams.
- Replaces heavyweight thread pools with lightweight, cooperative fibers mounted onto standard ForkJoin carrier threads.

## 2. Invariants & Pinning Avoidance
- **Zero Synchronized Blocks:** Avoids `synchronized` keywords on hot execution paths to prevent carrier thread pinning; uses `ReentrantLock` and atomic `VarHandle` structures.
- **Thread-Local Allocation:** Per-thread Euclidean/Cosine scratch buffers allocated via scoped values to prevent GC churn during high-frequency searches.

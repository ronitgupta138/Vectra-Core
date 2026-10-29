# Hierarchical Graph Layer Construction

## Overview
Architectural specification and design document for the **Vectra-Core** high-performance Java 21 Loom backend engine.

## Engineering Details
Multi-layer skip-list graph hierarchy with exponentially decaying probability parameter mL = 1/ln(M).

## Performance Invariants
- Virtual Threads concurrency scaling (`Thread.ofVirtual().start(...)`).
- Zero locks on hot read/query paths (lock-free / CAS / read-copy-update semantics).
- Predictable GC behavior with off-heap or compact memory layout.

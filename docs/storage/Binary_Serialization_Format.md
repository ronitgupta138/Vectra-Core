# Binary Serialization Format Specification

## Overview
Architectural specification and design document for the **Vectra-Core** high-performance Java 21 Loom backend engine.

## Engineering Details
Zero-copy on-disk binary format storing collection schema, dimension count, and adjacency lists.

## Performance Invariants
- Virtual Threads concurrency scaling (`Thread.ofVirtual().start(...)`).
- Zero locks on hot read/query paths (lock-free / CAS / read-copy-update semantics).
- Predictable GC behavior with off-heap or compact memory layout.

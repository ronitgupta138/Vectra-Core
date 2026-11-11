# Zero-Copy Vector Deserialization with Java 21 MemorySegment

## 1. Mechanism
- Vectors read directly from memory-mapped file channels into `java.lang.foreign.MemorySegment`.
- JVM Vector API loads floating point registers directly from off-heap memory, bypassing byte array allocations.

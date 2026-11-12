# Memory-Mapped Append-Only Write-Ahead Log (WAL) Specification

## 1. Durability Guarantees
Every vector insertion and index modification is persisted to an append-only Write-Ahead Log prior to HNSW in-memory graph mutation.

## 2. Memory-Mapped File Architecture
- Implemented via Java `FileChannel.map(MapMode.READ_WRITE, 0, capacity)` and `MemorySegment`.
- **Group Commit:** Thread writes are coalesced into 64KB log batches before executing `force()` sync, maximizing sequential SSD write bandwidth.

## 3. Crash Recovery Protocol
On service restart, Vectra-Core replays uncommitted WAL segment entries, restoring index state with zero vector data loss.

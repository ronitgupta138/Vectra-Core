# Vectra Memory File (VMF) Binary Index Specification

## 1. File Layout
- **Magic:** 4 bytes `0x564D4631` ("VMF1").
- **Header:** Vector dimensionality ($d$), element count ($N$), metric type ($L_2$/Cosine/IP), and max layer ($L_{\max}$).
- **Graph Segments:** Page-aligned contiguous arrays of node adjacency lists directly mappable via `FileChannel.map()`.

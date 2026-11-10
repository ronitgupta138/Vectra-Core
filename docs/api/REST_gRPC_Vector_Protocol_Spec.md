# REST & gRPC Vector Index Protocol Specifications

## 1. gRPC Service Definition
```protobuf
syntax = "proto3";
package vectra;

service VectorSearchService {
    rpc QuerySimilar(QueryRequest) returns (QueryResponse);
    rpc UpsertBatch(UpsertRequest) returns (UpsertResponse);
}
```
Binary Protobuf transport delivers sub-1.8ms network roundtrips.

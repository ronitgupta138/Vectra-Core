# gRPC Bidirectional Streaming Vector Ingestion Specification

## 1. Protocol Definition
High-throughput vector indexing utilizes bidirectional gRPC streaming over HTTP/2:

```protobuf
syntax = "proto3";
service VectorService {
    rpc StreamInsert (stream InsertRequest) returns (stream InsertResponse);
}
message InsertRequest {
    string id = 1;
    repeated float vector = 2;
    map<string, string> metadata = 3;
}
```

## 2. Flow Control & Backpressure
Client flow control respects gRPC window sizes. If in-memory indexing buffers reach 80% capacity, flow control signals throttle client transmission.

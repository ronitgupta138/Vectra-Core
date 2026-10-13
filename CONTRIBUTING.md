# Contributing to Vectra Core

Thank you for your interest in contributing to **Vectra Core**! We welcome contributions to in-memory HNSW graph indexing, SIMD vector math distance metrics, 8-bit scalar quantization (SQ8), and high-throughput query pipelines.

---

## 🛠️ Development Workflow

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/ronitgupta138/vectra-core.git
   cd vectra-core
   ```

2. **Branching Conventions**:
   - `feat/<feature-name>`: New vector indexing features or distance metrics
   - `fix/<bug-name>`: Algorithmic or concurrency bug fixes
   - `perf/<optimization>`: SIMD vectorization or memory quantization improvements
   - `docs/<doc-topic>`: Architecture and documentation updates
   - `test/<test-suite>`: Unit, recall accuracy, or latency benchmark additions

3. **Running Builds & Tests**:
   Ensure all tests pass before submitting changes:
   ```bash
   mvn clean test
   ```

4. **Running Recall & Throughput Benchmarks**:
   ```bash
   mvn test -Dtest=VectorEngineBenchmarkTest
   ```

---

## 📝 Pull Request Guidelines

- **Commit Message Format**: Follow conventional commits (`feat:`, `fix:`, `perf:`, `docs:`, `test:`).
- **Zero-Latency Invariant**: Modifications to inner-loop distance metrics (Cosine, L2, Dot Product) must not regress sub-millisecond p50 query latencies.
- **Recall Target**: Indexing optimizations must maintain ≥ 98% Recall@10 against baseline Euclidean test fixtures.

---

## ⚖️ License
By contributing, you agree that your contributions will be licensed under the project's [MIT License](LICENSE).

package com.vectracore.collection;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class VectorMetadataTest {
    @Test
    void testMetadataMatching() {
        VectorMetadata meta = new VectorMetadata(Map.of("category", "books", "author", "orwell"));
        assertTrue(meta.matches("category", "books"));
        assertFalse(meta.matches("category", "movies"));
        assertFalse(meta.matches("unknown", "value"));
    }

    @Test
    void testEmptyMetadata() {
        VectorMetadata empty = VectorMetadata.empty();
        assertNull(empty.get("key"));
    }
}

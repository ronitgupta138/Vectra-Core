package com.vectracore.storage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IndexBinaryHeaderTest {
    @Test
    void testHeaderSerializationAndMagicBytes() {
        IndexBinaryHeader header = new IndexBinaryHeader(128, 10000, 4);
        byte[] bytes = header.serialize();

        assertEquals(16, bytes.length);
        assertTrue(IndexBinaryHeader.validateMagicBytes(bytes));

        byte[] invalid = new byte[]{0, 0, 0, 0};
        assertFalse(IndexBinaryHeader.validateMagicBytes(invalid));
    }
}

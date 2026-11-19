package com.vectracore.storage;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Binary serialization header for Vectra index files.
 */
public class IndexBinaryHeader implements Serializable {
    public static final byte[] MAGIC_BYTES = new byte[]{'V', 'E', 'C', 'T'};
    public static final int CURRENT_VERSION = 1;

    private final int dimensions;
    private final int vectorCount;
    private final int maxLevel;

    public IndexBinaryHeader(int dimensions, int vectorCount, int maxLevel) {
        this.dimensions = dimensions;
        this.vectorCount = vectorCount;
        this.maxLevel = maxLevel;
    }

    public byte[] serialize() {
        ByteBuffer buf = ByteBuffer.allocate(16);
        buf.put(MAGIC_BYTES);
        buf.putShort((short) CURRENT_VERSION);
        buf.putShort((short) dimensions);
        buf.putInt(vectorCount);
        buf.putInt(maxLevel);
        return buf.array();
    }

    public static boolean validateMagicBytes(byte[] headerBytes) {
        if (headerBytes == null || headerBytes.length < 4) return false;
        return Arrays.equals(Arrays.copyOfRange(headerBytes, 0, 4), MAGIC_BYTES);
    }

    public int getDimensions() { return dimensions; }
    public int getVectorCount() { return vectorCount; }
}

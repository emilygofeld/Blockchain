package entity;

public record Block(
        String prevHash,
        String data,
        long timestamp,
        String hash,
        int nonce
) {}

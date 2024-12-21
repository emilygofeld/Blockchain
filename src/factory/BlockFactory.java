package factory;

import entity.Block;
import service.chain.BlockchainService;

public class BlockFactory {

    public static Block generateBlock(String data, String prevHash) {

        final long timestamp = System.currentTimeMillis();
        final int initialNonce = 0;

        return new Block(
                prevHash,
                data,
                timestamp,
                BlockchainService.calculateHash(
                        prevHash,
                        timestamp,
                        data,
                        initialNonce
                ),
                initialNonce
        );
    }
}

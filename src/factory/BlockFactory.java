package factory;

import di.DependencyInjection;
import entity.Block;

public class BlockFactory {

    public static Block generateBlock(String data, String prevHash) {

        final long timestamp = System.currentTimeMillis();

        return new Block(
                prevHash,
                data,
                timestamp,
                DependencyInjection.getBlockchain().calculateHash(
                        prevHash,
                        data,
                        timestamp
                )
        );
    }
}

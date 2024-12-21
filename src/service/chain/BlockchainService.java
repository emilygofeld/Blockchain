package service.chain;

import di.DependencyInjection;
import entity.Block;

import java.util.ArrayList;

public class BlockchainService {

    // function compares hashes to confirm validity
    public static Boolean isChainValid(ArrayList<Block> blockchain) {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if (!currentBlock.hash().equals(calculateHash(
                    currentBlock.prevHash(),
                    currentBlock.timestamp(),
                    currentBlock.data(),
                    currentBlock.nonce()
            ))) {
                return false;
            }

            if (!previousBlock.hash().equals(currentBlock.prevHash()))
                return false;
        }
        return true;
    }

    public static String calculateHash (
            final String previousHash,
            final long timestamp,
            final String data,
            final int nonce
    ) {
        return DependencyInjection.getHashingService().encryptHash(
                previousHash + timestamp + nonce + data
        );
    }
}



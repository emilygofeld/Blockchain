package service.mining;

import entity.Block;
import service.chain.BlockchainService;

public class MiningService {

    public static Block mineBlock(Block block, int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        int nonce = 0;
        String hash;

        do {
            nonce ++;
            hash = BlockchainService.calculateHash(
                    block.prevHash(),
                    block.timestamp(),
                    block.data(),
                    nonce
            );
        } while(!hash.substring(0, difficulty).equals(target));

        System.out.println("Block mined: " + hash);

        return new Block(block.prevHash(), block.data(), block.timestamp(), hash, nonce);
    }
}

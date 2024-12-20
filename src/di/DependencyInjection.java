package di;

import entity.Blockchain;
import hashing.HashingService;
import hashing.SHA256HashingService;

public class DependencyInjection {

    private static HashingService hashingService;
    private static Blockchain blockchain;

    public static void initialize () {
        hashingService = new SHA256HashingService();
        blockchain = new Blockchain();
    }

    public static HashingService getHashingService() { return hashingService; }

    public static Blockchain getBlockchain() { return blockchain; }
}

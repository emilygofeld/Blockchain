package di;

import service.hashing.HashingService;
import service.hashing.SHA256HashingService;
import service.mining.MiningService;

public class DependencyInjection {

    private static HashingService hashingService;
    private static MiningService miningService;

    public static void initialize () {
        hashingService = new SHA256HashingService();
        miningService = new MiningService();
    }

    public static HashingService getHashingService() { return hashingService; }

    public static MiningService getMiningService() { return miningService; }
}

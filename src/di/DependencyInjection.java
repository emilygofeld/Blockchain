package di;

import service.hashing.HashingService;
import service.hashing.SHA256HashingService;

public class DependencyInjection {

    private static HashingService hashingService;

    public static void initialize () {
        hashingService = new SHA256HashingService();
    }

    public static HashingService getHashingService() { return hashingService; }
}

package service.hashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SHA256HashingService implements HashingService {

    // function encrypts input with SHA256 algorithm to a string and returns the result.
    @Override
    public String encryptHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}

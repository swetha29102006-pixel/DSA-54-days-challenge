import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeAndDecodeTinyURL {
    private static final String BASE_HOST = "http://tinyurl.com/";
    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final Map<String, String> longToShort = new HashMap<>();
    private final Map<String, String> shortToLong = new HashMap<>();
    private final Random rand = new Random();

    private String getKey() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(CHARS.charAt(rand.nextInt(CHARS.length())));
        }
        return sb.toString();
    }
}
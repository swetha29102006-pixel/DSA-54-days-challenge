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

    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return BASE_HOST + longToShort.get(longUrl);
        }
        String key = getKey();
        while (shortToLong.containsKey(key)) {
            key = getKey();
        }
        shortToLong.put(key, longUrl);
        longToShort.put(longUrl, key);
        return BASE_HOST + key;
    }

    public String decode(String shortUrl) {
        String key = shortUrl.replace(BASE_HOST, "");
        return shortToLong.get(key);
    }

    public static void main(String[] args) {
        EncodeAndDecodeTinyURL codec = new EncodeAndDecodeTinyURL();
        String url = "https://leetcode.com/problems/design-tinyurl";
        String tiny = codec.encode(url);
        System.out.println("Encoded: " + tiny);
        System.out.println("Decoded: " + codec.decode(tiny));
    }
}
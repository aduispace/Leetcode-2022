public class Codec {
    Map<String, String> index = new HashMap<>(); // longUrl to shortUrl
    Map<String, String> revIndex = new HashMap<>(); // shortUrl to longUrl
    String charSet = "abcdefghijklmnopqrstuvwxyz01234567"; // base36 (we could also do base62)
    String hostName = "http://tinyurl.com/";
    
    private String getKey() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 6; i++) {
            // The nextInt(int n) is used to get a random number between 0(inclusive) and the number passed in this argument(n), exclusive.
            sb.append(charSet.charAt(rand.nextInt(charSet.length())));
        }
        
        return sb.toString();
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (index.containsKey(longUrl)) {
            return index.get(longUrl);
        }
        String key = getKey();
        while (revIndex.containsKey(hostName + key)) {
            key = getKey();
        }
        String shortUrl = hostName + key;
        index.put(longUrl, shortUrl);
        revIndex.put(shortUrl, longUrl);
            
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (revIndex.containsKey(shortUrl)) {
            return revIndex.get(shortUrl);
        }
        
        return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
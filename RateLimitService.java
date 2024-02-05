public class RateLimitService {
    private Map<String, Long> requestTimestamps = new HashMap<>();
    private final int requestLimit = 100;  // can be adjust as needed
    private final long timeLimitMillis = 60000;  // we set to 1 minute here

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        
        if (requestTimestamps.containsKey(userId) && 
                currentTime - requestTimestamps.get(userId) < timeLimitMillis) {
            return false;  // Rate limit is exceeded
        }

        requestTimestamps.put(userId, currentTime);
        return true;  // Request is  allowed
    }
}

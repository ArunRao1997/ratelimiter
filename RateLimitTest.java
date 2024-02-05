 //import RateLimitService
// Testing Rate Limit Service
public class RateLimitTest {
    public static void main(String[] args) {
        RateLimitService rateLimitService = new RateLimitService();
        String userId = "user123";

        for (int i = 0; i < 110; i++) {
            boolean requestAllowed = rateLimitService.allowRequest(userId);
            System.out.println("Request " + (i + 1) + ": " + (requestAllowed ? "Allowed" : "Rate Limited"));
        }
    }
}

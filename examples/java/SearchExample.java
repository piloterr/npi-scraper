// NPI Search API – Java example (Java 11+)
// Usage: PILOTERR_API_KEY=your-key java SearchExample.java
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class SearchExample {
    static String enc(String v) {
        return URLEncoder.encode(v, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws Exception {
        String query = "query=" + enc("Anthony Fauci. Also a 10-digit NPI such as 1972813608, or an NPPES search URL. With enumeration_type=NPI-2 this text is the organization name, for example Mayo Clinic. A provider-view URL is rejected here.");

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.piloterr.com/v2/npi/search?" + query))
            .header("x-api-key", System.getenv("PILOTERR_API_KEY"))
            .timeout(Duration.ofSeconds(60))
            .GET()
            .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
            .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            System.err.println("Piloterr error " + response.statusCode() + ": " + response.body());
            System.exit(1);
        }
        System.out.println(response.body());
    }
}

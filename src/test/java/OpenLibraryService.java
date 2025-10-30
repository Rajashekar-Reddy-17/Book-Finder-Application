

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class OpenLibraryService {
    
    private final HttpClient httpClient = HttpClient.newBuilder().build();
    private final Gson gson = new Gson();
    private static final String BASE_URL = "https://openlibrary.org/search.json?limit=10&q=";

    /**
     * Searches the Open Library API for books matching the query.
     * @param query The search term (book title).
     * @return A list of Book objects.
     */
    public List<Book> searchBooks(String query) throws Exception {
        
        // Encode the query for safe URL use
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        String url = BASE_URL + encodedQuery;
        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Accept", "application/json")
            .GET()
            .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            System.err.println("API Request Failed with status: " + response.statusCode());
            return Collections.emptyList();
        }

        // --- JSON Parsing Logic ---
        String jsonBody = response.body();
        
        // Parse the top-level JSON object
        JsonObject root = JsonParser.parseString(jsonBody).getAsJsonObject();
        
        // Check if the 'docs' array exists and is not null
        if (root.has("docs") && root.getAsJsonArray("docs") != null) {
            
            // Use Gson to map the 'docs' array of JSON objects directly to an array of Book objects
            Book[] bookArray = gson.fromJson(root.getAsJsonArray("docs"), Book[].class);
            
            // Convert the array to a List and return it
            return Arrays.asList(bookArray);
        }

        return Collections.emptyList();
    }
}

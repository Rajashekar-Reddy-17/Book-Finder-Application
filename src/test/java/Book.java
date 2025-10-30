

import com.google.gson.annotations.SerializedName;

public class Book {
    
    // The API uses 'title', so the names match
    private String title;
    
    // The API uses 'author_name', so we map it using @SerializedName
    @SerializedName("author_name")
    private String[] authorNames;
    
    // The API uses 'first_publish_year', so we map it
    @SerializedName("first_publish_year")
    private int firstPublishYear;
    
    // The API uses 'cover_i' for the cover ID
    @SerializedName("cover_i")
    private Integer coverId;

    // Default constructor is required for Gson
    public Book() {}

    // --- Getters for Access ---
    public String getTitle() {
        return title;
    }

    public String[] getAuthorNames() {
        return authorNames;
    }

    public int getFirstPublishYear() {
        return firstPublishYear;
    }

    public Integer getCoverId() {
        return coverId;
    }

    // Method to get the URL for the cover image (Medium size)
    public String getCoverImageUrl() {
        if (coverId != null && coverId > 0) {
            // Open Library Cover API URL format: /b/id/{cover_i}-{size}.jpg
            return "https://covers.openlibrary.org/b/id/" + coverId + "-M.jpg";
        }
        return "No Cover Available";
    }

    @Override
    public String toString() {
        String authors = (authorNames != null && authorNames.length > 0) 
            ? String.join(", ", authorNames) 
            : "Unknown Author";

        return String.format(
            "  **Title:** %s\n" +
            "  **Author(s):** %s\n" +
            "  **Year:** %d\n" +
            "  **Cover URL:** %s\n",
            title, authors, firstPublishYear, getCoverImageUrl()
        );
    }
}

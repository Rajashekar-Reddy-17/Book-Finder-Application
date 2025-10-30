

import java.util.List;
import java.util.Scanner;

public class BookSearchApp {

    public static void main(String[] args) {
        // Initialize the Scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Initialize the service class to handle the API logic
        OpenLibraryService service = new OpenLibraryService();

        System.out.println("==========================================");
        System.out.println("  📚 Open Library Book Search Tool (Java)  ");
        System.out.println("==========================================");
        System.out.print("\nEnter a book title to search: ");
        
        String searchTitle = scanner.nextLine();
        
        if (searchTitle.trim().isEmpty()) {
            System.out.println("Search term cannot be empty. Exiting.");
            scanner.close();
            return;
        }

        System.out.println("\nSearching for: \"" + searchTitle + "\"...");

        try {
            // Call the service to get the search results
            List<Book> results = service.searchBooks(searchTitle);
            
            System.out.println("--- Found " + results.size() + " Results ---\n");
            
            if (results.isEmpty()) {
                System.out.println("No books found for that search term.");
            } else {
                // Iterate and print each book's details
                for (int i = 0; i < results.size(); i++) {
                    System.out.println("Result #" + (i + 1));
                    System.out.println(results.get(i));
                }
            }
        } catch (Exception e) {
            System.err.println("\nAn unexpected error occurred during the search.");
            System.err.println("Error Detail: " + e.getMessage());
            // e.printStackTrace(); // Uncomment for full stack trace
        } finally {
            scanner.close();
            System.out.println("==========================================");
            System.out.println("  Application Finished. ");
            System.out.println("==========================================");
        }
    }
}



# 📚 Java Book Search Tool

A simple command-line application built with Java that interacts with the **Open Library API** to search for books by title/author, look up books by ISBN, and save favorite titles to a local reading list.

## ✨ Features

  * **Search by Title/Author:** Fetches book metadata (title, author, publication year, cover ID) from the Open Library Search API.
  * **Search by Identifier (ISBN):** Allows precise lookup of a single book using its ISBN-10 or ISBN-13.
  * **Local Reading List:** Save selected search results to a list that persists while the application is running (in memory).
  * **Book Cover URL Generation:** Generates a direct URL for fetching the book's cover image.

## 🛠️ Technology Stack

  * **Language:** Java (JDK 17+)
  * **Build Tool:** Maven
  * **API Client:** `java.net.http.HttpClient` (Standard library)
  * **JSON Processing:** **Gson** (from Google) for serializing and deserializing JSON data.
  * **External API:** [Open Library API](https://openlibrary.org/developers/api)

## 🚀 Getting Started

### Prerequisites

You need to have the following installed on your system:

  * **Java Development Kit (JDK) 17 or newer**
  * **Apache Maven** (for dependency management)

### Setup and Build

1.  **Clone the Repository:**

    ```bash
    git clone [Your Repository URL]
    cd BookSearchTool
    ```

2.  **Build the Project:**
    Use Maven to download the `Gson` dependency and compile the source code.

    ```bash
    mvn clean install
    ```

### How to Run

1.  **Execute the compiled JAR file:**

    ```bash
    java -jar target/BookSearchTool-1.0-SNAPSHOT.jar 
    # (Note: The exact JAR name may vary based on your pom.xml artifactId/version)
    ```

2.  **Run Directly from IDE:**
    You can also run the application directly from your IDE (IntelliJ, Eclipse, etc.) by executing the `main` method in the `BookSearchApp.java` file.

## 🖥️ Usage

The application presents a command-line menu for interaction:

```
==========================================
  📚 Open Library Book Search Tool (Java)  
==========================================

Select an option:
1. **Search** for a book by title/author
2. **Get** a book by ISBN
3. **View** My Books List (0 saved)
4. Exit
Enter choice (1-4): 
```

### Option 1: Search and Save

1.  Choose option **1** and enter a search query (e.g., `Lord of the Rings`).
2.  The application will display a numbered list of results.
3.  Enter the number corresponding to the book you wish to save, or `0` to skip saving.

### Option 2: Get by ISBN

1.  Choose option **2** and enter a valid ISBN (e.g., `0395082548`).
2.  If the book is found, you'll be prompted to save it to your reading list.

### Option 3: View My Books List

1.  Choose option **3** to view all the titles you have saved during the current session.

## 📂 Project Structure

| File | Description |
| :--- | :--- |
| `pom.xml` | Maven configuration, defines project dependencies (Gson). |
| `BookSearchApp.java` | The **main entry point** and controller for the command-line interface. Manages the local `myBooks` list. |
| `OpenLibraryService.java` | Handles communication with the Open Library API, including HTTP requests and **JSON parsing** for both Search and Books endpoints. |
| `Book.java` | The **data model** representing a single book, including fields mapped from the JSON response. |

## 🤝 Contributing

Contributions are welcome\! If you have suggestions for new features (like file persistence for the reading list, or a dedicated CLI for managing the list), feel free to open an issue or submit a pull request.

-----

## 📝 License

This project is open-source and available under the MIT License.


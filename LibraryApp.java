import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryDAO libraryDAO = new LibraryDAO();

        while (true) {
            System.out.println("1. View available books");
            System.out.println("2. Issue a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    List<Book> books = libraryDAO.getAllBooks();
                    System.out.println("Available Books:");
                    for (Book book : books) {
                        if (book.isAvailable()) {
                            System.out.println(book.getId() + ". " + book.getTitle());
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter book ID to issue: ");
                    int issueBookId = scanner.nextInt();
                    if (libraryDAO.issueBook(issueBookId)) {
                        System.out.println("Book issued successfully.");
                    } else {
                        System.out.println("Failed to issue the book.");
                    }
                    break;
                case 3:
                    System.out.print("Enter book ID to return: ");
                    int returnBookId = scanner.nextInt();
                    if (libraryDAO.returnBook(returnBookId)) {
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Failed to return the book.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

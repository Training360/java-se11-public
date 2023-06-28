package bookmarks.frontend;

import bookmarks.backend.BookmarksService;

import java.util.List;
import java.util.ServiceLoader;

public class BookmarksMain {

    BookmarksService bookmarksService;

    public BookmarksMain(BookmarksService bookmarksService) {
        this.bookmarksService = bookmarksService;
    }

    public static void main(String[] args) {
        var bookmarksService = getBookmarksService();
        var main = new BookmarksMain(bookmarksService);
        main.addBookmark("Home Page");
        main.addBookmark("Work Page");
        System.out.println(main.listBookmarks());
    }

    public void addBookmark(String bookmark) {
        bookmarksService.addBookmark(bookmark);
    }

    public List<String> listBookmarks() {
        return bookmarksService.listBookmarks();
    }

    private static BookmarksService getBookmarksService() {
        return ServiceLoader.load(BookmarksService.class)
                .findFirst().orElseThrow(() -> new IllegalStateException("Service not found"));
    }
}

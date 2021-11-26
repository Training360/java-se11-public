package bookmarks.frontend;

import bookmarks.backend.BookmarksService;

import java.util.ServiceLoader;

public class BookmarksMain {

    public static void main(String[] args) {
        BookmarksService bookmarksService = getBookmarksService();
        bookmarksService.addBookmark("Home Page");
        bookmarksService.addBookmark("Work Page");
        System.out.println(bookmarksService.listBookmarks());
    }

    private static BookmarksService getBookmarksService() {
        return ServiceLoader.load(BookmarksService.class)
                .findFirst().orElseThrow(() -> new IllegalStateException("Service not found"));
    }
}

import bookmarks.backend.BookmarksService;
import bookmarks.backend.impl.InMemoryBookmarksService;

module bookmarks.app.backend {
    exports bookmarks.backend;

    provides BookmarksService with InMemoryBookmarksService;
}
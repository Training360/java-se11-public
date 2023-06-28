package frontend;

import bookmarks.backend.BookmarksService;
import bookmarks.frontend.BookmarksMain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.ServiceLoader;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

//@ExtendWith(MockitoExtension.class)
class BookmarksMainTest {

//    @Mock
    BookmarksService bookmarksService;

//    @InjectMocks
    BookmarksMain bookmarksMain;

    @Test
    void add() {
        bookmarksService = Mockito.mock(BookmarksService.class);
        bookmarksMain = new BookmarksMain(bookmarksService);
        bookmarksMain.addBookmark("home");
        verify(bookmarksService).addBookmark(eq("home"));
    }
}

package bookmarks.backend.impl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryBookmarksServiceTest {

    @Test
    void testAddAndList() {
        var service = new InMemoryBookmarksService();
        service.addBookmark("http://example.com");
        assertEquals(List.of("http://example.com"), service.listBookmarks());
    }

}
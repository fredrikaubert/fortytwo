package no.parasit.fortytwo

import org.junit.Test

class RSSPictureFeedTests {
     RSSPictureFeed feed = new RSSPictureFeed()
     @Test
    void testFeed() {
        feed.getLatestPicturesFromFeed().each {
            println it
        }
    }
}

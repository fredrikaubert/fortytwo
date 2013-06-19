package no.parasit.fortytwo

class RSSPictureFeed {

    String url = "http://picasaweb.google.com/data/feed/base/all?alt=rss&kind=photo&access=public&tag=pics&filter=1&orderby=date&imgor=landscape&isvideo=false&imglic=creative_commons&face=false&imgmax=1600&hl=en_US"

    int currentIndex = 0
//    List<String> picturesUrls = []

    List<String> getLatestPicturesFromFeed() {
        def rss = new XmlSlurper().parse(url)
        println rss.channel.title
        rss.channel.item.collect {
            it.'group'.'content'.@url.text()
        }
    }


    String getNextPicture() {
        def pictures = latestPicturesFromFeed
        if(!pictures) return null
        if (!(++currentIndex < pictures.size())) {
           currentIndex = 0
        }
        return pictures[currentIndex]
    }





}

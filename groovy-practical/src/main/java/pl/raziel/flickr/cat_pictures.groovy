package pl.raziel.flickr

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.swing.SwingBuilder

import javax.swing.ImageIcon
import javax.swing.WindowConstants
import java.awt.GridLayout

String key = new File('C:\\Users\\GO2OSTA\\IdeaProjects\\Groovy\\groovy-path\\groovy-practical\\src\\main\\resources\\flickr_key.txt').text
String endPoint = 'https://api.flickr.com/services/rest?'
def params = [method        : 'flickr.photos.search',
              api_key       : key,
              format        : 'json',
              tags          : 'cat',
              nojsoncallback: 1,
              media         : 'photos',
              per_page      : 6]

// Build URL and download JSON data
def qs = params.collect { it }.join('&')
String jsonTxt = "$endPoint$qs".toURL().text

// write formatted JSON data to file
File f = new File('cats.json')
if (f) f.delete()
f << JsonOutput.prettyPrint(jsonTxt)
println JsonOutput.prettyPrint(jsonTxt)

// parse JSON data nad build URL for pictures
def json = new JsonSlurper().parseText(jsonTxt)
def photos = json.photos.photo

// build UI using SWING
new SwingBuilder().edt {
    frame(title: 'Cat pictures', visible: true, pack: true,
            defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE,
            layout: new GridLayout(0, 2, 2, 2)) {
        photos.each { p ->
            String url =
                    "http://farm${p.farm}.staticflickr.com/${p.server}/${p.id}_${p.secret}.jpg"
            String title = p.title
            label(icon: new ImageIcon(url.toURL()), toolTipText: title)
        }
    }
}
/*TODO
    get the proper key from yahoo cause you had a problem with registering in work.
 */
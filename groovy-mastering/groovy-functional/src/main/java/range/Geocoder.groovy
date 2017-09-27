package range

class Geocoder {
    public static final String BASE = 'http://maps.google.com/maps/api/geocode.xml?'

    void fillInLatLng(TrainStation station) {
        String encoded = [station.city, station.state].collect {
            URLEncoder.encode(it, 'UTF-8')
        }.join(',')
        String qs = "address=$encoded"
        println "$BASE$qs"
        def response = new XmlSlurper().parse("$BASE$qs")
        station.latitude = response.result[0].geometry.location.lat.toBigDecimal()
        station.longtitude = response.result[0].geometry.location.lat.toBigDecimal()
    }
}
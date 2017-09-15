package pl.raziel.openweather

class Model {
    Long dt
    Long id
    String name
    Integer cod

    Coordinates coord
    Main main
    System sys
    Wind wind
    Clouds clouds
    Weather[] weather

    def convertTemp(temp) {
        9 * (temp - 273.15) / 5 + 32
    }

    def convertSpeed(mps) {
        mps * 60 * 60 * 100 / 2.54 / 12 / 5280
    }

    def convertTime(t) {
        new Date(t * 1000) //Unix time in sec, Java time in ms
    }

    def getTime() { convertTime(dt) }

    def getTemperature() { convertTemp(main.temp) }

    def getLow() { Math.floor(convertTemp(main.temp_min)) }

    def getHigh() { Math.floor(convertTemp(main.temp_max)) }

    def getSunrise() { convertTime(sys.sunrise) }

    def getSunset() { convertTime(sys.sunset) }

    def getSpeed() { convertSpeed(wind.speed) }

    @Override
    String toString() {
        String result = """
        Name : $name
        Time : $time
        Location : $coord"""

        weather.each { w ->
            result += "\n    Weather     : ${w.main} (${w.description})"
        }

        result += """
        Icon: http://openwaethermap.org/img/w/${weather[0].icon}.png
        Humidity     : ${main.humidity}%
        Sunrise      : $sunrise
        Sunset       : $sunset
        Wind         : $speed mph at ${wind.deg} deg
        Cloudiness   : ${clouds.all}%
        """
        return result
    }


    class Main {
        BigDecimal temp
        BigDecimal humidity
        BigDecimal pressure
        BigDecimal temp_min
        BigDecimal temp_max
    }

    class Coordinates {
        BigDecimal lat
        BigDecimal lon

        String toString() { "($lat, $lon)" }
    }

    class Weather {
        Integer id
        String main
        String description
        String icon
    }

    class System {
        String message
        String country
        Long sunrise
        Long sunset
    }

    class Wind {
        BigDecimal speed
        BigDecimal deg
    }

    class Clouds {
        BigDecimal all
    }
}

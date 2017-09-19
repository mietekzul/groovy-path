package pl.raziel

import spock.lang.Specification
import spock.lang.Unroll

class HelloSpockSpec extends Specification {

    @Unroll
    def 'using list of pairs (#name, #length)'(String name, int length) {
        expect:
        name.size() == length

        where:
        [name, length] << [['Spock', 5], ['Kirk', 4], ['Scotty', 6]]
    }
}

package pl.raziel

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class DatabaseDrivenSpec extends Specification {
    @Shared
    Sql sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

    def setupSpec() {
        sql.execute '''
            create table maxdata (   id int primary key, a int, b int, c int)
        '''

        sql.execute("INSERT INTO maxdata VALUES (1,3,7,7), (2,5,4,5),(3,9,9,9)")
    }

    @Unroll
    def "maximum of #a and #b is #c"(int a, int b, int c) {
        expect:
        Math.max(a, b) == c

        where:
        [a, b, c] << sql.rows("SELECT a,b,c FROM maxdata")
    }
}

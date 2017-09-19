package ast.hr

import pl.raziel.hr.Employee
import pl.raziel.hr.JavaDepartment
import spock.lang.Specification

class JavaDepartmentSpec extends Specification {
    private JavaDepartment department

    def setup() {
        department = new JavaDepartment(name: 'IT')
    }

    def "add employee to department should increase total by 1"() {
        given:
        Employee fred = new Employee(name: 'Fred', id: 1)

        when:
        department + fred

        then:
        department.employees.size() == old(department.employees.size()) + 1
    }

    def "add two employees via chained plus"() {
        given:
        Employee fred = new Employee(name: 'Fred', id: 1)
        Employee barney = new Employee(name: 'Barney', id: 2)

        when:
        department = department + fred + barney

        then:
        department.employees.size() == 2
    }

    def "subtract emp from department should decrease by 1"() {
        given:
        Employee fred = new Employee(name: 'Fred', id: 1)
        department.hire fred

        when:
        department = department - fred

        then:
        department.employees.size() == old(department.employees.size()) - 1
    }

    def "remove two employees via chained minus"() {
        given:
        Employee fred = new Employee(name: 'Fred', id: 1)
        Employee barney = new Employee(name: 'Barney', id: 2)
        department.hire fred
        department.hire barney

        when:
        department = department - fred - barney

        then:
        department.employees.size() == 0
    }

    def "add employee to department via left shift should increase total by 1"() {
        given:
        Employee fred = new Employee(name: 'Fred', id: 1)

        when:
        department = department << fred

        then:
        department.employees.size() == old(department.employees.size()) + 1
    }

    def "add two employees via chained left shift"() {
        given:
        Employee fred = new Employee(name: 'Fred', id: 1)
        Employee barney = new Employee(name: 'Barney', id: 2)

        when:
        department = department << fred << barney

        then:
        department.employees.size() == 2
    }

}

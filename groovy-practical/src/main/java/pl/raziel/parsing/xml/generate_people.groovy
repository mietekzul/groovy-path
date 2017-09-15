package pl.raziel.parsing.xml

import groovy.xml.MarkupBuilder

def builder = new MarkupBuilder()
builder.people {
    person(id: 1) {
        name 'Buffy'
    }
    person(id: 7) {
        name 'Daniel'
    }
}


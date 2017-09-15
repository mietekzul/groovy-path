package pl.raziel.parsing.json

import groovy.json.JsonBuilder

def builder = new JsonBuilder()
builder([name: 'Buffy', role: 'wladca moch'], [name: 'Willow', role: 'Srillow'])

println builder

assert builder.toString() ==
        '[{"name":"Buffy","role":"wladca moch"},{"name":"Willow","role":"Srillow"}]'

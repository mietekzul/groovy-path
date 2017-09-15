package pl.raziel.parsing.json

import groovy.json.JsonSlurper

String jsonTxt = new File('C:\\Users\\GO2OSTA\\IdeaProjects\\Groovy\\groovy-path\\groovy-practical\\src\\main\\resources\\people.json').text
def json = new JsonSlurper().parseText(jsonTxt)
assert json[1].role == 'witch'
println json[0].role
package pl.raziel.parsing

def root = new XmlSlurper().parse('C:\\Users\\GO2OSTA\\IdeaProjects\\Groovy\\groovy-path\\groovy-practical\\src\\main\\resources\\people.xml')
println "The second name is ${root.person[1].name}"
println "The second name is ${root.person[1].@id}"
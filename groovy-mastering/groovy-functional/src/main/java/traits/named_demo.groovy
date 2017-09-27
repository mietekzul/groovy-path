package traits

trait Named {
    String name
}

class NamedPerson implements Named {}

def p = new NamedPerson(name: 'Bob')

println p.name
println p.getName()


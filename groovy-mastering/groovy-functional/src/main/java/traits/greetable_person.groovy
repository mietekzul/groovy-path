package traits

trait Greetable {
    abstract String name()

    String greeting() { "Hello, ${name()}!" }
}

class Person implements Greetable {

    @Override
    String name() {
        'Bob'
    }
}

Person p = new Person()
println p.greeting()

package traits

trait Extra {
    String extra() { "I'm an extra method" }
}

class Something {
    String doSomething() { 'Something' }
}

def s = new Something() as Extra
println s.doSomething()
println s.extra()

println "\nImplemented multiple traits at runtime\n"

trait T1 {
    String t1method() { 't1 method' }
}

trait T2 {
    String t2method() { 't1 method' }
}

class MyClass {}

def myClass = new MyClass()
def myClassWithTraits = myClass.withTraits(T1, T2)
println myClassWithTraits.t1method()
println myClassWithTraits.t2method()

println myClass.class.name
println myClassWithTraits.class.name
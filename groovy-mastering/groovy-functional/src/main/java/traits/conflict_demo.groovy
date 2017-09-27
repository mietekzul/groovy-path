package traits

trait A {
    String exec() { 'A' }
}

trait B {
    String exec() { 'B' }
}

class C implements A, B {}

def c = new C()
println c.exec()    // last trait wins!

class D implements A, B {
    String exec() {
        A.super.exec()
    }
}

def d = new D()
println d.exec()
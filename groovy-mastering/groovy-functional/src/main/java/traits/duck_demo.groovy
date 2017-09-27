package traits

trait Flying {
    String fly() { "I'm flying!" }
}

trait Speaking {
    String speak() { "I'm speaking!" }
}

class Duck implements Flying, Speaking{}

def d = new Duck()

println d.fly()
println d.speak()
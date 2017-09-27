package traits

trait FlyingAbility {
    String fly() { "I'm flying" }
}

class Bird implements FlyingAbility {}

Bird b = new Bird()

println b.fly()
println b instanceof FlyingAbility
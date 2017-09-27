package functional

import groovy.transform.Memoized

def add = { x, y -> sleep 1000; x + y }.memoize()

println add(3, 4)
println add(3, 4)

println add('a', 'b')
println add('a', 'b')

def fib = { n ->
    if (n < 2) 1
    else call(n - 1) + call(n - 2)
}

println fib(10)

@Memoized
long fib1(long n) {
    if (n < 2) 1
    else fib1(n - 1) + fib1(n - 2)
}

println fib1(100)
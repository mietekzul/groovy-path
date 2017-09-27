package functional

List nums = [3, 1, 4, 1, 5, 9, 2, 6, 5]
println nums.sum()
println nums.inject { a, v ->
    println "acc=$a, val=$v"
    a + v
}
println '_________________________________________'
List strings = 'this is a list of strings'.split()
List sorted = strings.sort()

sorted.inject('') { p, c ->
    println "prev=$p, current=$c"
    assert p <= c
    c
}
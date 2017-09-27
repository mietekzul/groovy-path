package functional

List nums = [3, 1, 4, 1, 5, 9, 2, 6, 5]

println nums.collect { it * 2 }.findAll { it % 3 == 0 }.sum()

List cities = ['Boston', 'New York', 'London', 'Hyderabad']

println cities.collect { it.toUpperCase() }.sort().join(', ')
package basics

x = 0
for (i in 0..30) {
    x += i
}
println x

x = 0
for (i in [10, 5, 3, 1]) {
    x += i
}
println x

array = (0..20).toArray()
x = 0
for (i in array) {
    x += i
}
println x
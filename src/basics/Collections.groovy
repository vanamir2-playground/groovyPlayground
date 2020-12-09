package basics
// ------ empty LIST
def list = []
// adding
list.add("New string")
list.add("Sounds interesting")
list << "Hell yeah"
list.addAll(["should work", "Cool"])

// removing
list.remove("Cool")
list = list - "New string"

// iterating
list.each { println "Item: $it" }
list.eachWithIndex { def it, int i -> println "$i: $it" }

println list.contains("Hell yeah")

// sorting
list.sort()
list.each { println "Item: $it" }


// -------- empty MAP
def map = [:]
// add values
map = ["a": "a", "b": "bb", "c": "ccc"]
map.each { println "$it.key : $it.value" }
map.eachWithIndex { it, i -> println "$i: $it" }
println map.keySet()
println map.values()









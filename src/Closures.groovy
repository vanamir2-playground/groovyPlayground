// http://www.groovy-lang.org/closures.html
// https://www.baeldung.com/groovy-closures


// Closure = anonymní kus kód, který je instancí třídy Closure.

// Closure as an object
def listener = { e -> println "Clicked on $e" }
assert listener instanceof Closure
Closure callback = { println 'Done!' }
Closure<Boolean> isTextFile = {
    File it -> it.name.endsWith('.txt')
}
def code = { 123 }

// calling a closure
listener("23")
callback()
assert code() == 123
assert code.call() == 123 // explicit method call

// closure with arguments
def isOdd = { int i -> i % 2 != 0 }
assert isOdd(3) == true
assert isOdd.call(2) == false


Closure test = {

    print() {
        println 'Done!'
    }
    print2() {
        println 'Hotov'
    }
}

test.call().print2()



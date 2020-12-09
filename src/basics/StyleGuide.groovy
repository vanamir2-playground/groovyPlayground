package basics
// http://www.groovy-lang.org/style-guide.html#_omitting_parentheses

// optional semicolons
println "a";
//equals
println "a"

// optional return keyword
String toString() { return "a server" }

String toString2() { "a server" }

def foo(n) {
    if (n == 1) {
        "Roshan"
    } else {
        "Dawrani"
    }
}

assert foo(1) == "Roshan"
assert foo(2) == "Dawrani"

// 4. Public by default


// 5. Omitting parentheses
println "Hello"
foo a

println("Hello")
foo(a)
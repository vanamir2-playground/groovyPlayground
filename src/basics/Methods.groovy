package basics

def method(msg = 'Hello', name = 'world!') {
    "$msg $name"
}

// 3 ways to call the a method
assert 'Hello world!' == method() // assert - to check some cinditions are met
println method("Hi")
print method("Hi", "folks")




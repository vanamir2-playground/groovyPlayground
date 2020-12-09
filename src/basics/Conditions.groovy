package basics

def test(def x) {
    if (x == 1) {
        println "one"
    } else if (x == 2) {
        println "two"
    } else {
        println "X is greater then two"
    }
}

def testWithoutBraces(def x) {
    if (x == 1)
        println "one"
    else if (x == 2)
        println "two"
    else
        println "X is greater then two"
}


def testTernary(def x) {
    x > 2 ? "more" : "less"
}

def testTernaryWithReturn(def x) {
    return x > 2 ? "more" : "less"
}

def testTernaryWithReturnChanged(def x) {
    x > 2 ? "more" : "less"
    return "Hi"
}

def elvisOperator(user) {
    user = user ?: "admin"
    //equals to
    user ? user : "Anonymous"
}

test(5)
testWithoutBraces(1)
println testTernary(1)
println testTernaryWithReturn(1)
println testTernaryWithReturnChanged(1)

println elvisOperator()


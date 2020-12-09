package basics

def a = {
    // global scope (within script)
    x = 1
    println x
}
def b = {
    x = 2
    println x
}
//new Thread(a).start()
//new Thread(b).start()
//. could produce two ones, two twos, or a mix.


def a2 = {
    def x = 1
    println x
}
def b2 = {
    def x = 2
    println x
}
new Thread(a2).start()
new Thread(b2).start()
// always print 1,2 v libovolnem poradi
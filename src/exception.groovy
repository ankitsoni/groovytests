/**
 * Created by asoni on 26-03-2015.
 */
def method(bool) {
    try {
        if (bool) throw new Exception("foo")
        println "in if"
        1
    } catch(e) {
        println "in catch"
        2
    } finally {
        println "in finally "
        3
    }
}
result=method(false)
println result
result=method(true)
println result
// 2 method dwith return
def methods(bool) {
    try {
        if (bool) throw new Exception("foo")
        println "in if"
        return 1
    } catch(e) {
        println "in catch"
        return 2
    } finally {
        println "in finally "
        return 3
    }
}
result=methods(false)
println result
result=methods(true)
println result
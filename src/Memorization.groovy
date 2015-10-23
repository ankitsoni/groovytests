/**
 * Created by asoni on 17-04-2015.
 */
closure = {param1, param2 -> sleep(100); t=param1 + param2 }

 memoizedClosure = closure.memoize()

 def testTime(param1, param2) { begin = System.currentTimeMillis()
     r=memoizedClosure(param1, param2)
     timeElapsed = System.currentTimeMillis()
     println "param1 = $param1, param2 = $param2 time :${timeElapsed - begin } ms."
     return r
      }

 e=testTime(1, 2)
 f=testTime(3, 4)
 g=testTime(1, 2)
 h=testTime(3,4)
 i=testTime(1,1)
 j=testTime(14,18)

println "e=$e f=$f g=$g h=$h i=$i j=$j"
c = {p1, p2 -> sleep(100);
    begin = System.currentTimeMillis()
    t=p1 + p2
    timeElapsed = System.currentTimeMillis()
    println "c param1 = $p1, param2 = $p2 time :${timeElapsed - begin } ms."
    return t
    }.memoize()



e=c(1, 2)
f=c(3, 4)
g=c(1, 2)
h=c(3,4)
i=c(1,1)
j=c(14,18)
println "e=$e f=$f g=$g h=$h i=$i j=$j"

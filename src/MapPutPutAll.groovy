/**
 * Created by asoni on 13-8-15.
 */


def k = [a:1,b:2,c:3]
def t = [:]
//t.put (k)  wrong
t.putAll(k)
println t

h=7
def sum = "The sum of 2 and 3 equals ${2-h}"
println sum
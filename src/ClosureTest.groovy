/**
 * Created by asoni on 06-04-2015.
 */
 def closureVar = {println 'Hello world'}
 println "closure is not called yet"
 println " "
 closureVar.call()//explicit
 closureVar()//implicit
 approach:closureVar()

 def closureVari = {param -> println "Hello ${param}"}
 closureVari.call('world')
 closureVari ('implicit world')
 approach:closureVari('wworld')

 def sayHello= {str1, str2= " default world" -> println "${str1} ${str2}" }
 sayHello("Hello", "world")
 sayHello("Hello")

 def sum = {a -> return a.sum()}
 def result=sum([2,2])
 println result
 def hello = {return  "$it May the force be with you"}
 k=hello("Änkit")
 println k
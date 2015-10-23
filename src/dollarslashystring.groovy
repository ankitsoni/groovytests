/**
 * Created by Ankit Soni on 25-03-2015.
 */

 def name = "vishal"
 def path= "c:/groovy"

 def dollarSlashy = $/
 Hello $name
 path= $path
 dollar = $$test
 path = c:/groovy
 /$

/*escaping $test with a $*/
 println dollarSlashy
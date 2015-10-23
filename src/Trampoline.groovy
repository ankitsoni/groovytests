/**
 * Created by asoni on 17-04-2015.
 */

/* def factorial                   //generates stack overflow
 factorial={n,BigInteger acc=1->
    n == 1 ? acc:
             factorial(n-1, n*acc)
     }
 factorial(1000)*/


 def factorial

 factorial={n, BigInteger acc=1->
     n == 1 ? acc:
             factorial.trampoline(n-1, n*acc)
     }.trampoline()

 println factorial(1000)
/**
 * Created by asoni on 17-04-2015.
 */

 def add= { x, y -> return x + y }
 def newAdd = add.curry(1)
 println newAdd(2)
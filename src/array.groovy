/**
 * Created by asoni on 26-03-2015.
 */
 def stringArray = new String[3]
 println stringArray.size()
 stringArray[0] = "Ankit"
 println stringArray
 stringArray[1] = "Soni"
 stringArray[2] = "MNIT"
 println stringArray
 println stringArray[1]
 stringArray.each { println it}
 println stringArray[-1..-3]

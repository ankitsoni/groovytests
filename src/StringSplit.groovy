/**
 * Created by asoni on 6-8-15.
 */
format ="\$##.#,#%"
def validList = ["#","\$",".",","]
def list=format.toCharArray().toString()
list.each {
    if (!(it in validList)){
        println it +"bad"
    }
}


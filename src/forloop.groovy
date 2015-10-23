/**
 * Created by asoni on 26-03-2015.
 */
i=0
def authors = [1:1, 2:2, 3: 3, 4:4]
for( k in authors){
    i+=k.value
    println i
}


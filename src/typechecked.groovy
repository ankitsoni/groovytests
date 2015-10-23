import groovy.transform.TypeChecked

/**
 * Created by Ankit Soni on 25-03-2015.
 */
void checkError(){
    println "Hello World"
}
@TypeChecked
void test(){
   //checkErro() //red b/c runtime typechecking
}
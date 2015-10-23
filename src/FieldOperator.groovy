/**
 * Created by asoni on 20-04-2015.
 */
class Todo {
    String name
    def getName() {
        println "Getter Name $name"
    }
}
def todo = new Todo(name: "Ankit")
println todo.name // getter is called
println "Without Getter ${todo.@name}" // direct String name is called

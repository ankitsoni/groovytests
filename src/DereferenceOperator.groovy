/**
 * Created by asoni on 20-04-2015.
 */
/*class User {                   // Gives NULL pointer exception
    String firstName
    String lastName
}
User user
println user.firstName*/


class User {
    String firstName
    String lastName
}
User user
println "Name= ${user?.firstName} ${user?.lastName}"



/**
 * Created by asoni on 23-04-2015.
 */
 def writer = new StringWriter()
 def builder = new groovy.xml.MarkupBuilder(writer)
 builder.setDoubleQuotes(true)
 builder.todos {
     todo (id:"1") {
         name "Buy Beginning Groovy Grails and Griffon"
         note "Purchase book from Amazon.com for all co-workers."
         }
    }
println writer.toString()
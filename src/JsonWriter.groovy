/**
 * Created by asoni on 23-04-2015.
 */


 import groovy.json.*
        def builder = new groovy.json.JsonBuilder()
 def root = builder.Book{
    Groovy{
        title 'Beginning Groovy, Grails and Griffon'
         Authors(
                 'Vishal',
                 'Chris',
                 'Joseph',
                 'James',
                 )
        }
     }
 println builder.toString()
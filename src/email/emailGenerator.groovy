package email

/**
 * Created by asoni on 24-04-2015.
 */
 import groovy.text.SimpleTemplateEngine

 /**
  * Simple User Groovy Bean.
 */
         class User {
     String firstName;
     String lastName;
    }

 def emailTemplate = this.class.getResource("emailTemplete.gtpl")
 def binding = [
         "user": new User(firstName: "Ankit", lastName: "Soni"),
         "date": new Date()
         ]
 def engine = new SimpleTemplateEngine()
 def email = engine.createTemplate(emailTemplate).make(binding)
 def body = email.toString()

 println body
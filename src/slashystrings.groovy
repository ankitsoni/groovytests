/**
 * Created by Ankit Soni on 25-03-2015.
 */
def winpathQuoted='C:\\windows\\system32'
def winpathSlashy=/C:\windows\system32/
println winpathSlashy // C:\windows\system32
assert winpathSlashy ==~ '\\w{1}:\\\\.+\\\\.+'
assert winpathSlashy ==~ /\w{1}:\\.+\\.+/
println "Ankit \\/\\/\\/\\/\\//\\/\\/\\/\\\\//\\ Soni"
assert "Ankit/" ==~ / Ankit\//   //SLASHY STRING
 def name = "vishal"
 def path= "c:/groovy"
 def multilineSlashy = /
 Hello $name
 path= $path
 dollar = $
 path = c:\/groovy
 /
 println multilineSlashy

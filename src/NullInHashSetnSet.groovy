import org.apache.jasper.tagplugins.jstl.core.Set

/**
 * Created by asoni on 2-9-15.
 */
def p =new HashSet()
def q= new Set()
p = [1,2,3,null]
q=[2,3,4,null]
println p.contains(null)
println q
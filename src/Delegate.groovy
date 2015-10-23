/**
 * Created by asoni on 04-06-2015.
 */

    mc = {
        append 'one'
        append 'two'
        println serialVersionUID
    }
    def sb=new StringBuilder()
    mc.delegate=sb
    mc()
    println sb


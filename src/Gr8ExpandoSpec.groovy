/**
 * Created by asoni on 04-06-2015.
 */
class Gr8ExpandoSpec extends Gr8Expando {
    void 'test properrty access'(){
        given:
        def g= new Gr8Expando()

        when:
        g.town= 'Delhi'
        then:
        'Delhi' == g.town
    }
}

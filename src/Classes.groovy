/**
 * Created by asoni on 20-04-2015.
 */
 interface X{
     def x()
   }
 interface Y{
     def y()
    }
 abstract class A{
     def a(){ println 1 }
     abstract b()
     }
 interface Z extends X,Y{
     def z()
 }
 class B extends A implements Z{
     def x(){ println 2 }
     def y(){ println 3 }
     def z(){ println 8 }
     def b(){ println 4 }
 }

 static void main(String[] args){
     def b = new B()
     b.x()
     b.z()
}

// class Animal{
//     class Dog{
//         public void bark(){
//             System.out.println("Barks");
//                 }

//     }
//     class Cow{
//         public void moo(){
//             System.out.println("Moos");
//         }
//     }
//     public static void main(){
//         Animal obj=new Animal();
//         obj.bark();
//         obj.moo();

//     }
// }

class student{
    int id;
    String name;

    public void printDetails(){
        System.out.print("Name:" + name);
        System.out.println("Id: "+id);
    }
}
//inheritance
class candidate extends student{
    public void details(String name,int id){
        this.name=name;
        this.id=id;

    }
}
class sample{
    public static void main(){
        student obj=new student();
        obj.name="Anu";
        obj.id=10;
        obj.printDetails();

       // obj.details("Akash",13);
       
    }
}
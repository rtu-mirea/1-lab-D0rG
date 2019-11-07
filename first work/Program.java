public class Program{
    public static  void main(String[] args){
        System.out.println("Hello Java!");
    }
    Student student = new Student("Mixail", 19, 1);
}

class Student{
    public String Name;
    public int age;
    public boolean isAlive;

    Student(String Name, int Age, boolean isAlive){
        this.Name = Name;
        this.age = Age;
        this.isAlive = isAlive;
    }

     Student(String Name, int Age){
        this.Name = Name;
        this.age = Age;
        this.isAlive = true;
    }

}
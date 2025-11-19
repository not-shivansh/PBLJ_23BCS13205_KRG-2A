import java.util.*;


public class Main{
    public static void main(String[] args){
        System.out.println("Abstract class:");
        Animal a = new Dog();
        a.eats();
        a.makeSound();
        System.out.println("Interface:");
        Car c = new Car();
        c.starts();
        c.stops();
    }
}

abstract class Animal{
    void eats(){
        System.out.println("chews");
    }
    abstract void makeSound();
}

class Dog extends Animal{
    void makeSound(){
        System.out.println("WOOF WOOF");
    }
}

interface Vehicle{
    void starts();
    void stops();
}


class Car implements Vehicle{
    public void starts(){
        System.out.println("Car starts");
    }
    public void stops(){
        System.out.println("Car stops");
    }
}

class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String makeSound() {
        return "Some sound";
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Woof!";
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Meow!";
    }
}

class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Moo!";
    }
}

class AnimalSimulator {
    public void simulateSound(Animal animal) {
        System.out.println(animal.name + " says: " + animal.makeSound());
    }
}

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
            new Dog("Buddy"),
            new Cat("Whiskers"),
            new Cow("Bessie")
        };
        
        AnimalSimulator simulator = new AnimalSimulator();
        for (Animal animal : animals) {
            simulator.simulateSound(animal);
        }
        
        /* Output:
           Buddy says: Woof!
           Whiskers says: Meow!
           Bessie says: Moo!
        */
    }
}

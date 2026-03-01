public class Chicken extends Animal {
    private int egg;
    public Chicken(String name, int egg) { 
        super(name); 
        this.egg=egg;
    }
    @Override public String toString() { return "Chicken{name='" + getName() + "' | egg='"+egg+"'}"; }
    @Override public void display() { 
        System.out.println("Chicken");
        super.display();
        System.out.println("egg=" + egg);
    }
}
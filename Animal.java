public class Animal {
    private final String name;
    public Animal(String name) { this.name = name; }
    public String getName() { return name; }
    @Override public String toString() { return "Animal{name='" + name +"'}"; }
    public void display() { System.out.println("name=" + name);}
}
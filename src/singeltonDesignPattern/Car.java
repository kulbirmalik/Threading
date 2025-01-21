package singeltonDesignPattern;

// learning volatile keyword and singleton design pattern
// singleton design pattern --> only one instance of a class should be created
public class Car {

    private static volatile Car carInstance = null;

    // because don't want to expose it to outside world
    private Car(){
        System.out.println("Instantiated Car.");
    }

    // why static ? because static method don't need instance of class to call the method.
    // this method is exposed to outside world , and if multiple threads also call this method at once,
    // still it will only create one instance at a time
    public static Car getCarInstance() {
        if(carInstance == null){
            synchronized (Car.class) {
                // this if condition is required because if both the threads t1,t2 come inside this block
                // then both will call the new Car() , so double check is needed here.
                if (carInstance == null) {
                    carInstance = new Car();
                }
            }
        }
        return carInstance;
    }

    // here we have not made the whole method as synchronized , because it doesn't make any sense to do so.
    // because race condition handling should only be done in carInstance = new Car();
}

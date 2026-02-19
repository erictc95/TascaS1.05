package level1.exercise5;


import java.io.*;

public class CarMain {

    public static void main (String[] args) {

        Car car1 = new Car("Ferrari", "F40", 1999);
        Car car2 = new Car("BMW", "Z4", 2020);
        Car car3 = new Car("Lamborghini", "Gallardo", 2005);

        try (FileOutputStream fileOut = new FileOutputStream("car.ser")) {
            try(ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

                out.writeObject(car1);
                out.writeObject(car2);
                out.writeObject(car3);
            }
            System.out.println("The Objects were Serialized in car1.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}

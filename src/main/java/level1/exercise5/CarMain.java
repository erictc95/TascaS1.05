package level1.exercise5;


import java.io.*;

public class CarMain {

    public static void main(String[] args) {

        Car car1 = new Car("Ferrari", "F40", 1999);
        Car car2 = new Car("BMW", "Z4", 2020);
        Car car3 = new Car("Lamborghini", "Gallardo", 2005);

        try (FileOutputStream fileOut = new FileOutputStream("car.ser")) {
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

                out.writeObject(car1);
                out.writeObject(car2);
                out.writeObject(car3);
            }
            System.out.println("The Objects were Serialized in car.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileIn = new FileInputStream("car.ser")) {
            try (ObjectInputStream in = new ObjectInputStream(fileIn)) {

                Car car4 = (Car) in.readObject();
                Car car5 = (Car) in.readObject();
                Car car6 = (Car) in.readObject();

                System.out.println(car4);
                System.out.println(car5);
                System.out.println(car6);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println("The Objects were Deserialized from car.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}

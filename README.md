# Sprint 1 Task S1.05

## Repository with level-1, level-2 and level-3 exercises from the Java programming course, developed using IntelliJ IDEA and Maven.

### 📂 Repository Contents

| Level   | Exercise | Package            | Principal Classes | Description                                                                                                      |
|---------|---|--------------------|-------------------|-------------------------------------------------------------------------------------------------------------------------|
| Level 1 | 1 | `level1.exercise1` | `DirectoryOrder`  | Create a method sort by alphabetical the list of the path sended by parameter.                                          |
| Level 1 | 2 | `level1.exercise2` | `DirectoryOrder`  | Modify the previous exercise to use a recursive method to list al files of the path and Indicating it was a `D` or `F`. |
| Level 1 | 3 | `level1.exercise3` | `DirectoryOrder`  | Modify the previous ecersice to save the result in a txt File.                                                          |
| Level 1 | 1 | `level1.exercise4` | `DirectoryOrder`  | Add the function, read a txt file and show the results by console.                                                      |
| Level 1 | 1 | `level1.exercise5` | `Car`             | Create an Object, Serialized and Deserialized.                                                                          | 
| Level 2 | 1 | `level2.exercise1` | `DirectoryOrder`  | Take the Classes of Exercise 3 and change to parameterizing methods in a configuration file.                            |         
| Level 3 | 1 | `level3.exercise1` | `FileEncryptor`   | Create 3 methods: 1st for create a `AES key`, 2nd for Encrypt a file and 3rd for Desencrypt the same file.              |                

## ⚙️ Requirements

- Java JDK 11 o superior
- Maven
- IntelliJ IDEA (optional, but recommended)

---

## 💻 Installation and Execution

1. Clone the repository:

````bash
git clone https://github.com/erictc95/TascaS1.05.git
````

2. Open the project in IntelliJ IDEA or compile with Maven:

````bash
cd TascaS1.05
mvn compile
````

3. Run a specific exercise with Maven:

````bash
mvn exec:java -Dexec.mainClass="package.Main"
````

4. Replace package.Main with the main class of each exercise:

Level-1 / Exercise 1: level1.exercise1

Level-1 / Exercise 2: level1.exercise2

Level-1 / Exercise 3: level1.exercise3

Level-1 / Exercise 1: level1.exercise4

Level-1 / Exercise 1: level1.exercise5

Level-2 / Exercise 1: level1.exercise1

Level-3 / Exercise 1: level1.exercise1


You can also open each Main.java class in IntelliJ and run it directly from the IDE.

## 📝 Usage

Each level folder contains independent exercises.
The exercises demonstrate Java concepts such as different uses of `java.io`, `java.util`, `java.nio.file`, `Serialized` and `Deserialized`, `AES`, `ECB` and `CBC`, `File.separator`.

Commands to use by terminal --> 
`javac -d out src/main/java/level1/exercise1/DirectoryOrder.java src/main/java/level1/exercise1/DirectoryOrderMain.java`
`java -cp out level1.exercise1.DirectoryOrderMain C:\Users\maxer\Desktop`

## 🤝 Contributions

If you want to improve the exercises or add examples:

Fork the repository

Create a branch for your changes: git checkout -b my-branch

Commit your changes: git commit -m "My contribution"

Push your branch: git push origin my-branch

Open a Pull Request

## 📜 License

MIT License

## 👤 Author

Eric Tarres Cabrisas - GitHub --> erictc95
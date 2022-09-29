# Product Rental System Project: BorrowMe

**Project highlight:**

This project concerns a renting system for luxury goods such as bags and shoes. The system would be used by a “renter” who can list their products, set the price of the rental, and set each product’s availability. The system would also be used by customers who can rent the product.

**Design & Flexibility:**

Comments describing each method and class are provided throughout the program to ensure the clarity of the program. I have avoided duplicate code by creating abstract classes to ensure that any class implementing it will have the methods defined/implemented. To ensure the flexibility of the program and to support having additional functionalities in the future, several design patterns were used.

**Singleton Design Pattern**: this was used to create a single instance of a database connection. This design pattern can be seen in the DatabaseConnection class. It ensures that only one instantiation of a connection to the database is created, which reduces the amount of unnecessary objects created and is great for thread safe operations.

**Strategy Design Pattern**: This was used to register users into the website. Depending on the type of user (Renter or Customer), their registration information will be stored in a different table within the database. Using the strategy design pattern introduces the flexibility of managing the behavior of registration for each user type and it reduces the complexity and cumbersomeness of adding many if statements. In the future, if another user category is created, it would be easy to create a registration process specific to them. The classes/interfaces involved in this pattern are: Registration, CustomerRegistration, RenterRegistration and Users.

This design pattern was also used for the following classes/interfaces Purchase, creditCard,payPal, paymentMethods. The benefit of that is there are two different payment methods available to the user, with different behaviors. New payment methods can be added in the future without disrupting the Purchase class.

**Simple factory design pattern**: This design pattern was used to create different delivery methods. This promotes loose coupling between the different types of delivery methods and the class handling the delivery process. It also promotes code flexibility as numerous types of delivery methods can be added in the future. The classes involved in this design patter are delivery, deliveryGenerator, expeditedShip, pickup, and standardShip. The class “Purchase” takes in the delivery type in one of it’s methods in order to add the delivery cost to the final amount owed by the customer. Having the factory pattern here insures that we don’t need to make any changes to the “Purchase” class in the future if we want to add more delivery methods.

**Decorator pattern**: This pattern is used to add additional items to the purchase such as insurance for the item they are renting, packaging and a gift note. Having the decorator design pattern allows us to change the behavior of the “OrderInvoice” class to include the additional costs incurred due to these add ons. Classes involved in this pattern are: addOns, orderInvoice, Purchase, giftNote, packaging, and insurance.

**Chain of responsibility**: This design pattern was used to manage the process of entering the application. Since there are three initial ways to interact with the program, sign up as customer, sign up as renter, login as renter, and login as customer this pattern was used to create different processes to handle each case. The benefit of this class is that we don’t need to specify which process should be interacting with the user at a given time. We chain all of the processes together and let the program choose the correct process based on the user’s input. It also opens room for any future process to be easily added without making much changes to the current code. Classes involved are requestName, renterSignupProcessor, customerSignupProcessor, customerLoginProcessor, renterLoginProcessor, Processor and Chain.

**Facade**: Due to the complexity of the processes associated with the chain of responsibility design pattern, the facade design pattern was used to hide that complexity from the user. This simplifies the process and makes the front facing code easier to understand.


# How to compile the project

We use Apache Maven to compile and run this project. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```

# How to create a binary runnable package 


```bash
mvn clean compile assembly:single
```


# How to run

```bash
mvn -q clean compile exec:java -Dexec.executable="Main" -Dlog4j.configuration="file:log4j.properties"
```

# Run all the unit test classes.


```bash
mvn clean compile test checkstyle:check  spotbugs:check
```

# Using Spotbugs to find bugs in your project 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn spotbugs:gui 
```

or 


```bash
mvn spotbugs:spotbugs
```


```bash
mvn spotbugs:check 
```

check goal runs analysis like spotbugs goal, and make the build failed if it found any bugs. 


For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html


SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


# Run Checkstyle 

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. 
You can change it to other styles like sun checkstyle. 

To analyze this example using CheckStyle run 

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser. 

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```





package ru.geekbrains.patterns;

import ru.geekbrains.patterns.adapter.Hunter;
import ru.geekbrains.patterns.adapter.WildDog;
import ru.geekbrains.patterns.adapter.WildDogAdapter;
import ru.geekbrains.patterns.bridge.About;
import ru.geekbrains.patterns.bridge.Careers;
import ru.geekbrains.patterns.bridge.DarkTheme;
import ru.geekbrains.patterns.compisite.Designer;
import ru.geekbrains.patterns.compisite.Developer;
import ru.geekbrains.patterns.compisite.Organization;
import ru.geekbrains.patterns.decorator.*;
import ru.geekbrains.patterns.facade.Computer;
import ru.geekbrains.patterns.facade.ComputerFacade;
import ru.geekbrains.patterns.proxy.LabDoor;
import ru.geekbrains.patterns.proxy.SecuredDoor;

public class PatternsApp {

    public static void main(String[] args) {

//        DZ 4

        WildDog wildDog= new WildDog();
        WildDogAdapter wildDogAdapter = new WildDogAdapter(wildDog);
        Hunter hunter = new Hunter();
        hunter.hunt(wildDogAdapter);


        DarkTheme darkTheme = new DarkTheme();
        About about = new About(darkTheme);
        Careers careers = new Careers(darkTheme);
        System.out.println(about.getContent());// "About page in Dark Black";
        System.out.println(careers.getContent());// "Careers page in Dark Black";


        // Prepare the employees
        Developer john = new Developer(12000, "John Doe");
        Designer jane = new Designer(15000,"Jane Doe");
       // Add them to organization
        Organization organization = new Organization();
        organization.addEmployee(john);
        organization.addEmployee(jane);
        System.out.println("Net salaries: " + organization.getNetSalaries()); // Net Salaries: 27000


        Coffee someCoffee = new SimpleCoffee();
        System.out.println(someCoffee.getCost());// 10
        System.out.println(someCoffee.getDescription());// Simple Coffee
        Coffee someCoffee1= new MilkCoffee(someCoffee);
        System.out.println(someCoffee1.getCost());// 12
        System.out.println(someCoffee1.getDescription());// Simple Coffee, milk
        Coffee someCoffee2 = new WhipCoffee(someCoffee1);
        System.out.println(someCoffee2.getCost());// 17
        System.out.println(someCoffee2.getDescription());// Simple Coffee, milk, whip
        Coffee someCoffee3 = new VanillaCoffee(someCoffee2);
        System.out.println(someCoffee3.getCost());// 20
        System.out.println(someCoffee3.getDescription());// Simple Coffee, milk, whip, vanilla


        ComputerFacade computer = new ComputerFacade(new Computer());
        computer.turnOn(); // Ouch! Beep beep! Loading.. Ready to be used!
        computer.turnOff(); // Bup bup buzzz! Haah! Zzzzz


        SecuredDoor door = new SecuredDoor(new LabDoor());
        door.open("invalid"); // Big no! It ain't possible.
        door.open("$ecr@t"); // Opening lab door
        door.close(); // Closing lab door


    }


}

package ru.geekbrains.patterns;

import ru.geekbrains.patterns.chain_of_responsibility.Bank;
import ru.geekbrains.patterns.chain_of_responsibility.Bitcoin;
import ru.geekbrains.patterns.chain_of_responsibility.Paypal;
import ru.geekbrains.patterns.command.Bulb;
import ru.geekbrains.patterns.command.RemoteControl;
import ru.geekbrains.patterns.command.TurnOff;
import ru.geekbrains.patterns.command.TurnOn;
import ru.geekbrains.patterns.iterator.RadioStation;
import ru.geekbrains.patterns.iterator.StationList;
import ru.geekbrains.patterns.mediator.ChatRoom;
import ru.geekbrains.patterns.mediator.User;
import ru.geekbrains.patterns.memento.Editor;
import ru.geekbrains.patterns.memento.EditorMemento;
import ru.geekbrains.patterns.observer.EmploymentAgency;
import ru.geekbrains.patterns.observer.JobPost;
import ru.geekbrains.patterns.observer.JobSeeker;
import ru.geekbrains.patterns.state.DefaultText;
import ru.geekbrains.patterns.state.LowerCase;
import ru.geekbrains.patterns.state.TextEditor;
import ru.geekbrains.patterns.state.UpperCase;
import ru.geekbrains.patterns.strategy.BubbleSortStrategy;
import ru.geekbrains.patterns.strategy.QuickSortStrategy;
import ru.geekbrains.patterns.strategy.Sorter;
import ru.geekbrains.patterns.template_method.AndroidBuilder;
import ru.geekbrains.patterns.template_method.IosBuilder;
import ru.geekbrains.patterns.visitor.*;

import java.util.Arrays;
import java.util.List;

public class PatternApp {

    public static void main(String[] args) throws Exception {

        //1
//        Bank bank = new Bank(100);          // Bank with balance 100
//        Paypal paypal = new Paypal(200);      // Paypal with balance 200
//        Bitcoin bitcoin = new Bitcoin(300);    // Bitcoin with balance 300
//
//        bank.setNext(paypal);
//        paypal.setNext(bitcoin);
//
//// Let's try to pay using the first priority i.e. bank
//        bank.pay(259);
//
//// Output will be
//// ==============
//// Cannot pay using bank. Proceeding ..
//// Cannot pay using paypal. Proceeding ..:
//// Paid 259 using Bitcoin!

        // 2

        Bulb bulb = new Bulb();

        TurnOn turnOn = new TurnOn(bulb);
        TurnOff turnOff = new TurnOff(bulb);

        RemoteControl remote = new RemoteControl();
        remote.submit(turnOn); // Bulb has been lit!
        remote.submit(turnOff); // Darkness!

        // 3

        StationList stationList = new StationList();

        stationList.addStation(new RadioStation(89));
        stationList.addStation(new RadioStation(101));
        stationList.addStation(new RadioStation(102));
        stationList.addStation(new RadioStation(103.2f));

        for (int i = 0; i < stationList.getStations().size(); i++) {
            System.out.println(stationList.getStations().get(i).getFrequency());
        }

        // 4
        ChatRoom mediator = new ChatRoom();

        User john = new User("John Doe", mediator);
        User jane = new User("Jane Doe", mediator);

        john.send("Hi there!");
        jane.send("Hey!");

// Output will be
// Feb 14, 10:58 [John]: Hi there!
// Feb 14, 10:58 [Jane]: Hey!


        // 5
        Editor editor = new Editor();

// Type some stuff
        editor.type("This is the first sentence.");
        editor.type("This is second.");

// Save the state to restore to : This is the first sentence. This is second.
        EditorMemento saved = editor.save();

// Type some more
        editor.type("And this is third.");

// Output: Content before Saving
        System.out.println(editor.getContent());
         // This is the first sentence. This is second. And this is third.

// Restoring to last saved state
        editor.restore(saved);

        editor.getContent(); // This is the first sentence. This is second.



        // 6
        // Create subscribers
        JobSeeker johnDoe = new JobSeeker("John Doe");
        JobSeeker janeDoe = new JobSeeker("Jane Doe");

// Create publisher and attach subscribers
        EmploymentAgency jobPostings = new EmploymentAgency();
        jobPostings.attach(johnDoe);
        jobPostings.attach(janeDoe);

// Add a new job and see if subscribers get notified
        jobPostings.addJob(new JobPost("Software Engineer"));

// Output
// Hi John Doe! New job posted: Software Engineer
// Hi Jane Doe! New job posted: Software Engineer


        // 7

        Monkey monkey = new Monkey();
        Lion lion = new Lion();
        Dolphin dolphin = new Dolphin();

        Speak speak = new Speak();

        monkey.accept(speak);    // Ooh oo aa aa!
        lion.accept(speak);      // Roaaar!
        dolphin.accept(speak);   // Tuut tutt tuutt!

        // 7-2

        Jump jump = new Jump();

        monkey.accept(speak);   // Ooh oo aa aa!
        monkey.accept(jump);    // Jumped 20 feet high! on to the tree!

        lion.accept(speak);     // Roaaar!
        lion.accept(jump);      // Jumped 7 feet! Back on the ground!

        dolphin.accept(speak);  // Tuut tutt tuutt!
        dolphin.accept(jump);   // Walked on water a little and disappeared


        // 8

        Integer[] dataset = {1, 5, 4, 3, 2, 8};

        Sorter sorter = new Sorter(new BubbleSortStrategy());
        sorter.sort(dataset); // Output : Sorting using bubble sort

        Sorter sorter1 = new Sorter(new QuickSortStrategy());
        sorter1.sort(dataset); // Output : Sorting using quick sort


        // 9


        TextEditor editor1 = new TextEditor(new DefaultText());

        editor1.type("First line");

        editor1.setState(new UpperCase());

        editor1.type("Second line");
        editor1.type("Third line");

        editor1.setState(new LowerCase());

        editor1.type("Fourth line");
        editor1.type("Fifth line");

// Output:
// First line
// SECOND LINE
// THIRD LINE
// fourth line
// fifth line


        // 10

        AndroidBuilder androidBuilder = new AndroidBuilder();
        androidBuilder.build();

// Output:
// Running android tests
// Linting the android code
// Assembling the android build
// Deploying android build to server

        IosBuilder iosBuilder = new IosBuilder();
        iosBuilder.build();

// Output:
// Running ios tests
// Linting the ios code
// Assembling the ios build
// Deploying ios build to server











    }
}

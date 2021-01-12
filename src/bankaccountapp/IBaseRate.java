package bankaccountapp;

public interface IBaseRate {
	//write method that returns the base returns
	//For type int , the default value is zero, that is, 0 . For type long , the default value is zero, that is, 0L . For type float , the default value is positive zero, that is, 0.0f . For type double , the default value is positive zero, that is, 0.0d
	
	
	//Like regular interface methods, default methods are implicitly public — there's no need to specify the public modifier.
	//released in java 8
	
	//The most typical use of default methods in interfaces is to incrementally provide additional functionality to a given type without breaking down the implementing classes.
	default double getBaseRate()
	{
		return 2.5;
	}
	
}



/*
Multiple Interface Inheritance Rules

Default interface methods are a pretty nice feature indeed, but with some caveats worth mentioning. Since Java allows classes to implement multiple interfaces, it's important to know what happens when a class implements several interfaces that define the same default methods.

To better understand this scenario, let's define a new Alarm interface and refactor the Car class:

public interface Alarm {

    default String turnAlarmOn() {
        return "Turning the alarm on.";
    }
    
    default String turnAlarmOff() {
        return "Turning the alarm off.";
    }
}
With this new interface defining its own set of default methods, the Car class would implement both Vehicle and Alarm:
In this case, the code simply won't compile, as there's a conflict caused by multiple interface inheritance (a.k.a the Diamond Problem). The Car class would inherit both sets of default methods. Which ones should be called then?

To solve this ambiguity, we must explicitly provide an implementation for the methods:

@Override
public String turnAlarmOn() {
    // custom implementation
}
    
@Override
public String turnAlarmOff() {
    // custom implementation
}
We can also have our class use the default methods of one of the interfaces.

Let's see an example that uses the default methods from the Vehicle interface:

@Override
public String turnAlarmOn() {
    return Vehicle.super.turnAlarmOn();
}

@Override
public String turnAlarmOff() {
    return Vehicle.super.turnAlarmOff();
}
Similarly, we can have the class use the default methods defined within the Alarm interface:

@Override
public String turnAlarmOn() {
    return Alarm.super.turnAlarmOn();
}

@Override
public String turnAlarmOff() {
    return Alarm.super.turnAlarmOff();
}
Furthermore, it's even possible to make the Car class use both sets of default methods:

@Override
public String turnAlarmOn() {
    return Vehicle.super.turnAlarmOn() + " " + Alarm.super.turnAlarmOn();
}
    
@Override
public String turnAlarmOff() {
    return Vehicle.super.turnAlarmOff() + " " + Alarm.super.turnAlarmOff();
}

***************************************************************************************************

Static Interface Methods

Aside from being able to declare default methods in interfaces, Java 8 allows us to define and implement static methods in interfaces.

Since static methods don't belong to a particular object, they are not part of the API of the classes implementing the interface, and they have to be called by using the interface name preceding the method name.


so abstract class can't declare the default methods
Abstract class can define constructor. They are more structured and can have a state associated with them. While in contrast, default method can be implemented only in the terms of invoking other interface methods, with no reference to a particular implementation's state

Can an abstract class have static methods? Yes, abstract class can have Static Methods. The reason for this is Static methods do not work on the instance of the class, they are directly associated with the class itself











*/
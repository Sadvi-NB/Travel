package travelPackage;

public class Main {

	public static void main(String[] args) {
TravelPackage package1 = new TravelPackage("Package 1", 50);
       
        Destination destination1 = new Destination("Karnataka");
        destination1.addActivity(new Activity("Activity 1", "Description 1", 100.0, 20));
        destination1.addActivity(new Activity("Activity 2", "Description 2", 75.0, 15));
        
        Destination destination2 = new Destination("Destination 2");
        destination2.addActivity(new Activity("Activity 3", "Description 3", 120.0, 25));
        
        package1.addDestination(destination1);
        package1.addDestination(destination2);
        
        // Print the itinerary of the travel package.
        package1.printItinerary();
        package1.addPassenger(new Passenger("Savina", 1, PassengerType.STANDARD,10000));
        package1.addPassenger(new Passenger("Kshethra", 2, PassengerType.GOLD,5000));
        package1.addPassenger(new Passenger("Ruby", 3, PassengerType.PREMIUM,0.0));
        
        // Print the passenger list of the travel package.
        package1.printPassengerList();
    
        Activity activity1 = new Activity("Activity 1", "Description 1", 100.0, 20);
        destination1.addActivity(activity1);
        package1.addDestination(destination1);
        
        package1.signUpPassengerForActivity(package1.getPassengers().get(0), activity1);
        
        // Print the details of the individual passenger.
        package1.getPassengers().get(0).printPassengerDetails();
        package1.printAvailableActivities();
        
        
		
        
    }

	}



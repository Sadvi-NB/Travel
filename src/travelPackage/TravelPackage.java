package travelPackage;

	import java.util.List;
	import java.util.ArrayList;

	public class TravelPackage {
	    private String name;
	    private int passengerCapacity;
	    private List<Destination> itinerary;
	    private List<Passenger> passengers;

	    public TravelPackage(String name, int passengerCapacity) {
	        this.name = name;
	        this.passengerCapacity = passengerCapacity;
	        this.itinerary = new ArrayList<>();
	        this.passengers = new ArrayList<>();
	    }

	    public String getName() {
	        return name;
	    }

	    public int getPassengerCapacity() {
	        return passengerCapacity;
	    }

	    public List<Passenger> getPassengers() {
	        return passengers;
	    }

	    public void addDestination(Destination destination) {
	        itinerary.add(destination);
	    }

	    public void addPassenger(Passenger passenger) {
	        if (passengers.size() < passengerCapacity) {
	            passengers.add(passenger);
	        } else {
	            System.out.println("The package is at full passenger capacity.");
	        }
	    }
	    
	   

	    public void signUpPassengerForActivity(Passenger passenger, Activity activity) {
	        if (passenger.getSignedUpActivities().size() < 0) {
	            Destination destination = findDestinationForActivity(activity);
	            if (destination != null) {
	                if (activityHasAvailableCapacity(activity)) {
	                    passenger.signUpForActivity(activity);
	                } else {
	                    System.out.println("Activity has reached its capacity. Cannot sign up.");
	                }
	            }
	        } else {
	            System.out.println("Passenger has already signed up for the maximum number of activities.");
	        }
	    }
        
	    private boolean activityHasAvailableCapacity(Activity activity) {
	        // Check if the activity's current capacity is less than its maximum capacity.
	        return activity.getCapacity() > activity.getEnrolledPassengers().size();
	    }
	    public Destination findDestinationForActivity(Activity activityToFind) {
	        for (Destination destination : itinerary) {
	            for (Activity activity : destination.getActivities()) {
	                if (activity == activityToFind) {
	                    return destination; // Found the destination associated with the activity
	                }
	            }
	        }
	        return null; // Activity not found or associated with any destination
	    }
	

	    

	    // Additional methods for printing itinerary, passenger lists, and more as specified.
	    public void printItinerary() {
	        System.out.println("Travel Package: " + name);
	        System.out.println("Destinations and Activities:");

	        for (Destination destination : itinerary) {
	            System.out.println("Destination: " + destination.getName());

	            for (Activity activity : destination.getActivities()) {
	                System.out.println("  Activity: " + activity.getName());
	                System.out.println("    Cost: $" + activity.getCost());
	                System.out.println("    Capacity: " + activity.getCapacity());
	                System.out.println("    Description: " + activity.getDescription());
	            }
	}

	    }
	    public void printPassengerList() {
	        System.out.println("Travel Package: " + name);
	        System.out.println("Passenger Capacity: " + passengerCapacity);
	        System.out.println("Number of Passengers Enrolled: " + passengers.size());
	        System.out.println("Passenger List:");

	        for (Passenger passenger : passengers) {
	            System.out.println("  Name: " + passenger.getName());
	            System.out.println("  Passenger Number: " + passenger.getPassengerNumber());
	        }
	}
	    public void printAvailableActivities() {
	        System.out.println("Activities with Available Spaces:");

	        for (Destination destination : itinerary) {
	            for (Activity activity : destination.getActivities()) {
	                int availableSpaces = activity.getCapacity() - activity.getEnrolledPassengers().size();
	                if (availableSpaces > 0) {
	                    System.out.println("Activity: " + activity.getName());
	                    System.out.println("Destination: " + destination.getName());
	                    System.out.println("Available Spaces: " + availableSpaces);
	                }
	            }
	        }
	    }

		public List<Destination> getItinerary() {
			// TODO Auto-generated method stub
			return itinerary;
		}
	}


package travelPackage;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
	
	    private String name;
	    private int passengerNumber;
	    private PassengerType type; // Add an enum for passenger types
	    private double balance; // Add balance attribute for standard and gold passengers
	    private List<Activity> signedUpActivities;
	    private TravelPackage travelPackage;

	    public Passenger(String name, int passengerNumber, PassengerType type,double balance) {
	        this.name = name;
	        this.passengerNumber = passengerNumber;
	        this.type = type;
	        this.signedUpActivities = new ArrayList();
	        
	        // Initialize balance based on passenger type
	        if (type == PassengerType.STANDARD || type == PassengerType.GOLD) {
	            this.balance = balance; // Set an initial balance for standard and gold passengers
	        } else {
	            this.balance = 0.0; // Premium passengers have a balance of 0
	        }
	    }

	    public String getName() {
	        return name;
	    }

	    public int getPassengerNumber() {
	        return passengerNumber;
	    }

	    public PassengerType getType() {
	        return type;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public List<Activity> getSignedUpActivities() {
	        return signedUpActivities;
	    }

	    public void signUpForActivity(Activity activity) {
	    	double activityCost=activity.getCost();
	    	double discountedCost=activityCost;
	    	 switch (type) {
	            case STANDARD:
	                if (balance >= activity.getCost()) {
	                    balance -= activity.getCost();
	                    signedUpActivities.add(activity);
	                } else {
	                    System.out.println("Insufficient balance. Cannot sign up for the activity.");
	                }
	                break;
	            case GOLD:
	                double discount = 0.10 * activity.getCost();
	                if (balance >= (activity.getCost() - discount)) {
	                    balance -= (activity.getCost() - discount);
	                    signedUpActivities.add(activity);
	                } else {
	                    System.out.println("Insufficient balance. Cannot sign up for the activity.");
	                }
	                break;
	            case PREMIUM:
	                signedUpActivities.add(activity);
	                break;
	            default:
	                System.out.println("Invalid passenger type.");
	        }
	    }
	    
	    public void printPassengerDetails() {
	        System.out.println("Passenger Details:");
	        System.out.println("Name: " + name);
	        System.out.println("Passenger Number: " + passengerNumber);
	        
	        if (type == PassengerType.STANDARD || type == PassengerType.GOLD) {
	            System.out.println("Balance: $" + balance);
	        }
	        
	        System.out.println("Activities Signed Up For:");
	        
	        for (Activity activity : signedUpActivities) {
	            System.out.println("  Activity: " + activity.getName());
	            System.out.println("  Destination: " + findDestinationForActivity(activity).getName());
	            System.out.println("  Price Paid: $" + calculatePricePaid(activity));
	        }
	    }

	    public Destination findDestinationForActivity(Activity activityToFind) {
	        if (travelPackage != null) {
	            for (Destination destination : travelPackage.getItinerary()) {
	                for (Activity activity : destination.getActivities()) {
	                    if (activity == activityToFind) {
	                        return destination; // Found the destination associated with the activity
	                    }
	                }
	            }
	        }
	        return null; // Activity not found or not associated with any destination in the associated TravelPackage
	    }
	

		private double calculatePricePaid(Activity activity) {
	        if (type == PassengerType.STANDARD) {
	            return activity.getCost();
	        } else if (type == PassengerType.GOLD) {
	            double discount = 0.10 * activity.getCost();
	            return activity.getCost() - discount;
	        } else {
	            return 0.0; // Premium passengers sign up for free
	        }
	    }
	}

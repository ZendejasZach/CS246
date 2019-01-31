package zendejas;


public class Cruise implements Expense{

    // Variables
    Destination destination;

    // Constructor
    public Cruise(Destination d){
        destination = d;
    }

    // get cost with Expense interface
    public float getCost(){
        float cost = 0;

        switch(destination){
            case Japan:
                cost = (float) 3000.00;
                break;
            case Europe:
                cost = (float) 2000.00;
                break;
            case Mexico:
                cost = (float) 1000.00;
                break;
        }
        return cost;
    }
}

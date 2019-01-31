package zendejas;

import java.util.ArrayList;
import java.util.List;

public class VacationCalculator{

    public static void main(String[] args) {
        VacationCalculator vc = new VacationCalculator();

        // Calculate vacation costs
        float japanCost = vc.calculateVacationCost(Destination.Japan);
        float mexicoCost = vc.calculateVacationCost(Destination.Mexico);
        float europeCost = vc.calculateVacationCost(Destination.Europe);

        System.out.format(String.format("Cost to Japan: $%.2f", japanCost));
        System.out.format(String.format("Cost to Mexico: $%.2f", mexicoCost));
        System.out.format(String.format("Cost to Europe: $%.2f", europeCost));
    }

    /**
     * Calculates the total cost for vacationing at a given location
     * for a specific number of nights
     * @param dest: the destination of the vacation
     * @return      the total cost of the vacation
     */
    public float calculateVacationCost(Destination dest){
        List<Expense> e = new ArrayList<Expense>();
        e.add(new Cruise(dest));

        float total = tallyExpenses(e);
        return total;
    }

    /**
     * internal method used by VacationCalculator to loop
     * through a list of items that implement the Expense interface
     * and determine their cost
     *
     * @param expenses A list of items that implement the Expense interface
     * @rethrn         The total cost calculated by the items.
     */
    float tallyExpenses(List<Expense> expenses){
        float cost = 0;
        for(Expense e: expenses){
           cost += e.getCost();
        }
        return cost;
    }
}

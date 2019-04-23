package servlet;
import java.util.ArrayList;
import java.util.Date;

public class BudgetData {
    private ArrayList<Entry> list;

    public BudgetData(ArrayList<Entry> input){
        list = input;
    }

    public double getWeeklyReport(){
        float sum = 0;
        for(Entry e: list){
                sum += e.getValue() * ( 7.0 / (double)e.getIntervalVal()) * e.getPeriod();

        }
        return sum;
    }

    public double getMonthlyReport(){
        float sum = 0;
        for(Entry e: list){
            sum += e.getValue() * ( 30.0 /  (double)e.getIntervalVal()) * e.getPeriod();

        }
        return sum;
    }
    public double getYearlyReport(){
        float sum = 0;
        for(Entry e: list){
            sum += e.getValue() * ( 365.0 /  (double)e.getIntervalVal()) * e.getPeriod();

        }
        return sum;
    }



}

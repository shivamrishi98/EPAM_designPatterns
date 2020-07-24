package com.epam.designPattern.creational;
import java.io.*;
import java.util.Scanner;

interface startPlan{
    abstract void getRate();
}

abstract class Plan implements startPlan{
    protected double rate;
    public void calculateTotalBill(int numberUnits){
        System.out.println(numberUnits*rate);
    }
}

class DomesticPlan extends Plan {

    public void getRate(){
        rate=3.50;
    }
}
class CommercialPlan extends Plan {

    public void getRate() {
        rate = 7.50;
    }
}
class UrbanPlan extends Plan {

    public void getRate() {
        rate = 8.0;
    }
}
class InstitutionalPlan extends Plan {

    public void getRate() {
        rate = 5.50;
    }
}


class GetPlanFactory {

    public Plan getPlan(String planType){
        if(planType == null){
            return null;
        }
        if(planType.equalsIgnoreCase("DOMESTIC")) {
            return new DomesticPlan();
        }
        else if(planType.equalsIgnoreCase("URBAN")){
            return new UrbanPlan();
        }
        else if(planType.equalsIgnoreCase("COMMERCIAL")){
            return new CommercialPlan();
        }
        else if(planType.equalsIgnoreCase("INSTITUTIONAL")) {
            return new InstitutionalPlan();
        }
        return null;
    }
}

class FactoryMethodPattern {

    public static void main(String args[])throws IOException{
        GetPlanFactory planFactory = new GetPlanFactory();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the name of plan (DOMESTIC/URBAN/COMMERCIAL/INSTITUTIONAL): ");
        String planName=sc.nextLine();
        System.out.print("Enter the number of units for bill will be calculated: ");
        int units=sc.nextInt();
        Plan p = planFactory.getPlan(planName);
        System.out.print("Bill amount for your plan = "+planName+" of  given "+units+" units is: ");
        p.getRate();
        p.calculateTotalBill(units);
        sc.close();
    }
}

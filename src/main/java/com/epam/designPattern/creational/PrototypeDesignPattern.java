package com.epam.designPattern.creational;
import java.util.HashMap;
import java.util.Map;
abstract class Color implements Cloneable{
    protected String colorName;
    abstract void addColor();
    public Object clone(){
        Object myclone = null;
        try{
            myclone = super.clone();
        }catch (CloneNotSupportedException e)
        {e.printStackTrace();}
        return myclone;}
}

class MyBlueColor extends Color{
    public MyBlueColor()
    {this.colorName = "blue";}
    void addColor()
    { System.out.println("Blue color added"); }
}

class MyBlackColor extends Color{
    public MyBlackColor()
    {this.colorName = "black";}
    void addColor()
    {System.out.println("Black color added");}
}

class MYColorStore {

    private static Map<String, Color> colorHashMap = new HashMap<String, Color>();
    static
    {
        colorHashMap.put("blue", new MyBlueColor());
        colorHashMap.put("black", new MyBlackColor());
    }
    public static Color getColor(String colorName)
    {
        return (Color) colorHashMap.get(colorName).clone();
    }
}

class PrototypeDesignPattern
{
    public static void main (String[] args)
    {
        MYColorStore.getColor("blue").addColor();
        MYColorStore.getColor("black").addColor();
        MYColorStore.getColor("black").addColor();
        MYColorStore.getColor("blue").addColor();
    }
}

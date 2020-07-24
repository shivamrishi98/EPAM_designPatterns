package com.epam.designPattern.behavioural;


interface OfficeInternetAccess {
    public void grantAccess();
}

class RealInternetAccess implements OfficeInternetAccess {
    private String employeeName;
    public RealInternetAccess(String empName) {
        this.employeeName = empName;
    } 
    public void grantAccess() {
        System.out.println("Internet Access granted for employee: "+ employeeName);
    }
    public void denyAccess() {
        System.out.println("Internet Access denyed for employee: "+ employeeName);
    }
}

class ProxyInternetAccess implements OfficeInternetAccess {
    private String employeeName;
    private RealInternetAccess  realaccess;
    public ProxyInternetAccess(String employeeName) {
        this.employeeName = employeeName;
    }
    
    public void grantAccess()
    {
        if (getRole(employeeName) > 4)
        {
            realaccess = new RealInternetAccess(employeeName);
            System.out.println(" Your job level is above 5 So ...");
            realaccess.grantAccess();
        }
        else
        {
        	realaccess = new RealInternetAccess(employeeName);
        	realaccess.denyAccess();
            System.out.println("No Internet access granted. Your job level is below 5");
        }
    }
    public int getRole(String emplName) {
    	if(emplName.contentEquals("BRAHMJIT"))
        return 5;
    	else 
    		return 0;
    }
}

class ProxyPattern {
    public static void main(String[] args)
    {
        OfficeInternetAccess access = new ProxyInternetAccess("Ashish");
        OfficeInternetAccess access2 = new ProxyInternetAccess("shivam");
        access.grantAccess();
        access2.grantAccess();
    }
}

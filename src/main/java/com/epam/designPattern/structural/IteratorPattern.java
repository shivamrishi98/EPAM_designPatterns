package com.epam.designPattern.structural;

import java.util.Iterator;
abstract class OuterCompanyContainer {
    public abstract Iterator<String> getIterator();
}

class NamesDeck extends OuterCompanyContainer {

    public String namesArr[]={"A", "B","C"};
    public Iterator<String> getIterator() {
        return new NamesIterator() ;
    }
    private class NamesIterator implements Iterator<String> {
        int i;
        public boolean hasNext() {
            if (i<namesArr.length){
                return true;
            }
            return false;
        }
        
        public String next() {
            if(this.hasNext()){
                return namesArr[i++];
            }
            return null;
        }
    }
}

class IteratorPattern  {
    public static void main(String[] args) {
        NamesDeck myCollection = new NamesDeck();
        Iterator<String> itr = myCollection.getIterator();
        while(itr.hasNext()){
            String name = (String)itr.next();
            System.out.println("Name : " + name);
        }
    }
}

package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test extends AbstractList<String> implements  Serializable{


    Entry<String> root;

    public Test(){
        root = new Test.Entry<>("0");
    }

//    public String getParent(String s){
//        String nameParent = null;
//        ArrayList<Entry<String>> intQueue = new ArrayList<Entry<String>>();
//        intQueue.add(root);
//
//
//        while (! intQueue.isEmpty()){
//            Entry<String> current = intQueue.remove(0);
//            System.out.print(current.elementName);
//            if (current.leftChild != null){
//                if(s.equals(current.leftChild.elementName)) return current.elementName;
//                intQueue.add(current.leftChild);
//            }
//
//            if (current.rightChild != null){
//                if(s.equals(current.rightChild.elementName)) return current.elementName;
//                intQueue.add(current.rightChild);
//            }
//        }
//        return nameParent;
//    }

    public String getParent (String s){
        String nameParent = null;

        ArrayList<Entry<String>> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()){
            Entry<String> current = list.remove(0);
            if (current.leftChild!= null && s.equals(current.leftChild.elementName)) {
                return current.elementName;

            }
            if (current.rightChild!=null && s.equals(current.rightChild.elementName)) {
                return current.elementName;

            }
            if (current.leftChild != null){
                list.add(current.leftChild);
            }
            if (current.rightChild != null){
                list.add(current.rightChild);
            }
        }

        return nameParent;
    }
    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        void checkChildren(){
            if (leftChild != null) availableToAddLeftChildren = false;
            if (rightChild != null) availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

    public static void main(String[] args) {
        List<String> list = new Test();

        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));

        }

        System.out.println("List size is " + list.size());
        System.out.println("Expected parent is 6 for 14, actual parent is " + ((Test) list).getParent("14"));

        System.out.println("Expected parent is null for 20, actual parent is " + ((Test) list).getParent("20"));

        list.remove("3");
        System.out.println("Expected parent is null after 3 removed, actual parent is " + ((Test) list).getParent("8"));

        list.add("16");
        System.out.println("Expected parent is 9, actual parent is " + ((Test) list).getParent("16"));

        list.remove("4");
        list.remove("5");
        list.remove("6");
        System.out.println("Expected true for adding 20, actual " + list.add("20"));
        System.out.println("Expected parent is 1 for 20, actual parent is " + ((Test) list).getParent("20"));
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }



    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        boolean deleteElement = false;
        if (o instanceof String){
            ArrayList<Entry<String>> list = new ArrayList<>();
            list.add(root);
            while (!list.isEmpty()){
                Entry<String> current = list.remove(0);
                if (current.leftChild != null){
                    if (o.equals(current.leftChild.elementName)){
                        current.leftChild = null;
                        current.availableToAddLeftChildren = true;
                        deleteElement = true;
                        break;
                    }
                    list.add(current.leftChild);
                }
                if (current.rightChild != null){
                    if (o.equals(current.rightChild.elementName)){
                        current.rightChild = null;
                        current.availableToAddRightChildren = true;
                        deleteElement = true;
                        break;
                    }
                    list.add(current.rightChild);
                }
            }
            return deleteElement;
        }
        else throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        int size = -1;
        ArrayList<Entry<String>> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()){

            Entry<String> current = list.remove(0);
            size++;

            if (current.leftChild != null) list.add(current.leftChild);
            if (current.rightChild!= null) list.add(current.rightChild);

        }

        return size;
    }


//    @Override
//    public boolean add(String o) {
//        boolean addElement = false;
//        ArrayList<Entry<String>> intQueueNull = new ArrayList<Entry<String>>();
//        ArrayList<Entry<String>> intQueue = new ArrayList<Entry<String>>();
//        intQueue.add(root);
//
//        while (! intQueue.isEmpty()){
//            Entry<String> current = intQueue.remove(0);
//
//            if (current.availableToAddLeftChildren){
//                current.leftChild = new Entry<String>((String) o);
//                current.checkChildren();
//                addElement =  true;
//                break;
//            }
//            else if(current.leftChild !=null){
//                intQueue.add(current.leftChild);
//            }
//
//            if (current.availableToAddRightChildren){
//                current.rightChild = new Entry<String>((String) o);
//                current.checkChildren();
//                addElement = true;
//                break;
//            }
//            else if(current.rightChild !=null) {
//                intQueue.add(current.rightChild);
//            }
//            if(current.rightChild == null && current.leftChild == null)
//                intQueueNull.add(current);
//
//        }
//
//        if(! addElement){
//            Entry<String>  newElement  = new Entry<String>((String) o);
//
//            while (! intQueueNull.isEmpty()){
//                Entry<String> current = intQueueNull.remove(0);
//
//
//                if (current.leftChild == null ){
//                    if (newElement == null) current.availableToAddLeftChildren = true;
//                    current.leftChild = newElement;
//                    newElement = null;
//                }
//
//                if (current.rightChild == null){
//                    if (newElement == null) current.availableToAddRightChildren = true;
//                    current.rightChild = newElement;
//                    newElement = null;
//                }
//
//
//            }
//        }
//
//        return true;
//    }

    @Override
    public boolean add(String o){
        boolean addElement = false;
        ArrayList<Entry<String>> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()){
            Entry<String> current = list.remove(0);
            if (current.availableToAddLeftChildren){
                current.leftChild = new Entry<String>((String) o);
                current.checkChildren();
                addElement = true;
                break;
            } else if (current.leftChild != null){
                list.add(current.leftChild);
            }
            if (current.availableToAddRightChildren){
                current.rightChild = new Entry<>(o);
                current.checkChildren();
                addElement = true;
                break;
            } else if (current.rightChild != null){
                list.add(current.rightChild);
            }
        }
        return true;
    }



}

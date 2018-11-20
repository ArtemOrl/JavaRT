package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

public class Test3 extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root = new Entry<>("0");

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        /*
        System.out.println("size:" + list.size() + "; removing 14: " + list.remove("14") + "; size after:" + list.size());
        System.out.println("size:" + list.size() + "; removing 2: " + list.remove("2") + "; size after:" + list.size());
        System.out.println("size:" + list.size() + "; removing 2: " + list.remove("5") + "; size after:" + list.size());
        */
        System.out.println("Expected 3 for 8, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        System.out.println("5 removed");
        System.out.println("Expected null for 11, actual is " + ((CustomTree) list).getParent("11"));
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public void checkChildren() {
            if (leftChild != null)
                availableToAddLeftChildren = false;
            if (rightChild != null)
                availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

    @Override
    public boolean add(String s) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Entry<String> leaf = queue.poll();
            /*if (leaf == null)
                break;*/
            leaf.checkChildren();
            if (leaf.isAvailableToAddChildren()) {
                if (leaf.availableToAddLeftChildren) {
                    leaf.leftChild = new Entry<String>(s);
                    leaf.leftChild.parent = leaf;
                    return true;
                }
                if (leaf.availableToAddRightChildren) {
                    leaf.rightChild = new Entry<String>(s);
                    leaf.rightChild.parent = leaf;
                    return true;
                }
            } else {
                if (leaf.leftChild != null)
                    queue.offer(leaf.leftChild);
                if (leaf.rightChild != null)
                    queue.offer(leaf.rightChild);
            }
        }
        return false;
    }

    @Override
    public int size() {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);
        int size = 0;
        while (!queue.isEmpty()) {
            Entry<String> leaf = queue.poll();
            /*if (leaf == null)
                break;*/
            if (leaf.leftChild != null) {
                size++;
                queue.offer(leaf.leftChild);
            }
            if (leaf.rightChild != null) {
                size++;
                queue.offer(leaf.rightChild);
            }
        }
        return size;
    }

    @Override
    public boolean remove(Object o) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Entry<String> leaf = queue.poll();
            /*if (leaf == null)
                break;*/
            if (leaf.elementName.equals(o.toString())) {
                if (Integer.parseInt(leaf.elementName) % 2 == 1)
                    leaf.parent.leftChild = null;
                else
                    leaf.parent.rightChild = null;
                //leaf = null;
                return true;
            } else {
                if (leaf.leftChild != null)
                    queue.offer(leaf.leftChild);
                if (leaf.rightChild != null)
                    queue.offer(leaf.rightChild);
            }
        }
        return false;
    }

    public String getParent(String s) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);
        while (true) {
            Entry<String> leaf = queue.poll();
            if (leaf == null)
                return null;
            if (leaf.elementName.equals(s)) {
                return leaf.parent.elementName;
            }
            if (leaf.leftChild != null)
                queue.offer(leaf.leftChild);
            if (leaf.rightChild != null)
                queue.offer(leaf.rightChild);
        }
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}

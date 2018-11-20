//package com.javarush.task.task20.task2028;
//
//import java.io.Serializable;
//import java.util.AbstractList;
//import java.util.ArrayDeque;
//import java.util.Collection;
//import java.util.List;
//
//public class Test2 {
//}
//    Построй дерево(1)
//*/
////public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
////
////
////    Entry<String> root = new Entry<>("0");
////    int size=0;
////
////    public static void main(String[] args) {
////        List<String> list = new CustomTree();
////        for (int i = 1; i < 16; i++) {
////            list.add(String.valueOf(i));
////        }
////        System.out.println(list.size());
////        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
////        list.remove("5");
////        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("20"));
////        System.out.println(list.size());
////
////    }
////
////    @Override
////    protected Object clone() throws CloneNotSupportedException {
////        return super.clone();
////    }
////
////
////    @Override
////    public String get(int i) {
////        throw new UnsupportedOperationException();
////    }
////
//////    @Override
//////    public void add(int i, String s) {
//////        Entry<String> top = root;
//////        Entry<String> current = new Entry(s);
//////        Queue<Entry>queue=new LinkedList<>();
//////        do {
//////            if (top.leftChild!=null){//Если в левом поддереве есть нода - добавить её в очередь
//////                queue.add(top.leftChild);
//////            }else {
//////                top.leftChild=current;//Создаем новую ноду в левом поддереве
//////                top.leftChild.parent=top;//Указываем родителя
//////                size++;
//////                return;
//////            }
//////            if (top.rightChild!=null){//Если в правом поддереве есть нода - добавить её в очередь
//////                queue.add(top.rightChild);
//////            }else {
//////                top.rightChild=current;//Создаем новую ноду в правом поддереве
//////                top.rightChild.parent=top;//Указывае родителя
//////                size++;
//////                return;
//////            }
//////            if (!queue.isEmpty()){
//////                top=queue.poll();//Берём из начала очереди с удалением
//////            }
//////        }while (!queue.isEmpty());
//////        queue.clear();
//////    }
////
////    @Override
////    public boolean add(String elementName) {
////        List<Entry> list = new ArrayList<>();
////        list.add(root);
////        Entry newEntry = new Entry(elementName);
////
//////        temp.add(newEntry);
////
////        Entry entry;
////        while(!list.isEmpty()){
////            entry = list.remove(0);
////            if(!entry.isAvailableToAddChildren()){
////                if(entry.leftChild != null) {
////                    list.add(entry.leftChild);
////                }
////                if(entry.rightChild != null) {
////                    list.add(entry.rightChild);
////                }
////                continue;
////            }
////            newEntry.lineNumber = entry.lineNumber + 1;
////            if(entry.availableToAddLeftChildren){
////                entry.leftChild = newEntry;
////                entry.leftChild.parent = entry;
////            } else if (entry.availableToAddRightChildren) {
////                entry.rightChild = newEntry;
////                entry.rightChild.parent = entry;
////            }
////            entry.checkChildren();
////            size++;
////            return true;
////        }
////        return false;
////    }
////
////
////    @Override
////    public String remove(int i) {
////        throw new UnsupportedOperationException();
////    }
////
////    @Override
////    public Iterator<String> iterator() {
////        return new Itr();
////    }
////
////    public class Itr implements Iterator<String>{
////        Entry<String>top=root;
////        Queue<Entry>queue_fin=new LinkedList<>();
////        public Itr(){
////            Queue<Entry>queue=new LinkedList<>();
////
////            do {
////                if (top.leftChild!=null){
////                    queue.add(top.leftChild);
////                    if (!queue_fin.contains(top.leftChild)){
////                        queue_fin.add(top.leftChild);
////                    }
////
////                }
////                if (top.rightChild!=null){
////                    if (!queue_fin.contains(top.rightChild)){
////                        queue_fin.add(top.rightChild);
////                    }
////                }
////                if (!queue.isEmpty()){
////                    top=queue.poll();
////                }
////            }while (!queue.isEmpty());
////        }
////        @Override
////        public boolean hasNext(){
////            return !queue_fin.isEmpty();
////        }
////
////        @Override
////        public String next() {
////            if (!hasNext()) {
////                throw new NoSuchElementException("All nodes have been visited!");
////            }
////            try {
////                top = queue_fin.poll();
////                String next = top.elementName;
////
////                return next;
////            } catch (IndexOutOfBoundsException e) {
////                throw new NoSuchElementException();
////            }
////        }
////
////    }
////
//////    @Override
//////    public boolean remove(Object o) {
//////        if (this.contains(o)){
//////            Entry<String>top=root;
//////            Entry<String>search=null;
//////            String str=(String)o;
//////            Queue<Entry>queue=new LinkedList<>();
//////            queue.add(top);
//////            do {
//////                if (!queue.isEmpty())top=queue.poll();
//////                if (top.elementName!=null){
//////                    if (top.elementName.equals(str)){
//////                        search=top;
//////                        break;
//////                    }
//////                }
//////                if (top.leftChild!=null)queue.add(top.leftChild);
//////                if (top.rightChild!=null)queue.add(top.rightChild);
//////            }while (!queue.isEmpty());
//////            queue.clear();
//////            top=search;
//////            search=top.parent;
//////            if (search!=null&&search.leftChild==top){
//////                search.leftChild=null;
//////            }else if (search!=null&&search.rightChild==top){
//////                search.rightChild=null;
//////            }
//////            queue.add(top);
//////            do {
//////                top=queue.poll();
//////                if (top.leftChild!=null)queue.add(top.leftChild);
//////                if (top.rightChild!=null)queue.add(top.rightChild);
//////                top=null;
//////                size--;
//////            }while (!queue.isEmpty());
//////            queue.clear();
//////            return true;
//////        }
//////        return false;
//////    }
////
////    @Override
////    public boolean remove(Object o) {
////        if (o.getClass() != String.class) throw new UnsupportedOperationException();
////        String elementName = (String) o;
////
////        Queue<Entry<String>> queue = new LinkedList<>();
////        queue.add(root);
////
////        Entry<String> entry = null;
////        while (!queue.isEmpty()) {
////            entry = queue.poll();
////            if (elementName.equals(entry.elementName)) {
////                break;
////            } else {
////                if (entry.leftChild != null) queue.add(entry.leftChild);
////                if (entry.rightChild != null) queue.add(entry.rightChild);
////            }
////        }
////        if (entry == null) return false;
////        if (entry == entry.parent.leftChild) entry.parent.leftChild = null;
////        else entry.parent.rightChild = null;
////
////        queue.clear();
////        Deque<Entry<String>> stack = new LinkedList<>();
////        queue.add(entry);
////        while (!queue.isEmpty()) {
////            entry = queue.poll();
////            stack.add(entry);
////            if (entry.leftChild != null) queue.add(entry.leftChild);
////            if (entry.rightChild != null) queue.add(entry.rightChild);
////        }
////
////        while (!stack.isEmpty()) {
////            entry = stack.pollLast();
////            entry = null;
////            size--;
////        }
////        return true;
////    }
////
////    public String getParent(String s) {
////        Entry top = root;
////        String result="no element";
////        Queue<Entry> queue = new LinkedList<> ();
////        queue.add(top);
////        do{
////            if (top.elementName !=null)
////            {
////                if (top.elementName.equals(s))
////                {
////                    result = top.parent.elementName;
////                    break;
////                }
////            }
////            if (top.leftChild!=null) queue.add(top.leftChild);
////            if (top.rightChild!=null) queue.add(top.rightChild);
////            if (!queue.isEmpty()) top=queue.poll();
////        }while (!queue.isEmpty());
////        return result;
////    }
////
////
////    @Override
////    public boolean contains(Object o) {
////        Entry<String> top = root;
////        boolean result = false;
////        Queue<Entry> queue = new LinkedList<> ();
////        queue.add(top);
////        do{
////            top=queue.poll();
////            if (top.elementName !=null)
////            {
////                if (top.elementName.equals(o))
////                {
////                    result = true;
////                    break;
////                }
////            }
////            if (top.leftChild!=null) queue.add(top.leftChild);
////            if (top.rightChild!=null) queue.add(top.rightChild);
////
////        }while (!queue.isEmpty());
////        return result;
////    }
////
////    @Override
////    public String set(int i, String s) {
////        throw new UnsupportedOperationException();
////    }
////
////    @Override
////    public List<String> subList(int i, int i1) {
////        throw new UnsupportedOperationException();
////    }
////
////    @Override
////    protected void removeRange(int i, int i1) {
////        throw new UnsupportedOperationException();
////    }
////
////    @Override
////    public boolean addAll(int i, Collection<? extends String> collection) {
////        throw new UnsupportedOperationException();
////    }
////
////    @Override
////    public int size() {
////        if  (root==null){
////            return 0;
////        }
////        return size;
////    }
////
////    static class Entry<T> implements Serializable {
////        String elementName;
////        int lineNumber;
////        boolean availableToAddLeftChildren, availableToAddRightChildren;
////        Entry<T> parent, leftChild, rightChild;
////
////        public Entry(String elementName) {
////            this.elementName = elementName;
////            availableToAddLeftChildren = true;
////            availableToAddRightChildren = true;
////        }
////
////        void checkChildren() {
////            if (leftChild != null) {
////                availableToAddLeftChildren = false;
////            }
////            if (rightChild != null) {
////                availableToAddRightChildren = false;
////            }
////        }
////
////        boolean isAvailableToAddChildren() {
////            return availableToAddLeftChildren | availableToAddRightChildren;
////        }
////    }
////}
//
//
//public class CustomTree extends AbstractList implements Cloneable, Serializable {
//    Entry<String> root;
//    static int SIZE = 0;
//
//    static class Entry<T> implements Serializable {
//        String elementName;
//        int lineNumber;
//        boolean availableToAddLeftChildren;
//        boolean availableToAddRightChildren;
//        Entry<T> parent;
//        Entry<T> leftChild;
//        Entry<T> rightChild;
//
//        public Entry(String str) {
//            elementName = str;
//            availableToAddLeftChildren = true;
//            availableToAddRightChildren = true;
//        }
//
//        void checkChildren() {
//            if (leftChild != null) availableToAddLeftChildren = false;
//            if (rightChild != null) availableToAddRightChildren = false;
//        }
//
//        public boolean isAvailableToAddChildren() {
//            return availableToAddLeftChildren || availableToAddRightChildren;
//        }
//
//        public Entry findEntry(String s) {
//            ArrayDeque<Entry> deque = new ArrayDeque<>();
//            Entry x = this;
//            deque.add(x);
//            do {
//                if (!deque.isEmpty()) x = deque.poll();
//                if (x.elementName.equals(s)) return x;
//                if (x.leftChild != null) deque.add(x.leftChild);
//                if (x.rightChild != null) deque.add(x.rightChild);
//            } while (!deque.isEmpty());
//            return null;
//        }
//
//        public int size() {
//            ArrayDeque<Entry> deque = new ArrayDeque<>();
//            Entry x = this;
//            int result = 0;
//            deque.add(x);
//            do {
//                if (!deque.isEmpty()) x = deque.poll();
//                if (x.leftChild != null) {
//                    deque.add(x.leftChild);
//                    result += 1;
//                }
//                if (x.rightChild != null) {
//                    deque.add(x.rightChild);
//                    result += 1;
//                }
//            } while (!deque.isEmpty());
//            return result;
//        }
//    }
//
//    public CustomTree() {
//        root = new Entry<>("root");
//    }
//
//
//    public boolean add(String s) {
//        Entry x = root;
//        if (notAvailableToAdd(x)) {
//            makeAvailableToAdd(x);
//        }
//        boolean added = false;
//        ArrayDeque<Entry> deque = new ArrayDeque<>();
//        deque.add(x);
//        do {
//            if (!deque.isEmpty()) x = deque.poll();
//            if (x.leftChild != null) deque.add(x.leftChild);
//            else if (x.availableToAddLeftChildren) {
//                x.leftChild = new Entry(s);
//                x.leftChild.parent = x;
//                x.checkChildren();
//                added = true;
//                break;
//            }
//            if (x.rightChild != null) deque.add(x.rightChild);
//            else if (x.availableToAddRightChildren) {
//                x.rightChild = new Entry(s);
//                x.rightChild.parent = x;
//                x.checkChildren();
//                added = true;
//                break;
//            }
//        } while (!deque.isEmpty());
//        return false;
//    }
//
//    public boolean notAvailableToAdd(Entry x){
//        boolean result = true;
//        ArrayDeque<Entry> deque = new ArrayDeque<>();
//        deque.add(x);
//        do {
//            if (!deque.isEmpty()) x = deque.poll();
//            if (x.leftChild != null) deque.add(x.leftChild);
//            else if (x.availableToAddLeftChildren) {
//                result = false;
//            }
//            if (x.rightChild != null) deque.add(x.rightChild);
//            else if (x.availableToAddRightChildren) {
//                result = false;
//            }
//        } while (!deque.isEmpty());
//        return result;
//    }
//
//    public void makeAvailableToAdd(Entry entry){
//        ArrayDeque<Entry> deque = new ArrayDeque<>();
//        Entry x = root;
//        deque.add(x);
//        do {
//            if (!deque.isEmpty()) x = deque.poll();
//            if (x.leftChild == null) x.availableToAddLeftChildren = true;
//            else deque.add(x.leftChild);
//            if (x.rightChild == null) x.availableToAddRightChildren = true;
//            else deque.add(x.rightChild);
//        } while (!deque.isEmpty());
//    }
//
//    public boolean remove(Object o) {
//        String s = "";
//        boolean deleted = false;
//        try {
//            s = (String) o;
//        } catch (ClassCastException e) {
//            throw new UnsupportedOperationException();
//        }
//        Entry entry = root.findEntry(s);
//        if (entry.parent.leftChild != null && entry.parent.leftChild.equals(entry)) {
//            entry.parent.leftChild = null;
//            entry.parent.availableToAddLeftChildren = false;
//            deleted = true;
//        }
//        if (entry.parent.rightChild != null && entry.parent.rightChild.equals(entry)) {
//            entry.parent.rightChild = null;
//            entry.parent.availableToAddRightChildren = false;
//            deleted = true;
//        }
//        return deleted;
//    }
//
//    @Override
//    public int size() {
//        return root.size();
//    }
//
//    public String getParent(String s) {
//        Entry entry = root.findEntry(s);
//        if (entry == null) return null;
//        else return entry.parent.elementName;
//    }
//
//    @Override
//    public void add(int index, Object element) {
//        add((String) element);
//    }
//
//    public String get(int index) {
//        throw new UnsupportedOperationException();
//    }
//
//    public String set(int index, String element) {
//        throw new UnsupportedOperationException();
//    }
//
//    public String remove(int index) {
//        throw new UnsupportedOperationException();
//    }
//
//    public List<String> subList(int fromIndex, int toIndex) {
//        throw new UnsupportedOperationException();
//    }
//
//    protected void removeRange(int fromIndex, int toIndex) {
//        throw new UnsupportedOperationException();
//    }
//
//    public boolean addAll(int index, Collection c) {
//        throw new UnsupportedOperationException();
//    }
//}

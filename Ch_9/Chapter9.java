package Ch_9;

import java.util.*;

public class Chapter9 {
}

/*
<> diamond operator allowed only on right side
 */
class Sample{
    public static void main(String[] args) {
        ArrayList<String> lst = new ArrayList<>();
       // ArrayList <> list = new ArrayList<String> (); -> not valid
        Collection<String> list = new ArrayList<>();
        list.add("arun");
        list.remove("arun");
        list.add("a");
        list.add("b");
        System.out.println(list.size()); //2
        System.out.println(list.isEmpty()); //false
        System.out.println(list.contains("b")); //true
        list.clear();
        System.out.println(list.size()); //0

        //lopping and removing if met a condition
        list.add("arun");list.add("ak");list.add("kumar");
        list.removeIf(x->x.startsWith("a"));
        System.out.println(list); //kumar

        Map<String, Integer> map = new HashMap<>();
        map.put("arun", 90);
        map.put("bob", 40);
        map.put("anna", 35);
        map.entrySet().removeIf(entry -> entry.getValue() < 39);
        String maxCountName = map.entrySet().stream().max(Comparator.comparing(x->x.getValue())).map(x->x.getKey()).get();
        System.out.println(maxCountName); //arun
        System.out.println(map);  // {arun=90, bob=40}

        //equals operator
        // list compares order
        // set compares value
        //same with 2 sets gives true
        List<Integer> l1= List.of(1,2);
        List<Integer> l2= List.of(2,1);
        System.out.println(l1.equals(l2)); //false

    }
}
/*
List : 3 ways to create
 */
class ListExample{
    //immutable lists
    public static void main(String[] args) {
        String [] vals = {"arun","kumar"};
        List<String> l1 = Arrays.asList(vals);
        //l1.add("hm");  //UnsupportedOperationException runtime
        l1.set(0,"ARUN");
        System.out.println(l1 + "  : "+l1.getClass());
        System.out.println(Arrays.toString(vals)); // changes original string as well

        List<String> l2 = List.of(vals);
       // l2.add("hmm");  // UnsupportedOperationException runtime
        System.out.println(l2 + " : "+l2.getClass());

        List<String> l3= List.copyOf(l1);
        //l3.add("hmm");  // UnsupportedOperationException runtime
        System.out.println(l3 + " : "+l3.getClass());


        // Mutable lists

        List<String> l4= new ArrayList<>();
        l4.add("NY");
        l4.add(0,"IND");
        l4.set(1,"CA");
        //l4.set(3,"AUS"); //IndexOutOfBoundException
        System.out.println(l4);

        l4.replaceAll(x-> "IND");
        System.out.println(l4);

        //printing list & int array
        int [] arr= {1,2,3,4};
        List<Integer> ar = List.of(1,2,3,4);
        System.out.println(Arrays.toString(arr));
        System.out.println(ar);


        List<Integer> sample = new ArrayList<>();
        sample.add(1);
        sample.add(2);
        sample.add(3);
        sample.add(4);
        System.out.println(sample);
        sample.remove(2); //removes index
        System.out.println(sample);
        sample.remove(Integer.valueOf(2)); // removes element
        System.out.println(sample);

        //SET
        // 2 ways  - Set.of() , Set.CopyOf()
    }
}
//Queue  - add at end , remove at first
class QueueExample{
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(4);
        q.add(5);
        q.offer(6); //add


        q.remove();  // removes front 1
        q.poll(); // removes front 4
        System.out.println(q); // [5,6]

        System.out.println(q.peek()); //5
        System.out.println(q.element());//5

        System.out.println(q); // [5,6]

    }
}

//DeQueue
//Add / remove at front / end
class DequeueExample{
    public static void main(String[] args) {
        Deque<Integer> q = new LinkedList<>();
        q.addLast(1);
        q.offerLast(2);
        q.addFirst(0);
        System.out.println(q);
        q.pollFirst();
        q.removeFirst();
        System.out.println(q);
        System.out.println(q.peekFirst());

    }
}

//Dequeue as Stack - ArrayDequeue
class DequeStack{
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(3);
        stack.push(4);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack.peek());  //null
    }
}

/*
Map  - not part of collections
 */

class Dummy{
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("arun",1);
        map.put("kumar",2);
        map.put("kumar",3);

        System.out.println(map.entrySet());
        System.out.println(map.getOrDefault("ak",5));
        Integer replace = map.replace("kumar",20);
        System.out.println(replace);  //3
        map.forEach((a,b)-> System.out.println(a+b));
        map.entrySet().forEach(x-> System.out.println(x.getKey()));

        //merge function
        // if return is null , it removes from map
        // if computation is null , it maps directly
    }
}
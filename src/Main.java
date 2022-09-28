import java.util.*;

public class Main {

    public static void main(String[] args) {

      //  Collection arrayList = new Collection<>();
        /*
        List-ы - списки
        List - интерфейс
        Реализации (классы): ArrayList, LinkedList, Stack
        Обратиться по индексу

        Queue - очереди
        FIFO

        Set-ы - множества
        Set- интерфейс
        Уникальные, проверить наличие элемента в множестве
        Реализации: TreeSet, HashSet

        Map-ы - словари (пары ключ-значение)
        Реализации: HashMap, Hashtable, LinkedHashMap, TreeMap...

         */

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        long start = System.nanoTime();
        for(int i=0; i<100000; i++) {
            arrayList.add(0,i);
        }
        long end = System.nanoTime();
        System.out.println("ArrayList add to begin:  "+(end-start));

        start = System.nanoTime();
        for(int i=0; i<100000; i++) {
            linkedList.add(0,i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList add to begin: "+(end-start));

        start = System.nanoTime();
        for(int i=30000; i<60000; i++) {
            arrayList.get(i);
        }
        end = System.nanoTime();
        System.out.println("ArrayList get from the middle: "+(end-start));

        start = System.nanoTime();
        for(int i=30000; i<60000; i++) {
            linkedList.get(i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList get from the middle: "+(end-start));

        Stack<String> stack = new Stack<>();
        Queue<String> queue = new ArrayDeque<>();
        String[] str = {"1","2","3","4","5"};
        for(String s: str) {
            stack.push(s); // кладем в стек
            queue.offer(s);
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        while(!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }

        class Person implements Comparable<Person> {
            private String name;
            private Integer age;

            public Person(String name, Integer age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public int compareTo(Person o) {
                return o.age - this.age;
            }
        }

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Ivan",20));
        personList.add(new Person("Oleg",21));
        personList.add(new Person("Maria",23));

        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
              //  return o1.age - o2.age;
                return o1.name.compareTo(o2.name);
            }
        };

        Collections.sort(personList, comparator);


        Collections.binarySearch(arrayList,50000);
        Collections.sort(arrayList);


        // TreeSet
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        Collections.addAll(arrayList1,445,4,5,3,5,632,4,5,6);
        System.out.println("");
        TreeSet<Integer> treeSet = new TreeSet<>(arrayList1);
        for(Integer i: treeSet) {
            System.out.print(i + " ");
        }


       /* List<Person> personList = new ArrayList<>();
        personList.add(new Person("Ivan",20));
        personList.add(new Person("Oleg",21));
        personList.add(new Person("Maria",23));
        */
        TreeSet<Person> treeSet1 = new TreeSet<>(personList);
        for(Person p: treeSet1) {
            System.out.println(p.age + " " + p.name);
        }

        class Student implements Comparable<Student> {
            private String name;
            private Integer mark;

            public Student(String name, Integer mark) {
                this.name = name;
                this.mark = mark;
            }

            @Override
            public int compareTo(Student o) {
                return this.mark - o.mark;
            }
        }

        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("Ivan",20));
        students.add(new Student("Oleg",21));
        students.add(new Student("Alex",40));
        students.add(new Student("Natalia",24));
        students.add(new Student("Petr",18));
        students.add(new Student("Maria",23));
        System.out.println("------------");
        SortedSet<Student> result = students.tailSet(new Student("",20));
        for(Student s: result) {
            System.out.println(s.mark + " " + s.name);
        }
        // students.subset - подмножество

        Object object = new Object();
        System.out.println(object.hashCode());

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("apple","fruit");
        hashMap.put("apple","fruit");
        hashMap.put("apple","fruit");
        hashMap.put("lemon","fruit");
        hashMap.put("orange","fruit");
        hashMap.put("tomato","veget");
        System.out.println("---------------------");
        for(Map.Entry<String,String> o: hashMap.entrySet()) {
            System.out.println(o.getKey() + " " + o.getValue());
        }
        System.out.println("---------------------");
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(66,"Ivan");
        treeMap.put(66,"Ivan");
        treeMap.put(66,"Ivan");
        treeMap.put(858,"Petr");
        treeMap.put(100,"Maria");
        treeMap.put(822,"Oleg");
        for(Map.Entry<Integer,String> o: treeMap.entrySet()) {
            System.out.println(o.getKey() + " " + o.getValue());
        }
    }
}
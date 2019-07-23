public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addLast(0);
        System.out.println(list1);


        LinkedList<String> list = new LinkedList<>(new String[]{"a", "b", "c", "d"});
        System.out.println(list);
        list.addFirst("1");
        list.addLast("5");
        list.addByIndex("4", 4);
        list.addByIndex("2", 2);
        System.out.println(list);
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        list.removeByIndex(1);
        list.removeByIndex(5);
        System.out.println(list);
        list.swapTwoNodesByIndex(3, 0);
        System.out.println(list);
        System.out.println("list size " + list.getListSize());
    }
}

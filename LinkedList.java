public class LinkedList<E> {


    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }


    private int listSize = 0;
    private Node<E> head;
    private Node<E> tail;

    public LinkedList() {
    }

    public LinkedList(E[] arr) {
        for (E elemOfArray : arr) {
            addLast(elemOfArray);
        }
    }

    public void addFirst(E data) {
        head = new Node<E>(data, head);
        listSize++;
    }

    public void addLast(E data) {
        if (checkForEmpty()) {
            addFirst(data);
            return;
        }
        tail = nodeForGivenIndex(listSize - 1);
        tail.next = new Node<E>(data, null);
        listSize++;
    }

    public void addByIndex(E data, int index) {
        checkIfIndexAvailable(index);
        if (checkIfIsHead(index)) {
            addFirst(data);
            return;
        }
        if (checkIfIsLast(index)) {
            addLast(data);
            return;
        }
        Node<E> previousToIndexed = nodeForGivenIndex(index - 1);                   //if prev ссылается на 2, prev.next тогда это нода
        previousToIndexed.next = new Node<E>(data, previousToIndexed.next);         //с данными для новой и ссылкой на след, старую 3 (теперь 4).
        listSize++;                                                                 //а previousToIndexed.next до равно все еще сслыется на след после 2,
                                                                                    //теперь уже новую 3
    }

    public void removeFirst() {
        if (!(checkForEmpty())) {
            head = head.next;
            listSize--;
        } /*else {
            throw
        }*/
    }

    public void removeLast() {
        if (listSize == 1) {
            removeFirst();
            return;
        }
        if (!(checkForEmpty())) {
            Node<E> current = nodeForGivenIndex(listSize - 2);
            current.next = null;
            listSize--;
        }
    }

    public void removeByIndex(int index){
        checkIfIndexAvailable(index);
        if (checkIfIsHead(index)){
            removeFirst();
            return;
        }
        if (checkIfIsLast(index)){
            removeLast();
            return;
        }
        Node<E> currentNode = nodeForGivenIndex(index - 1);
        currentNode.next = currentNode.next.next;
        listSize--;
    }

    public void swapTwoNodesByIndex(int firstIndex, int secondIndex){
        checkIfIndexAvailable(firstIndex);
        checkIfIndexAvailable(secondIndex);
        Node<E> firstNode = nodeForGivenIndex(firstIndex);
        Node<E> secondNode = nodeForGivenIndex(secondIndex);

        if (firstNode==secondNode){}
        else{
            Node<E> prevToFirstNode = nodeForGivenIndex(firstIndex-1);
            Node<E> prevToSecondNode = nodeForGivenIndex(secondIndex-1);

            if (checkIfIsHead(firstIndex)){                                 //обмен ссылками пред на элементы
                head=secondNode;
            }
            else {
                prevToFirstNode.next=secondNode;}
            if(checkIfIsHead(secondIndex)){
                head=firstNode;
            }
            else {
                prevToSecondNode.next=firstNode;}

            Node<E> temp = secondNode.next;         //обмен ссылками на след.
            secondNode.next = firstNode.next;
            firstNode.next = temp;
        }
    }


    public Node<E> nodeForGivenIndex(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    private boolean checkIfIsHead(int index) {
        if (index == 0)
            return true;
        else {
            return false;
        }
    }

    private boolean checkIfIsLast(int index) {
        if (index == listSize)
            return true;
        else {
            return false;
        }
    }

    public boolean checkForEmpty() {
        return listSize == 0;
    }

    public int getListSize(){
        return listSize;
    }

    public void checkIfIndexAvailable(int index){
        if(index<0||index>=listSize){
            throw new IndexOutOfBoundsException("index ["+index+"] is out of current list size ["+getListSize()+"]" );
        }
    }

    public String toString(){
        if (listSize==0)
            return "List is empty";
        else{
            StringBuilder sb = new StringBuilder(0);
            Node<E> current = head;
            sb.append("[ ");
            while(current!=null){
                sb.append(current.data.toString()+" ");
                current=current.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }


}

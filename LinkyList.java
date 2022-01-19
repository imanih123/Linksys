package linkyList;

import java.lang.IllegalArgumentException;
import java.lang.IndexOutOfBoundsException;

public class LinkyList<T extends Comparable<T>> {

  private Node<T> head;
  private int size;

  private class Node<T> {

    // Data members
     T data;
     Node<T> next;

    // Constructor
    Node(T data) {
      this.data = data;
      this.next = null;
    }



  }


  public LinkyList() {
    head=null;
    size=0;
  }

  public LinkyList(LinkyList<T> anotherLinkyList) {

        if(anotherLinkyList == null){
          throw  new IllegalArgumentException();
        }

        Node current= anotherLinkyList.head;

        while (current != null){
          orderedInsert((T)current.data);
          current=current.next;
        }

  }

  public void orderedInsert(T newElement) {

    Node newNode = new Node(newElement);

    Node current = head;

    Node previous = null;


    //loop while current node is not null
    while(current != null) {

      //If newElement is less than current node data then brake the loop
      if(newElement.compareTo((T)current.data) < 0){
        break;
      }else{
        previous = current;
        current = current.next;
      }

    }

    //Linking current node to the next node of our newNode
    newNode.next = current;

    //if the current is equal to head then we make equal
    if(current == head){
      head = newNode;
    }else{
      previous.next = newNode;
    }

    size++;

  }

  public int listNumElements() {
    return size;
  }

  public T getElementAtIndex(int index) throws IndexOutOfBoundsException {

    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException();
    }

    T element = null;

    //if index equals to zero return head
    if (index == 0){
      element=head.data;
    }else{
      Node current=head;
      int currentIndex=0;

      //loop until we find the right index
      while (current != null){
          if (index == currentIndex){
            element= (T) current.data;
          }
          currentIndex++;
          current=current.next;
      }
    }

    return element;
  }

  public T lookForElement(T element) {


    Node<T> current=head;
    T e=null;

    //Loop until our current node is not null
    while (current != null){
        if (current.data.compareTo(element) == 0){
          e=current.data;
          break;
        }

        current=current.next;
    }

    return e;

  }

  public String toString() {
    String result="";
    Node current=head;

    while (current != null){
      result+= current.data+" ";

      current=current.next;

    }

    result=result.trim();

    return result;

  }

  public int getIndexOfElement(T element)  {

    Node<T> current=head;
    T e=null;
    int index=-1;
    int start=0;

    //Loop until our current node is not null
    while (current != null){
      if (current.data.compareTo(element) == 0){
        index = start;
        break;
      }

      start++;

      current=current.next;
    }

    return index;
  }

  public boolean elementRemove(T element) {


    Node current = head;

    Node previous = null;



    while(current != null) {

      //If the cuurent node is equal to the

      //given data value, then break the loop.

      if(current.data.equals(element)){
        break;
      }



      //Adjust the current and previous node.
      previous = current;
      current = current.next;

    }

    //If current node is null, then return false.

    if(current == null){
      return false;
    }


    //If the current node is head of the list, then

    //move the head of the list to its next node.

    if(current == head) {

      head = head.next;

    }else{

      previous.next =current.next;
    }




    return true;
  }

  public void removeElementWithIndex(int index){

    if(index<0 || index >=size){
      throw new IndexOutOfBoundsException();
    }

    Node<T> current=head;
    Node<T> previous=null;

    int start=0;

    //Loop until our current node is not null
    while (current != null){
      if (start == index){
        break;
      }

      start++;
      previous=current;
      current=current.next;
    }

    previous.next=current.next;

  }

  public void reset() {
      head=null;
      size=0;
  }

  public LinkyList<T> subList(int startIndex, int endIndex){

    if((startIndex<0 && startIndex>=size) || (endIndex<0 && endIndex>=size) ){
      throw  new IndexOutOfBoundsException();
    }

    if(startIndex>endIndex){
      return  new LinkyList<>();
    }

    LinkyList newList=new LinkyList<>();
    for (int i=startIndex;i<=endIndex;i++){
      //using getElementAtIndex to get the data and inserting in order
      T e= getElementAtIndex(i);
      newList.orderedInsert(e);

    }

    return  newList;

  }

  public int compareTo(LinkyList<T> anotherLinkyList) {

    if(anotherLinkyList == null){
      throw  new IllegalArgumentException();
    }

      //if the linked list have the same size we loop
      if(anotherLinkyList.size == size){

        for(int i=0;i<size;i++){
          T e=anotherLinkyList.getElementAtIndex(i);
          //if the element is not equal then return the corresponding value
          if (getElementAtIndex(i).compareTo(e) != 0){
            return getElementAtIndex(i).compareTo(e);
          }
        }

      }else if(size < anotherLinkyList.size){
        return  -1;
      }else {
        return  1;
      }


    return 0;
  }


}


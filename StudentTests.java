package tests;

import linkyList.LinkyList;
import org.junit.*;
import static org.junit.Assert.*;

public class StudentTests {

  /* Remove this comment and write your JUnit student tests in this class.
   *
   * Note that your student tests must be your OWN WORK.  Copying the public
   * tests and turning them in as your student tests (with minimal or no
   * changes) would be plagiarism, and sharing student tests, or working
   * together to write them, is prohibited.
   */

    // Adds a few elements to a list and check looking element.
    @Test public void testPublic1() {
        LinkyList<Integer> list=new LinkyList<>();
        list.orderedInsert(3);
        list.orderedInsert(4);
        list.orderedInsert(7);


        assertEquals(7, (int) list.lookForElement(7));
    }




    @Test public void testPublic2() {
        LinkyList<Integer> list=new LinkyList<>();
        list.orderedInsert(3);
        list.orderedInsert(4);
        list.orderedInsert(7);


        assertEquals(-1, (int) list.getIndexOfElement(8));
        assertEquals(0, (int) list.getIndexOfElement(3));
    }



    // Tests some situations for compareTo().
    @Test public void testPublic3() {
        LinkyList<Character> list= new LinkyList<>();
        LinkyList<Character> other= new LinkyList<>();

        list.orderedInsert('a');
        list.orderedInsert('b');
        list.orderedInsert('c');
        list.orderedInsert('i');
        list.orderedInsert('e');

        other.orderedInsert('a');
        other.orderedInsert('b');
        other.orderedInsert('c');
        other.orderedInsert('d');
        other.orderedInsert('e');

        assertTrue(list.compareTo(other) > 0);

    }

    //Testing exception in copy constructor
    @Test(expected= IllegalArgumentException.class) public void testPublic4() {
        LinkyList<Integer> list= new LinkyList<>(null);
    }

    //Testing exception in removeElementWithIndex
    @Test(expected= IndexOutOfBoundsException.class) public void testPublic5() {
        LinkyList<Integer> list=new LinkyList<>();
        list.orderedInsert(3);
        list.orderedInsert(4);
        list.orderedInsert(7);

        list.removeElementWithIndex(3);

    }


}

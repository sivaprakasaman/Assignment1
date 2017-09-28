/*Andrew Sivaprakasam
  CS0441
  Assignment 1
  Description: This is an test client of the Set implementation.
*/

package cs445.a1;

public class SetClient {

    //Initialize a new Set:


    public static void main(String[] args){
        SetInterface<String> testSet = new Set<>();
        String[] toAdd = new String[]{"Andrew","Matthew","Christina","Andrew","Dad"};
        SetInterface<String> testSet2 = new Set<>(toAdd); //Should not have any duplicates
        SetInterface<Object> emptySet = new Set<>();

        int howmany = testSet2.getCurrentSize();
        //Should print out 4, since Andrew is a repeat val
        System.out.println(howmany);
        //Should be true
        System.out.println(emptySet.isEmpty());

        Object[] inset = testSet2.toArray();
        String[] inset2 = new String[inset.length];

        for(int i = 0;i<inset.length;i++){
            inset2[i] = (String) inset[i];
            System.out.println(inset2[i]);
        }


        //Should print out 4 entries


        try {
            testSet2.add("Henry");
        }
        catch(SetFullException e){
            System.out.println("THIS SHOULD NOT BE HAPPENING");
        }

        System.out.println(testSet2.contains("Dad"));

        System.out.println("Removed: " + testSet2.remove());


        //testSet2.clear();

        Object[] inset3 = testSet2.toArray();
        String[] inset4 = new String[inset3.length];

        for(int i = 0;i<inset3.length;i++){
            inset4[i] = (String) inset3[i];
            System.out.println(inset4[i]);
        }



    }




}

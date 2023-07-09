
    import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

    public class WordOccurJavaDoc {
        //word exclusions if needed
        //private static final List<String> EXCLUDEWORDS=
        //Arrays.asList("and", "the", "what");

        /**
         *under the main method we are using the scanner to call a
         * the file TheRaven.txt from the file path.
         * Hashmap All the words from the file are put into a Hashmap
         * while loop is uses to scount through the words and add
         * when a word is repeated.
         * finally we put the word and the number of times it was repeated
         * where it is put into a list and collections.sort is used
         * to sort the words from most used to lease used words.
         * @throws FileNotFoundException
         */
        public static void main(String[] args) throws FileNotFoundException {
            //TreeMap<String, Integer> map = new TreeMap<String, Integer>();
            Scanner txtFile = new Scanner(new File("C:/Users/aaron/SoftwareDevOne/TheRaven.txt"));
            Map<String,Integer> map = new HashMap<String, Integer>();
            while(txtFile.hasNext()) {
                String word = txtFile.next();
                //if (EXCLUDEWORDS.contains(word))
                //continue;
                int count = 1;
                if(map.containsKey(word)) {
                    count = map.get(word) + 1;

                }
                map.put(word, count);
            }
            Set<Map.Entry<String, Integer>> set = map.entrySet();
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(set);
            Collections.sort( sortedList, new Comparator<Map.Entry<String, Integer>>(){
                /**
                 *
                 * @param a the first object to be compared.
                 * @param b the second object to be compared.
                 * @return
                 */
                public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                    return (b.getValue()).compareTo(a.getValue());
                }

            });
            //txtFile.close();
            /**
             *the final count and word is printed in order.
             */
            System.out.println("WORDS " + " | "+"FREQUENCY");
            for(Map.Entry<String, Integer> i:sortedList){
                System.out.println(i.getKey()+" = "+i.getValue());
                //for (Map.Entry<String, Integer> entry: map.entrySet()){
                //System.out.println(entry);

            }
        }
    }


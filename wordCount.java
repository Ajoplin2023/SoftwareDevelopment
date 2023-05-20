import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class wordCount {
    //word exclusions if needed
    //private static final List<String> EXCLUDEWORDS=
            //Arrays.asList("and", "the", "what");
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
                    public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                            return (b.getValue()).compareTo(a.getValue());
                        }

                });
        //txtFile.close();
            System.out.println("WORDS " + " | "+"FREQUENCY");
        for(Map.Entry<String, Integer> i:sortedList){
            System.out.println(i.getKey()+" = "+i.getValue());
        //for (Map.Entry<String, Integer> entry: map.entrySet()){
            //System.out.println(entry);

        }
    }
}

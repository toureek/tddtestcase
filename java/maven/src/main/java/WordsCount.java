import java.util.*;

/**
 * Created by jgyang on 17/03/2017.
 */
public class WordsCount {

    public WordsCount() {
        // Do nothing...
    }


//    public static void main(String args[]) {
//        WordsCount wc = new WordsCount();
//        String result = wc.constructionData("When the I was small and the car I was When");
//        System.out.print(result);
//    }


    public String constructionData(String input) {
        Map hashmap = new HashMap();

        // 1st split contentStr for removing single-whitespace
        String[] strList = input.split(" ");
        for (String item : strList) {
            String strTrimed = item.trim();  // remove all whitespace for each split word

            if (strTrimed.length() < 1) {  // for example: [""]
                continue;
            }

            if (hashmap.containsKey(strTrimed)) {
                Integer wordAppearCount = (Integer) hashmap.get(strTrimed);
                hashmap.remove(strTrimed);
                hashmap.put(strTrimed, wordAppearCount+1);
            }
            else {
                hashmap.put(strTrimed, 1);  // construct a key-value object
            }
        }

        //  sorting
        List<Map.Entry<String, Integer>> itemList = new ArrayList<Map.Entry<String, Integer>>(hashmap.entrySet());
        Collections.sort(itemList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> objA, Map.Entry<String, Integer> objB) {
                if (objB.getValue() == objA.getValue()) {
                    return (objA.getKey()).toString().compareTo(objB.getKey());  // when value same; then key ASC
                }

                return (objB.getValue() - objA.getValue());  // value DESC
            }
        });

        //  print object after sorting
        String result = "";
        for (int i = 0; i < itemList.size(); i++) {
            String content = itemList.get(i).toString();
            result += content.replace("=", " ") + "\n";
        }

        return result;
    }
}

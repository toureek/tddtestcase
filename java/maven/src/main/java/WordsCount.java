import java.util.*;

/**
 * Created by jgyang on 17/03/2017.
 */
public class WordsCount {

    public WordsCount() {
        // Do nothing...
    }

    public static void main(String args[]) {
        String input = "When the I was small and the car I was When  I  I  and and and car was When ILL L I   ";
        WordsCount wc = new WordsCount();
        wc.calculateAndPrintWordsAppearCountResultFromInput(input);
    }

    private void calculateAndPrintWordsAppearCountResultFromInput(String input) {
        if (WordsCount.checkInputContentAvaliable(input)) {
            HashMap hashMap = convertInputToWordsCountHashmap(input);
            List list = sortWordsCountHashmapToList(hashMap);
            String result = finalResultString(list);
            System.out.print(result);
        }
        else {
            System.out.print("Error");
        }
    }

    public static boolean checkInputContentAvaliable(String input) {
        return  input != null && input.trim().length() > 0;
    }

    private HashMap convertInputToWordsCountHashmap(String input) {
        HashMap hashmap = new HashMap();
        String[] strList = input.split(" ");
        for (String words : strList) {
            String key = words.trim();
            modifyValueInHashmap(key, hashmap);
        }

        return hashmap;
    }

    private void modifyValueInHashmap(String key, HashMap hashmap) {
        if (!WordsCount.checkInputContentAvaliable(key) || hashmap == null) {
            return;
        }

        if (hashmap.containsKey(key)) {
            Integer wordAppearCount = (Integer)hashmap.get(key);
            hashmap.remove(key);
            hashmap.put(key, wordAppearCount+1);
        }  else {
            hashmap.put(key, 1);
        }
    }

    private List sortWordsCountHashmapToList(HashMap inputMap) {
        List<Map.Entry<String, Integer>> itemList = new ArrayList<Map.Entry<String, Integer>>(inputMap.entrySet());
        Collections.sort(itemList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> objA, Map.Entry<String, Integer> objB) {
                if (objB.getValue() == objA.getValue()) {
                    return (objA.getKey()).toString().compareTo(objB.getKey());  // when value same; then key ASC
                }

                return (objB.getValue() - objA.getValue());  // value DESC
            }
        });

        return itemList;
    }

    private String finalResultString(List inputList) {
        String result = "";
        for (int i = 0; i < inputList.size(); i++) {
            String content = inputList.get(i).toString();
            result += content.replace("=", " ") + "\n";
        }

        return result;
    }
}

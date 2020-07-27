import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;

public class WordFrequencyGame {

    public String getResult(String inputStr) {

        try {

            String[] words = inputStr.split("\\s+");

            //List<Input> inputList = new ArrayList<>();

            HashMap<String, Integer> inputMap = new HashMap<>();
            for (String word : words) {
                if (inputMap.containsKey(word)) {
                    inputMap.put(word, inputMap.get(word) + 1);
                }
                else{
                    inputMap.put(word, 1);
                }
            }

            List<Input> list = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
                Input input = new Input(entry.getKey(), entry.getValue());
                list.add(input);
            }

            list.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

            StringJoiner joiner = new StringJoiner("\n");
            for (Input w : list) {
                String s = w.getValue() + " " + w.getWordCount();
                joiner.add(s);
            }
            return joiner.toString();
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    private Map<String, List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> map = new HashMap<>();
        for (Input input : inputList) {

            if (!map.containsKey(input.getValue())) {
                ArrayList arr = new ArrayList<>();
                arr.add(input);
                map.put(input.getValue(), arr);
            } else {
                map.get(input.getValue()).add(input);
            }
        }
        return map;
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    public String getResult(String inputStr) {

        String[] words = inputStr.split("\\s+");

        HashMap<String, Integer> inputMap = getStringIntegerHashMap(words);

        List<Input> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            Input input = new Input(entry.getKey(), entry.getValue());
            list.add(input);
        }

        list.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

        return getString(list);

    }

    private String getString(List<Input> list) {
        return list.stream()
                .map(input -> String.format("%s %s", input.getValue(), input.getWordCount()))
                .collect(Collectors.joining("\n"));
    }

    private HashMap<String, Integer> getStringIntegerHashMap(String[] words) {
        HashMap<String, Integer> inputMap = new HashMap<>();
        for (String word : words) {
            if (inputMap.containsKey(word)) {
                inputMap.put(word, inputMap.get(word) + 1);
            } else {
                inputMap.put(word, 1);
            }
        }
        return inputMap;
    }
}

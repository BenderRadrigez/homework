package CategoryOfWords;

import java.util.Random;

public class Fruits {
    String[] words = {"яблоко", "апельсин", "лимон", "лайм", "груша", "мандарин", "виноград",
            "грейпфрут", "персик", "банан", "абрикос", "манго", "нектарин"};

    public String word = words[new Random().nextInt(words.length)];
}

package CategoryOfWords;

import java.util.Random;

public class Colors {
    String[] words = {"красный", "оранжевый", "желтый", "зеленый", "синий", "голубой", "фиолетовый", "белый", "черный",
            "коричневый"};
    public String word = words[new Random().nextInt(words.length)];
}

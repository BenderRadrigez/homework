package CategoryOfWords;

import java.util.Random;

public class Figure {
    String[] words = {"квадрат", "треугольник", "прямоугольник", "круг", "эллипс", "ромб","трапеция",
            "параллелограмм", "пятиугольник", "шестиугольник", "восьмиугольник"};

    public String word = words[new Random().nextInt(words.length)];
}

package ru.kk.collections._main;

import ru.kk.collections.entity.Animal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("cow", 1));
        animals.add(new Animal("pig", 2));
        animals.add(new Animal("cat", 3));
        animals.add(new Animal("dog", 4));
        animals.add(new Animal("duck", 5));
        animals.add(new Animal("tiger", 6));
        animals.add(new Animal("zebra", 7));
        animals.add(new Animal("elephant", 8));
        animals.add(new Animal("hippo", 9));
        animals.add(new Animal("horse", 10));
        animals.add(new Animal("lion", 11));

        // Вывод на экран всех животных из коллекции в порядке возрастания их возраста
        animals.stream()
                .sorted(Comparator.comparingInt(Animal::getAge))
                .forEach(animal -> System.out.println("Животное: " + animal.getName() + ", возраст: " + animal.getAge()));
        System.out.println("-----------------------------");

        // Создание Map из коллекции животных (Ключ - название животного, Значение - экземпляр животного)
        Map<String, Animal> animalMap = new HashMap<>();
        animals.forEach(animal -> animalMap.put(animal.getName(), animal));

        // Вывод всех пар ключ-значение в консоль
        animalMap.forEach((name, animal) -> System.out.println("Животное: " + name + ", возраст: " + animal.getAge()));
        System.out.println("-----------------------------");

        // Вывод названий всех животных одной строкой (используя reduce())
        String names = animals.stream()
                .map(Animal::getName)
                .reduce((name1, name2) -> name1 + ", " + name2)
                .orElse("");
        System.out.println("Названия животных: " + names);
    }
}

package org.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DayEleven implements Day {
    @Override
    public String getData() {
        return rawData();
    }

    private Map<Integer, Monkey> generateMonkeyMap() {
        List<String> lines = List.of(getData().split("\n"));

        Map<Integer, Monkey> monkeyMap = new TreeMap<>();

        StringBuilder rawMonkeyStringBuilder = new StringBuilder();
        for (String line : lines) {
            if (line.isEmpty() || line.equals("----")) {
                String monkeyLine = rawMonkeyStringBuilder.toString();
                Monkey monkey = new Monkey(monkeyLine);
                monkeyMap.put(monkey.monkeyIndex, monkey);
                rawMonkeyStringBuilder = new StringBuilder();
            } else {
                rawMonkeyStringBuilder.append(line.trim()).append("::::");
            }
        }

        return monkeyMap;
    }

    @Override
    public String process() {

        Map<Integer, Monkey> monkeyMap = generateMonkeyMap();

        int rounds = 20;

        for (int i = 0; i < rounds; i++) {
            for(Map.Entry<Integer, Monkey> monkeyEntry : monkeyMap.entrySet()) {
                monkeyEntry.getValue().inspectItems(monkeyMap, BigInteger.ZERO);
            }

//            System.out.printf("After round %s%n", i+1);
//            for(Map.Entry<Integer, Monkey> monkeyEntry : monkeyMap.entrySet()) {
//                monkeyEntry.getValue().monkeyRoundResult();
//            }
//            System.out.println();
        }

        List<BigInteger> highestTwo = monkeyMap.values().stream().map(monkey -> monkey.inspectCount).sorted(Comparator.reverseOrder()).limit(2).toList();

        return String.format("level of monkey %s business after %s rounds", highestTwo.get(0).multiply(highestTwo.get(1)), rounds);
    }

    public static class Monkey {
        int monkeyIndex;
        Queue<BigInteger> items;
        String operationFactor;
        String mathSignal;
        BigInteger testNumber;
        int trueMonkey;
        int falseMonkey;

        BigInteger inspectCount = BigInteger.ZERO;

        public Monkey(String line) {
            // Monkey 0:::::
            // Starting items: 79, 98::::
            // Operation: new = old * 19::::
            // Test: divisible by 23::::
            // If true: throw to monkey 2::::
            // If false: throw to monkey 3::::

            // Pattern pattern = Pattern.compile("Monkey (\\d+):::::Starting items: 79, 98::::Operation: new = old * (\\d+)::::Test: divisible by (\\d+)::::If true: throw to monkey (\\d+)::::If false: throw to monkey (\\d+)::::");
            String[] splitted = line.split("::::");
            this.monkeyIndex = Integer.parseInt(splitted[0].replace("Monkey ", ""));
            String[] mathSplit = splitted[2].replace("Operation: new = old ", "").split(" ");
            this.mathSignal = mathSplit[0];
            this.operationFactor = mathSplit[1];
            this.testNumber = BigInteger.valueOf(Long.parseLong(splitted[3].replace("Test: divisible by ", "")));
            this.trueMonkey = Integer.parseInt(splitted[4].replace("If true: throw to monkey ", ""));
            this.falseMonkey = Integer.parseInt(splitted[5].replace("If false: throw to monkey ", ""));

            this.items = new LinkedList<>();
            String[] stressItems = splitted[1].replace(":Starting items: ", "").split(", ");
            for (String item: stressItems) {
                this.items.add(BigInteger.valueOf(Long.parseLong(item)));
            }

        }

        public void inspectItems(Map<Integer, Monkey> monkeyMap, BigInteger factor) {


            for (BigInteger item : items) {
                BigInteger worryLevel = BigInteger.ZERO;
                BigInteger old = item;
                BigInteger valueToWorkWith = this.operationFactor.equals("old") ? item : BigInteger.valueOf(Long.parseLong(this.operationFactor));

                switch (this.mathSignal) {
                    case "*" -> worryLevel = old.multiply(valueToWorkWith);
                    case "+" -> worryLevel = old.add(valueToWorkWith);
                }

                BigInteger boredValue;
                if (factor.equals(BigInteger.ZERO)) {
                    boredValue = worryLevel.divide(BigInteger.valueOf(3L));
                    // TODO Check if floor
                } else {
                    boredValue = worryLevel.mod(factor);
                }

                if (boredValue.mod(this.testNumber).equals(BigInteger.ZERO)) {
                    monkeyMap.get(this.trueMonkey).items.add(boredValue);
                } else {
                    monkeyMap.get(this.falseMonkey).items.add(boredValue);
                }

                this.inspectCount = this.inspectCount.add(BigInteger.ONE);

//                System.out.printf("");

            }
            this.items.clear();
        }

        public void monkeyRoundResult() {
            System.out.printf("Monkey %s: %s -> %s%n", this.monkeyIndex, this.items.stream().map(BigInteger::toString).collect(Collectors.joining(", ")), this.inspectCount);
        }
    }

    @Override
    public String processMore() {
        Map<Integer, Monkey> monkeyMap = generateMonkeyMap();

        int rounds = 10000;

        BigInteger factor = BigInteger.ONE;
        for (int i = 0; i < monkeyMap.size(); i++)
            factor = factor.multiply(monkeyMap.get(i).testNumber);

        for (int i = 0; i < rounds; i++) {
            for(Map.Entry<Integer, Monkey> monkeyEntry : monkeyMap.entrySet()) {
                monkeyEntry.getValue().inspectItems(monkeyMap, factor);
            }

            System.out.printf("After round %s%n", i+1);
            for(Map.Entry<Integer, Monkey> monkeyEntry : monkeyMap.entrySet()) {
                monkeyEntry.getValue().monkeyRoundResult();
            }
            System.out.println();
        }

        List<BigInteger> highestTwo = monkeyMap.values().stream().map(monkey -> monkey.inspectCount).sorted(Comparator.reverseOrder()).limit(2).toList();

        return String.format("level of monkey business %s after %s rounds", highestTwo.get(0).multiply(highestTwo.get(1)), rounds);
    }

    @Override
    public String rawData() {
        return """
                Monkey 0:
                  Starting items: 75, 63
                  Operation: new = old * 3
                  Test: divisible by 11
                    If true: throw to monkey 7
                    If false: throw to monkey 2
                                
                Monkey 1:
                  Starting items: 65, 79, 98, 77, 56, 54, 83, 94
                  Operation: new = old + 3
                  Test: divisible by 2
                    If true: throw to monkey 2
                    If false: throw to monkey 0
                                
                Monkey 2:
                  Starting items: 66
                  Operation: new = old + 5
                  Test: divisible by 5
                    If true: throw to monkey 7
                    If false: throw to monkey 5
                                
                Monkey 3:
                  Starting items: 51, 89, 90
                  Operation: new = old * 19
                  Test: divisible by 7
                    If true: throw to monkey 6
                    If false: throw to monkey 4
                                
                Monkey 4:
                  Starting items: 75, 94, 66, 90, 77, 82, 61
                  Operation: new = old + 1
                  Test: divisible by 17
                    If true: throw to monkey 6
                    If false: throw to monkey 1
                                
                Monkey 5:
                  Starting items: 53, 76, 59, 92, 95
                  Operation: new = old + 2
                  Test: divisible by 19
                    If true: throw to monkey 4
                    If false: throw to monkey 3
                                
                Monkey 6:
                  Starting items: 81, 61, 75, 89, 70, 92
                  Operation: new = old * old
                  Test: divisible by 3
                    If true: throw to monkey 0
                    If false: throw to monkey 1
                                
                Monkey 7:
                  Starting items: 81, 86, 62, 87
                  Operation: new = old + 8
                  Test: divisible by 13
                    If true: throw to monkey 3
                    If false: throw to monkey 5
                ----""";
    }

    @Override
    public String exampleRawData() {
        return """
                Monkey 0:
                  Starting items: 79, 98
                  Operation: new = old * 19
                  Test: divisible by 23
                    If true: throw to monkey 2
                    If false: throw to monkey 3
                                
                Monkey 1:
                  Starting items: 54, 65, 75, 74
                  Operation: new = old + 6
                  Test: divisible by 19
                    If true: throw to monkey 2
                    If false: throw to monkey 0
                                
                Monkey 2:
                  Starting items: 79, 60, 97
                  Operation: new = old * old
                  Test: divisible by 13
                    If true: throw to monkey 1
                    If false: throw to monkey 3
                                
                Monkey 3:
                  Starting items: 74
                  Operation: new = old + 3
                  Test: divisible by 17
                    If true: throw to monkey 0
                    If false: throw to monkey 1
                ----""";
    }
}

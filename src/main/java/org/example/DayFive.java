package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class DayFive implements Day {
    @Override
    public String getData() {
        return rawData();
    }

    @Override
    public String process() {

        CrateMovementSystem crateMovementSystem = new CrateMovementSystem();

        Arrays.stream(getData().split("\n")).forEach(crateMovementSystem::addInstruction);

        String result = crateMovementSystem.performMovements();

        return String.format("Creates on top of the stack : %s", result);
    }

    @Override
    public String processMore() {
        return null;
    }

    public static class CrateMovementSystem {

        // 100 Rows and 9 Columns
//        private String[][] stacks = new String[100][9];
//        private String[][] stacksExample = new String[10][3];

        private final List<Instruction> instructions = new ArrayList<>();

        private final Map<Integer, List<String>> map = new HashMap<>();

        public CrateMovementSystem() {

//
//            List<String> stackOne = new ArrayList<>();
//            stackOne.add(0, "Z");
//            stackOne.add(1, "N");
//
//            List<String> stackTwo = new ArrayList<>();
//            stackTwo.add(0, "M");
//            stackTwo.add(1, "C");
//            stackTwo.add(2, "D");
//
//            List<String> stackThree = new ArrayList<>();
//            stackThree.add(0, "P");
//            map.put(0, stackOne);
//            map.put(1, stackTwo);
//            map.put(2, stackThree);

            List<String> StackOne = new ArrayList<>();
            StackOne.add(0, "J");
            StackOne.add(1, "H");
            StackOne.add(2, "G");
            StackOne.add(3, "M");
            StackOne.add(4, "Z");
            StackOne.add(5, "N");
            StackOne.add(6, "T");
            StackOne.add(7, "F");

            List<String> StackTwo = new ArrayList<>();
            StackTwo.add(0, "V");
            StackTwo.add(1, "W");
            StackTwo.add(2, "J");

            List<String> StackThree = new ArrayList<>();
            StackThree.add(0, "G");
            StackThree.add(1, "V");
            StackThree.add(2, "L");
            StackThree.add(3, "J");
            StackThree.add(4, "B");
            StackThree.add(5, "T");
            StackThree.add(6, "H");

            List<String> StackFour = new ArrayList<>();
            StackFour.add(0, "B");
            StackFour.add(1, "P");
            StackFour.add(2, "J");
            StackFour.add(3, "N");
            StackFour.add(4, "C");
            StackFour.add(5, "D");
            StackFour.add(6, "V");
            StackFour.add(7, "L");

            List<String> StackFive = new ArrayList<>();
            StackFive.add(0, "F");
            StackFive.add(1, "W");
            StackFive.add(2, "S");
            StackFive.add(3, "M");
            StackFive.add(4, "P");
            StackFive.add(5, "R");
            StackFive.add(6, "G");

            List<String> StackSix = new ArrayList<>();
            StackSix.add(0, "G");
            StackSix.add(1, "H");
            StackSix.add(2, "C");
            StackSix.add(3, "F");
            StackSix.add(4, "B");
            StackSix.add(5, "N");
            StackSix.add(6, "V");
            StackSix.add(7, "M");

            List<String> StackSeven = new ArrayList<>();
            StackSeven.add(0, "D");
            StackSeven.add(1, "H");
            StackSeven.add(2, "G");
            StackSeven.add(3, "M");
            StackSeven.add(4, "R");


            List<String> StackEight = new ArrayList<>();
            StackEight.add(0, "H");
            StackEight.add(1, "N");
            StackEight.add(2, "M");
            StackEight.add(3, "V");
            StackEight.add(4, "Z");
            StackEight.add(5, "D");

            List<String> StackNine = new ArrayList<>();
            StackNine.add(0, "G");
            StackNine.add(1, "N");
            StackNine.add(2, "F");
            StackNine.add(3, "H");

            this.map.put(0,StackOne);
            this.map.put(1,StackTwo);
            this.map.put(2,StackThree);
            this.map.put(3,StackFour);
            this.map.put(4,StackFive);
            this.map.put(5,StackSix);
            this.map.put(6,StackSeven);
            this.map.put(7,StackEight);
            this.map.put(8,StackNine);

        }

        public void addInstruction(String line) {
            this.instructions.add(new Instruction(line));
        }


        public String performMovements() {
            System.out.println("movements");

            for(Instruction inst : this.instructions) {
                int amount = inst.getAmount();
//                for (int i = 0; i < amount; i++) {
//                    String cont = this.map.get(inst.from-1).pop();
//                    this.map.get(inst.to-1).add(cont);
//                }
                int size = this.map.get(inst.from-1).size();
                List<String> selectedCont = new ArrayList<>( this.map.get(inst.from-1).subList(size-amount, size));
                this.map.get(inst.from - 1).subList(size - amount, size).clear();
                this.map.get(inst.to-1).addAll(selectedCont);
            }

            StringBuilder result = new StringBuilder();

            for(Map.Entry<Integer, List<String>> column : this.map.entrySet()) {
               result.append(column.getValue().get(column.getValue().size()-1));
            }

            return result.toString();
        }

    }

    public static class Instruction {

        private final int amount;
        private final int from;
        private final int to;

        public Instruction(String rawInstruction) {
            String formattedInstruction = rawInstruction.replace("move ", "").replace(" from ", ",").replace(" to ", ",");
            String[] splitted = formattedInstruction.split(",");
            this.amount = Integer.parseInt(splitted[0]);
            this.from = Integer.parseInt(splitted[1]);
            this.to = Integer.parseInt(splitted[2]);
        }

        public int getAmount() {
            return amount;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }
    }

    @Override
    public String rawData() {
        return """
                move 6 from 4 to 3
                move 5 from 8 to 9
                move 1 from 4 to 5
                move 1 from 4 to 5
                move 2 from 2 to 7
                move 2 from 1 to 6
                move 9 from 6 to 1
                move 12 from 3 to 5
                move 1 from 8 to 4
                move 3 from 1 to 5
                move 1 from 6 to 7
                move 10 from 5 to 2
                move 14 from 5 to 1
                move 8 from 7 to 9
                move 11 from 2 to 9
                move 1 from 3 to 9
                move 11 from 1 to 5
                move 2 from 1 to 9
                move 1 from 4 to 8
                move 6 from 1 to 5
                move 1 from 8 to 3
                move 16 from 5 to 1
                move 4 from 1 to 3
                move 1 from 5 to 6
                move 4 from 3 to 4
                move 1 from 6 to 7
                move 21 from 9 to 6
                move 2 from 1 to 9
                move 2 from 4 to 9
                move 5 from 9 to 4
                move 9 from 1 to 6
                move 6 from 4 to 6
                move 1 from 6 to 2
                move 1 from 7 to 6
                move 1 from 3 to 2
                move 8 from 6 to 9
                move 3 from 1 to 8
                move 1 from 2 to 1
                move 13 from 6 to 3
                move 1 from 1 to 9
                move 2 from 1 to 6
                move 3 from 8 to 4
                move 4 from 4 to 9
                move 3 from 1 to 3
                move 22 from 9 to 8
                move 1 from 2 to 9
                move 6 from 8 to 9
                move 15 from 6 to 5
                move 5 from 8 to 9
                move 11 from 9 to 8
                move 13 from 5 to 1
                move 1 from 6 to 5
                move 1 from 9 to 3
                move 21 from 8 to 3
                move 3 from 5 to 3
                move 11 from 1 to 2
                move 25 from 3 to 1
                move 5 from 1 to 7
                move 20 from 1 to 7
                move 1 from 6 to 7
                move 16 from 3 to 9
                move 8 from 9 to 6
                move 1 from 1 to 5
                move 5 from 9 to 4
                move 2 from 2 to 1
                move 2 from 9 to 4
                move 1 from 9 to 4
                move 1 from 8 to 4
                move 1 from 5 to 2
                move 3 from 4 to 6
                move 1 from 4 to 7
                move 9 from 7 to 6
                move 5 from 4 to 6
                move 7 from 7 to 2
                move 1 from 1 to 6
                move 11 from 2 to 5
                move 10 from 5 to 1
                move 1 from 6 to 8
                move 1 from 5 to 7
                move 24 from 6 to 1
                move 12 from 1 to 4
                move 12 from 4 to 8
                move 2 from 2 to 7
                move 3 from 7 to 2
                move 5 from 2 to 8
                move 9 from 8 to 9
                move 9 from 8 to 5
                move 1 from 9 to 1
                move 14 from 1 to 8
                move 11 from 7 to 9
                move 4 from 1 to 3
                move 7 from 1 to 2
                move 3 from 3 to 7
                move 12 from 9 to 7
                move 8 from 7 to 2
                move 4 from 9 to 2
                move 1 from 3 to 6
                move 5 from 5 to 9
                move 14 from 2 to 1
                move 8 from 9 to 4
                move 6 from 4 to 5
                move 5 from 5 to 7
                move 1 from 8 to 2
                move 2 from 4 to 6
                move 4 from 7 to 3
                move 10 from 8 to 4
                move 2 from 3 to 6
                move 7 from 7 to 6
                move 10 from 4 to 8
                move 5 from 1 to 6
                move 8 from 2 to 1
                move 7 from 6 to 8
                move 9 from 6 to 5
                move 16 from 1 to 6
                move 2 from 3 to 9
                move 1 from 7 to 4
                move 2 from 9 to 1
                move 14 from 6 to 7
                move 1 from 6 to 3
                move 2 from 6 to 3
                move 9 from 5 to 7
                move 3 from 1 to 6
                move 3 from 3 to 7
                move 5 from 5 to 9
                move 3 from 6 to 2
                move 1 from 6 to 2
                move 12 from 8 to 2
                move 5 from 2 to 1
                move 2 from 1 to 3
                move 25 from 7 to 1
                move 1 from 4 to 6
                move 2 from 3 to 9
                move 26 from 1 to 9
                move 2 from 1 to 8
                move 1 from 6 to 8
                move 1 from 7 to 1
                move 7 from 8 to 1
                move 7 from 1 to 5
                move 1 from 1 to 2
                move 2 from 8 to 6
                move 32 from 9 to 8
                move 1 from 6 to 5
                move 5 from 2 to 9
                move 1 from 9 to 7
                move 24 from 8 to 3
                move 1 from 6 to 9
                move 3 from 2 to 5
                move 1 from 7 to 9
                move 4 from 9 to 3
                move 8 from 8 to 7
                move 18 from 3 to 7
                move 20 from 7 to 8
                move 6 from 8 to 9
                move 6 from 5 to 1
                move 8 from 9 to 4
                move 3 from 5 to 4
                move 8 from 8 to 4
                move 2 from 5 to 2
                move 3 from 1 to 5
                move 4 from 3 to 7
                move 6 from 2 to 9
                move 3 from 3 to 6
                move 6 from 4 to 5
                move 2 from 6 to 3
                move 1 from 3 to 1
                move 4 from 3 to 8
                move 8 from 4 to 3
                move 4 from 3 to 7
                move 4 from 4 to 5
                move 4 from 9 to 5
                move 3 from 3 to 4
                move 3 from 4 to 9
                move 1 from 1 to 4
                move 2 from 1 to 5
                move 7 from 7 to 8
                move 4 from 7 to 4
                move 1 from 6 to 7
                move 1 from 1 to 5
                move 1 from 3 to 8
                move 11 from 5 to 9
                move 17 from 9 to 8
                move 13 from 8 to 4
                move 1 from 4 to 8
                move 4 from 7 to 1
                move 4 from 8 to 3
                move 6 from 5 to 4
                move 3 from 3 to 6
                move 2 from 1 to 9
                move 1 from 9 to 5
                move 1 from 3 to 5
                move 5 from 5 to 9
                move 2 from 1 to 8
                move 21 from 8 to 6
                move 2 from 8 to 4
                move 4 from 9 to 6
                move 1 from 9 to 7
                move 19 from 4 to 1
                move 28 from 6 to 5
                move 7 from 4 to 2
                move 28 from 5 to 3
                move 1 from 9 to 4
                move 1 from 4 to 2
                move 1 from 7 to 8
                move 1 from 8 to 9
                move 13 from 1 to 3
                move 8 from 2 to 8
                move 3 from 1 to 2
                move 5 from 8 to 5
                move 1 from 2 to 7
                move 1 from 9 to 7
                move 1 from 2 to 3
                move 2 from 7 to 9
                move 1 from 2 to 6
                move 1 from 9 to 1
                move 9 from 3 to 9
                move 3 from 9 to 1
                move 1 from 6 to 8
                move 21 from 3 to 7
                move 7 from 9 to 4
                move 2 from 4 to 2
                move 1 from 8 to 6
                move 7 from 1 to 4
                move 7 from 7 to 8
                move 4 from 5 to 9
                move 10 from 7 to 1
                move 7 from 3 to 9
                move 1 from 7 to 9
                move 1 from 5 to 3
                move 3 from 3 to 5
                move 10 from 4 to 2
                move 1 from 3 to 7
                move 2 from 4 to 9
                move 3 from 9 to 1
                move 3 from 7 to 1
                move 1 from 6 to 4
                move 1 from 1 to 2
                move 1 from 3 to 4
                move 2 from 4 to 3
                move 1 from 7 to 4
                move 4 from 8 to 9
                move 1 from 4 to 9
                move 3 from 1 to 9
                move 12 from 1 to 7
                move 2 from 9 to 5
                move 12 from 9 to 7
                move 5 from 5 to 1
                move 1 from 8 to 5
                move 4 from 1 to 4
                move 1 from 9 to 6
                move 1 from 3 to 4
                move 3 from 8 to 3
                move 1 from 1 to 7
                move 8 from 2 to 5
                move 2 from 8 to 1
                move 10 from 7 to 1
                move 4 from 9 to 5
                move 2 from 5 to 8
                move 11 from 5 to 4
                move 6 from 7 to 2
                move 2 from 2 to 1
                move 1 from 7 to 5
                move 1 from 5 to 1
                move 2 from 4 to 8
                move 1 from 6 to 9
                move 8 from 4 to 3
                move 8 from 1 to 7
                move 7 from 1 to 2
                move 4 from 3 to 9
                move 1 from 9 to 6
                move 7 from 2 to 1
                move 5 from 2 to 3
                move 2 from 7 to 8
                move 5 from 8 to 4
                move 2 from 9 to 3
                move 1 from 8 to 1
                move 6 from 3 to 5
                move 10 from 3 to 1
                move 3 from 5 to 3
                move 3 from 2 to 1
                move 1 from 5 to 4
                move 6 from 4 to 5
                move 1 from 6 to 2
                move 3 from 4 to 7
                move 1 from 9 to 4
                move 2 from 3 to 1
                move 1 from 9 to 8
                move 1 from 3 to 7
                move 4 from 4 to 8
                move 2 from 7 to 4
                move 8 from 5 to 9
                move 2 from 8 to 6
                move 2 from 4 to 3
                move 2 from 3 to 4
                move 4 from 9 to 7
                move 1 from 8 to 7
                move 2 from 6 to 9
                move 2 from 8 to 9
                move 1 from 2 to 9
                move 1 from 7 to 8
                move 1 from 2 to 7
                move 19 from 7 to 6
                move 1 from 8 to 1
                move 2 from 4 to 8
                move 5 from 6 to 1
                move 2 from 7 to 2
                move 2 from 2 to 8
                move 2 from 1 to 8
                move 4 from 8 to 2
                move 3 from 2 to 8
                move 6 from 9 to 5
                move 8 from 6 to 3
                move 26 from 1 to 6
                move 1 from 5 to 3
                move 1 from 1 to 5
                move 8 from 3 to 1
                move 1 from 3 to 7
                move 3 from 9 to 2
                move 4 from 2 to 6
                move 26 from 6 to 1
                move 1 from 7 to 5
                move 3 from 8 to 4
                move 2 from 8 to 2
                move 7 from 1 to 2
                move 1 from 5 to 9
                move 2 from 4 to 6
                move 9 from 6 to 2
                move 18 from 1 to 7
                move 6 from 7 to 1
                move 6 from 5 to 6
                move 1 from 1 to 2
                move 19 from 2 to 7
                move 1 from 4 to 2
                move 9 from 7 to 1
                move 3 from 6 to 7
                move 1 from 9 to 4
                move 1 from 2 to 3
                move 8 from 7 to 8
                move 4 from 6 to 5
                move 2 from 6 to 3
                move 1 from 4 to 2
                move 4 from 5 to 1
                move 8 from 8 to 7
                move 17 from 7 to 8
                move 3 from 3 to 1
                move 1 from 2 to 8
                move 8 from 8 to 4
                move 8 from 8 to 7
                move 1 from 8 to 2
                move 7 from 7 to 6
                move 1 from 2 to 7
                move 5 from 7 to 8
                move 7 from 1 to 6
                move 10 from 6 to 1
                move 4 from 7 to 9
                move 3 from 9 to 7
                move 1 from 7 to 2
                move 6 from 4 to 2
                move 7 from 1 to 5
                move 4 from 2 to 5
                move 16 from 1 to 9
                move 3 from 2 to 7
                move 2 from 4 to 9
                move 4 from 1 to 6
                move 5 from 7 to 4
                move 4 from 6 to 3
                move 1 from 7 to 4
                move 1 from 6 to 9
                move 1 from 8 to 5
                move 4 from 3 to 2
                move 2 from 5 to 3
                move 3 from 6 to 2
                move 3 from 2 to 1
                move 9 from 5 to 8
                move 1 from 3 to 1
                move 10 from 8 to 1
                move 1 from 8 to 5
                move 16 from 9 to 2
                move 1 from 3 to 2
                move 12 from 1 to 9
                move 1 from 9 to 2
                move 3 from 1 to 6
                move 2 from 1 to 9
                move 3 from 6 to 8
                move 20 from 2 to 7
                move 16 from 9 to 7
                move 1 from 7 to 5
                move 2 from 5 to 9
                move 2 from 2 to 3
                move 2 from 8 to 5
                move 3 from 9 to 7
                move 2 from 5 to 2
                move 1 from 4 to 6
                move 2 from 1 to 4
                move 23 from 7 to 5
                move 4 from 8 to 5
                move 7 from 7 to 1
                move 16 from 5 to 7
                move 1 from 6 to 5
                move 1 from 2 to 4
                move 2 from 3 to 9
                move 1 from 2 to 3
                move 13 from 5 to 1
                move 1 from 3 to 8
                move 1 from 9 to 4
                move 19 from 1 to 9
                move 2 from 1 to 9
                move 22 from 9 to 8
                move 14 from 8 to 5
                move 12 from 5 to 3
                move 21 from 7 to 9
                move 14 from 9 to 7
                move 1 from 8 to 6
                move 9 from 3 to 7
                move 1 from 3 to 2
                move 4 from 4 to 1
                move 1 from 2 to 4
                move 1 from 3 to 9
                move 6 from 8 to 9
                move 4 from 1 to 7
                move 2 from 5 to 9
                move 6 from 4 to 5
                move 4 from 7 to 4
                move 1 from 5 to 3
                move 5 from 9 to 7
                move 2 from 3 to 1
                move 6 from 9 to 6
                move 1 from 1 to 6
                move 2 from 4 to 2
                move 8 from 7 to 5
                move 20 from 7 to 5
                move 2 from 5 to 6
                move 4 from 9 to 5
                move 1 from 1 to 3
                move 1 from 3 to 4
                move 1 from 2 to 7
                move 1 from 4 to 9
                move 9 from 6 to 3
                move 2 from 4 to 3
                move 28 from 5 to 3
                move 1 from 8 to 3
                move 1 from 8 to 1
                move 1 from 2 to 8
                move 1 from 6 to 2
                move 1 from 8 to 1
                move 6 from 5 to 7
                move 1 from 5 to 1
                move 1 from 9 to 2
                move 1 from 1 to 3
                move 1 from 9 to 7
                move 2 from 1 to 2
                move 11 from 3 to 8
                move 3 from 8 to 6
                move 3 from 6 to 9
                move 25 from 3 to 7
                move 4 from 3 to 8
                move 4 from 2 to 3
                move 9 from 8 to 9
                move 2 from 3 to 7
                move 3 from 8 to 2
                move 11 from 9 to 7
                move 1 from 9 to 1
                move 4 from 7 to 3
                move 1 from 1 to 5
                move 23 from 7 to 2
                move 12 from 2 to 3
                move 2 from 3 to 9
                move 12 from 2 to 1
                move 2 from 3 to 9
                move 1 from 5 to 4
                move 1 from 2 to 5
                move 1 from 9 to 4
                move 1 from 5 to 9
                move 2 from 4 to 2
                move 3 from 1 to 4
                move 1 from 2 to 1
                move 10 from 3 to 2
                move 7 from 7 to 3
                move 11 from 7 to 9
                move 5 from 3 to 1
                move 1 from 4 to 5
                move 11 from 2 to 3
                move 9 from 9 to 3
                move 3 from 9 to 4
                move 2 from 4 to 8
                move 1 from 5 to 6
                move 13 from 1 to 5
                move 3 from 3 to 8
                move 3 from 7 to 2
                move 1 from 7 to 4
                move 3 from 8 to 3
                move 8 from 3 to 8
                move 4 from 4 to 5
                move 2 from 8 to 2
                move 8 from 8 to 3
                move 1 from 6 to 3
                move 2 from 2 to 8
                move 6 from 5 to 2
                move 3 from 2 to 8
                move 1 from 1 to 7
                move 2 from 9 to 3
                move 3 from 5 to 4
                move 2 from 8 to 6""";
    }

    @Override
    public String exampleRawData() {
        return """               
                move 1 from 2 to 1
                move 3 from 1 to 3
                move 2 from 2 to 1
                move 1 from 1 to 2""";
    }
}

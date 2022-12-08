import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CrateManager {
    String getTopCrates(List<Move> moveList) {
        this.createStacks();
        this.reorganiseCrates(moveList);

        StringBuilder topCrates = new StringBuilder();
        topCrates
                .append(stack_1.pop())
                .append(stack_2.pop())
                .append(stack_3.pop())
                .append(stack_4.pop())
                .append(stack_5.pop())
                .append(stack_6.pop())
                .append(stack_7.pop())
                .append(stack_8.pop())
                .append(stack_9.pop());
        return topCrates.toString();
    }

    String getTopCrates9001(List<Move> moveList) {
        this.createStacks();
        this.reorganiseCrates9001(moveList);

        StringBuilder topCrates = new StringBuilder();
        topCrates
                .append(stack_1.pop())
                .append(stack_2.pop())
                .append(stack_3.pop())
                .append(stack_4.pop())
                .append(stack_5.pop())
                .append(stack_6.pop())
                .append(stack_7.pop())
                .append(stack_8.pop())
                .append(stack_9.pop());
        return topCrates.toString();

    }

    Stack<Character> stack_1 = new Stack<>();
    Stack<Character> stack_2 = new Stack<>();
    Stack<Character> stack_3 = new Stack<>();
    Stack<Character> stack_4 = new Stack<>();
    Stack<Character> stack_5 = new Stack<>();
    Stack<Character> stack_6 = new Stack<>();
    Stack<Character> stack_7 = new Stack<>();
    Stack<Character> stack_8 = new Stack<>();
    Stack<Character> stack_9 = new Stack<>();

    void createStacks() {
        char[] array_1 = {'H', 'T', 'Z', 'D'};
        char[] array_2 = {'Q', 'R', 'W', 'T', 'G', 'C', 'S'};
        char[] array_3 = {'P', 'B', 'F', 'Q', 'N', 'R', 'C', 'H'};
        char[] array_4 = {'L', 'C', 'N', 'F', 'H', 'Z'};
        char[] array_5 = {'G', 'L', 'F', 'Q', 'S'};
        char[] array_6 = {'V', 'P', 'W', 'Z', 'B', 'R', 'C', 'S'};
        char[] array_7 = {'Z', 'F', 'J'};
        char[] array_8 = {'D', 'L', 'V', 'Z', 'R', 'H', 'Q'};
        char[] array_9 = {'B', 'H', 'G', 'N', 'F', 'Z', 'L', 'D'};
        for (char c : array_1) {
            stack_1.push(Character.valueOf(c));
        }
        for (char c : array_2) {
            stack_2.push(Character.valueOf(c));
        }
        for (char c : array_3) {
            stack_3.push(Character.valueOf(c));
        }
        for (char c : array_4) {
            stack_4.push(Character.valueOf(c));
        }
        for (char c : array_5) {
            stack_5.push(Character.valueOf(c));
        }
        for (char c : array_6) {
            stack_6.push(Character.valueOf(c));
        }
        for (char c : array_7) {
            stack_7.push(Character.valueOf(c));
        }
        for (char c : array_8) {
            stack_8.push(Character.valueOf(c));
        }
        for (char c : array_9) {
            stack_9.push(Character.valueOf(c));
        }
    }

    void reorganiseCrates(List<Move> moveList) {
        for (Move move : moveList) {
            int amountToMove = move.getMoveQuantity();
            int moveFrom = move.getMoveFrom();
            int moveTo = move.getMoveTo();

            Stack<Character> stackFrom = getStackByNumber(moveFrom);
            Stack<Character> stackTo = getStackByNumber(moveTo);

            for (int i = 0; i < amountToMove; i++) {
                Character crate = stackFrom.pop();
                stackTo.push(crate);
            }
        }
    }

    void reorganiseCrates9001(List<Move> moveList) {
        for (Move move : moveList) {
            int amountToMove = move.getMoveQuantity();
            int moveFrom = move.getMoveFrom();
            int moveTo = move.getMoveTo();

            Stack<Character> stackFrom = getStackByNumber(moveFrom);
            Stack<Character> stackTo = getStackByNumber(moveTo);

            List<Character> tempList = new ArrayList<>();
            for (int i = 0; i < amountToMove; i++) {
                Character crate = stackFrom.pop();
                tempList.add(crate);
            }
            Collections.reverse(tempList);
            for (Character tempCrate : tempList) {
                stackTo.push(tempCrate);
            }
            tempList.clear();
        }
    }

    Stack<Character> getStackByNumber(int stackNumber) {
        switch (stackNumber) {
            case 1:
                return stack_1;
            case 2:
                return stack_2;
            case 3:
                return stack_3;
            case 4:
                return stack_4;
            case 5:
                return stack_5;
            case 6:
                return stack_6;
            case 7:
                return stack_7;
            case 8:
                return stack_8;
            case 9:
                return stack_9;
            default:
                return null;
        }
    }
}

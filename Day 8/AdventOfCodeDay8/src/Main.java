import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        TreeInput treeInput = new TreeInput();
        List<String> input = treeInput.readTreeInput();
        System.out.println("Part 1:" + partOne(input));
        System.out.println("Part 2:" + partTwo(input));
    }
    static int partOne(List<String> input){
        String[] split;
        String[] split2;
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        int center = 0;
        int visible = 0;

        for (int x = 0; x<input.size(); x++){
            split = input.get(x).split("");
            if (x == 0 || x == input.size()-1){
                visible += split.length;
            }
            else{
                for (int y = 0; y<split.length; y++){
                    if (y == 0 || y == split.length-1){
                        visible += 1;
                    }

                    else {
                        up = 0;
                        down = 0;
                        left = 0;
                        right = 0;

                        center = Integer.parseInt(split[y]);

                        for (int count = x-1; count>=0; count--){
                            split2 = input.get(count).split("");
                            if (up < Integer.parseInt(split2[y])){
                                up = Integer.parseInt(split2[y]);
                            }
                        }

                        for (int count = x+1; count<input.size(); count++){
                            split2 = input.get(count).split("");
                            if (down < Integer.parseInt(split2[y])){
                                down = Integer.parseInt(split2[y]);
                            }
                        }

                        for (int count = 0; count<split.length; count++){
                            if (count < y){
                                if (left < Integer.parseInt(split[count])){
                                    left = Integer.parseInt(split[count]);
                                }
                            }

                            else if (count > y){
                                if (right < Integer.parseInt(split[count])){
                                    right = Integer.parseInt(split[count]);
                                }
                            }
                        }

                        if (center > up || center > down || center > left || center > right){
                            visible += 1;
                        }
                    }
                }
            }
        }
        return visible;
    }

    static int partTwo(List<String> input){
        String[] split;
        String[] split2;
        int center = 0;

        int scenicSum = 0;
        int scenicUp = 0;
        int scenicDown = 0;
        int scenicLeft = 0;
        int scenicRight = 0;

        for (int x = 0; x<input.size(); x++){
            split = input.get(x).split("");

            if (!(x == 0 || x == input.size()-1)){
                for (int y = 0; y<split.length; y++){
                    if (!(y == 0 || y == split.length-1)){
                        scenicUp = 0;
                        scenicDown = 0;
                        scenicLeft = 0;
                        scenicRight = 0;

                        center = Integer.parseInt(split[y]);

                        for (int count = x-1; count>=0; count--){
                            split2 = input.get(count).split("");
                            if (center <= Integer.parseInt(split2[y])){
                                scenicUp += 1;
                                break;
                            }
                            else {
                                scenicUp += 1;
                            }
                        }

                        for (int count = x+1; count<input.size(); count++){
                            split2 = input.get(count).split("");
                            if (center <= Integer.parseInt(split2[y])){
                                scenicDown += 1;
                                break;
                            }
                            else {
                                scenicDown += 1;
                            }
                        }

                        for (int count = y-1; count>=0; count--){
                            if (center <= Integer.parseInt(split[count])){
                                scenicLeft += 1;
                                break;
                            }
                            else {
                                scenicLeft += 1;
                            }
                        }

                        for (int count = y+1; count<split.length; count++){
                            if (center <= Integer.parseInt(split[count])){
                                scenicRight += 1;
                                break;
                            }
                            else {
                                scenicRight += 1;
                            }
                        }

                        if (scenicSum < (scenicUp*scenicDown*scenicLeft*scenicRight)){
                            scenicSum = scenicUp*scenicDown*scenicLeft*scenicRight;
                        }
                    }
                }
            }
        }
        return scenicSum;
    }
}
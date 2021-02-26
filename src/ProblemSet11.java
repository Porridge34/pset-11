import java.util.ArrayList;

public class ProblemSet11 {

    public static void main(String[] args) {
        ProblemSet11 test = new ProblemSet11();
        int[] arr1 = {1, 1, 1, 1, 1};
        ArrayList<Integer> arrlist = new ArrayList<>();
        for (int i : arr1) {
            arrlist.add(i);
        }
        int[] arr2 = {2, 4};
        ArrayList<Integer> arrlist2 = new ArrayList<>();
        for (int i : arr2) {
            arrlist2.add(i);
        }
        int result = test.countClumps(arrlist);
        System.out.println(result);
//        for (Integer s : result) {
//            System.out.println(s);
//        }
    }

    public ArrayList<String> fizzBuzz(int start, int end) {
        if (start < end) {
            ArrayList<String> result = new ArrayList<>();
            for (int i = start; i < end; i++) {
                if (i % 3 == 0) {
                    if (i % 5 == 0) {
                        result.add("FizzBuzz");
                    }
                    else {
                        result.add("Fizz");
                    }
                }
                else if (i % 5 == 0) {
                    result.add("Buzz");
                }
                else {
                    result.add(String.valueOf(i));
                }
            }
            return result;
        }
        return null;
    }

    public int maxSpan(ArrayList<Integer> numbers) {
        if (numbers != null) {
            if (numbers.size() == 0) {
                return 0;
            }
            int maxSpan = 1;
            for (int i = 0; i < numbers.size(); i++) {
                int currentSpan = 1;
                for (int j = i + 1; j < numbers.size(); j++) {
                    if (numbers.get(i).equals(numbers.get(j))) {
                        currentSpan = j - i + 1;
                    }
                }
                if (currentSpan > maxSpan) {
                    maxSpan = currentSpan;
                }
            }
            return maxSpan;
        }
        return -1;
    }

    public ArrayList<Integer> fix34(ArrayList<Integer> numbers) {
        if (numbers != null) {
            int threes = 0;
            int fours = 0;
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) == 3) {
                    if (i == numbers.size() - 1 || numbers.get(i + 1) == 4) {
                        return null;
                    }
                    threes++;
                }
                else if (numbers.get(i) == 4) {
                    if (threes == 0) {
                        return null;
                    }
                    fours++;
                }
            }
            if (threes != fours) {
                return null;
            }
            for (int i = 0; i < numbers.size() - 1; i++) {
                if (numbers.get(i) == 3) {
                    int temp = numbers.get(i + 1);

                    for (int j = i + 1; j < numbers.size(); j++) {
                        if (numbers.get(j) == 4) {
                            numbers.set(j, temp);
                        }
                    }
                    numbers.set(i + 1, 4);
                }
            }

            return numbers;
        }
        return null;
    }

    public ArrayList<Integer> fix45(ArrayList<Integer> numbers) {
        if (numbers != null) {
            int fours = 0;
            int fives = 0;
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) == 4) {
                    if (i == numbers.size() - 1 || numbers.get(i + 1) == 4) {
                        return null;
                    }
                    fours++;
                }
                else if (numbers.get(i) == 5) {
                    fives++;
                }
            }
            if (fives != fours) {
                return null;
            }
            int lastfiveindex = 0;
            for (int i = 0; i < numbers.size() - 1; i++) {
                if (numbers.get(i) == 4) {
                    int temp = numbers.get(i + 1);

                    for (int j = lastfiveindex; j < numbers.size(); j++) {
                        if (numbers.get(j) == 5) {
                            numbers.set(j, temp);
                            lastfiveindex = j + 1;
                        }
                    }
                    numbers.set(i + 1, 5);
                }
            }
            return numbers;
        }
        return null;
    }

    public boolean canBalance(ArrayList<Integer> numbers) {
        if (numbers != null && numbers.size() != 0) {
            if (numbers.size() == 1) {
                return false;
            }
            for (int i = 0; i < numbers.size(); i++) {
                int leftsum = 0;
                for (int j = 0; j < i; j++) {
                    leftsum += numbers.get(j);
                }
                int rightsum = 0;
                for (int j = i; j < numbers.size(); j++) {
                    rightsum += numbers.get(j);
                }
                if (rightsum == leftsum) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean linearIn(ArrayList<Integer> outer, ArrayList<Integer> inner) {
        if (outer != null && inner != null && outer.size() != 0 && inner.size() != 0) {
            for (int i = 0; i < inner.size() - 1; i++) {
                if (inner.get(i) > inner.get(i + 1)) {
                    return false;
                }
            }
            int innercount = 0;
            for (int i = 0; i < outer.size() - 1; i++) {
                if (outer.get(i) > outer.get(i + 1)) {
                    return false;
                } else if (outer.get(i).equals(inner.get(innercount))){
                    innercount++;
                }
                if (innercount == inner.size()) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Integer> squareUp(int n) {
        if (n >= 0) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < n*n; i++) {
                result.add(0);
            }
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j <= i; j++) {
                    result.set(i * n - j, j);
                }
            }
            return result;
        }
        return null;
    }

    public ArrayList<Integer> seriesUp(int n) {
        if (n >= 0) {
            int temp = 0;
            for(int i = 1; i <= n; i++){
                temp += i;
            }
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < temp; i++) {
                result.add(0);
            }
            int indexcount = 0;
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < i + 1; j++) {
                    result.set(indexcount, j);
                    indexcount++;
                }
            }
            return result;
        }
        return null;
    }

    public int maxMirror(ArrayList<Integer> numbers) {
        if (numbers != null) {
            if (numbers.size() == 0) {
                return 0;
            }
            int maxMirror = 1;
            for (int i = 0; i < numbers.size(); i++) {
                //this is the beginning index of the temparr in terms of the original array
                for (int j = numbers.size() - 1; j > i; j--) {
                    //this is the ending index
                    int[] tempArr = new int[j - i + 1];
                    for (int k = 0; k < tempArr.length; k++) {
                        //copying numbers into temparr
                        tempArr[k] = numbers.get(i + k);
                    }
//                    for (int k : tempArr) {
//                        System.out.println(k);
//                    }
//                    System.out.println("BREAK");
                    int indexoftemparr = 0;
                    boolean continuation = false;
                    for (int k = numbers.size() - 1; k >= 0; k--) {
                        //finding reverse match of temparr in numbers
                        if (indexoftemparr == tempArr.length) {
                            if (maxMirror < indexoftemparr) {
                                maxMirror = indexoftemparr;
                            }
                            k = 0;
                            continue;
                        }
                        if (numbers.get(k) == tempArr[indexoftemparr]) {

                            if (indexoftemparr > 0 && continuation == false) {
                                indexoftemparr = 0;
                                continue;
                            }
                            continuation = true;
                            indexoftemparr++;
                        }
                        else {
                            continuation = false;
                            indexoftemparr = 0;
                        }
                        if (indexoftemparr == tempArr.length) {
                            if (maxMirror < indexoftemparr) {
                                maxMirror = indexoftemparr;
                            }
                            k = 0;
                            continue;
                        }
                    }
                }
            }
            return maxMirror;
        }
        return -1;
    }

    public int countClumps(ArrayList<Integer> numbers) {
        if (numbers != null) {
            if (numbers.size() == 0) {
                return 0;
            }
            int clumpint = numbers.get(0);
            int clumpsCount = 0;
            boolean foundClump = false;
            for (int i = 1; i < numbers.size(); i++) {
                if (numbers.get(i) == clumpint) {
                    if (foundClump == false) {
                        clumpsCount ++;
                    }
                    foundClump = true;
                }
                else {
                    clumpint = numbers.get(i);
                    foundClump = false;
                }
            }
            return clumpsCount;
        }
        return -1;
    }
}

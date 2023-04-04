import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class BoatOptimizer {

    public static void main(String[] args) throws Exception {

        if (!Objects.isNull(args) && (args.length == 2)) {
            int weightLimit = Integer.parseInt(args[0]);
            List<String> peoplesWeights = new ArrayList<String>(Arrays.asList(args[1].split(",")));

            // process heaviest first
            Collections.sort(peoplesWeights, Collections.reverseOrder());
            // list of boats with weights
            List<String> boats = new ArrayList<>();
            // which indexes used
            Set<Integer> usedIndexes = new HashSet<Integer>();

            // prevent cost of size() call
            int sizeOfPeoplesWeights = peoplesWeights.size();

            // walk thru peoples weights heaviest first
            for (int i = 0; i < sizeOfPeoplesWeights; i++) {
                if (!usedIndexes.contains(i)) {
                    StringBuilder boatString = new StringBuilder("[" + peoplesWeights.get(i));

                    // heaviest to lightest
                    // for (int j = sizeOfPeoplesWeights - 1; j > i; j--) { // heaviest to heaviest
                    // heaviest to heaviest
                    for (int j = i + 1; j < sizeOfPeoplesWeights; j++) {

                        if (!usedIndexes.contains(j)) {
                            int sumOfWeights = Integer.parseInt(peoplesWeights.get(i)) +
                                    Integer.parseInt(peoplesWeights.get(j));
                            if (sumOfWeights <= weightLimit) {
                                usedIndexes.add(j);
                                boatString.append("," + peoplesWeights.get(j));
                                break;
                            }
                        }
                    }
                    boatString.append("]");
                    boats.add(boatString.toString());
                }
            }
            System.out.println("boats : " + boats);
            System.out.println("boat count : " + boats.size());
        }
    }

}

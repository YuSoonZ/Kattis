import java.util.*;

public class electionparadox {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int noOfRegions = input.nextInt();
        input.nextLine();

        String noOfVoters = input.nextLine();

        String[] votersNumber = noOfVoters.split("\\s+");
        int len = votersNumber.length;
        int[] votersNumberInt = new int[len];

        for (int i = 0; i < len; i++) {
            votersNumberInt[i] = Integer.parseInt(votersNumber[i]);
        }

        int[] sortedVoters = Arrays.stream(votersNumberInt).sorted().toArray();
        int[] descendingVoters = new int[len];
        for (int i = 0; i < len; i++) {
            descendingVoters[i] = sortedVoters[len - 1 - i];
        }

        int maxNumberofRegionsWin = Math.floorDiv(noOfRegions, 2);
        int output = 0;

        for (int i = 0; i < maxNumberofRegionsWin; i++) {
            output += descendingVoters[i];
        }

        for (int i = 0; i < len - maxNumberofRegionsWin; i++) {
            if (descendingVoters[i + maxNumberofRegionsWin] != 1) {
                output = output + Math.floorDiv(descendingVoters[i + maxNumberofRegionsWin], 2);
            }
        }

        System.out.println(output);
    }
}


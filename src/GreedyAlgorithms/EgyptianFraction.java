package GreedyAlgorithms;

import java.util.ArrayList;

public class EgyptianFraction {
    static ArrayList<Integer> egyptianFraction(int nr, int dr){
        ArrayList<Integer> denominators = new ArrayList<Integer>();
        while(nr!=0){
            int den = (int) Math.ceil((float)dr/nr);
            denominators.add(den);
            nr = nr*den-dr;
            dr = dr*den;
        }
        return denominators;
    }
    public static void main(String[] args){
        int nr = 12;
        int dr = 13;
        ArrayList<Integer> denominarots = egyptianFraction(nr, dr);
        for(int i=0; i<denominarots.size()-1; i++){
            System.out.print("1/"+denominarots.get(i) + " + ");
        }
        System.out.print("1/"+denominarots.get(denominarots.size()-1));
        System.out.print("");
    }
}

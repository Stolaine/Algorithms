package GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Job implements Comparable<Job>{
    int id;
    int deadline;
    int profit;
    Job(int id, int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    int getId(){
        return this.id;
    }
    int getDeadline(){
        return this.deadline;
    }
    int getProfit(){
        return this.profit;
    }

    @Override
    public int compareTo(Job o) {
        if(o.getProfit()==this.profit)
            return 0;
        else if(o.getProfit()>this.profit)
            return -1;
        else
            return 1;
    }
}

public class JobSequencing {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(br.readLine());
        for(int i=0; i<test_cases; i++){
            int num_jobs = Integer.parseInt(br.readLine());
            String[] str_values = br.readLine().split(" ");
            ArrayList<Job> jobs = new ArrayList<Job>();
            for(int j=0; j<num_jobs; j++){
                int id = Integer.parseInt(str_values[(j*3)+0]);
                int deadline = Integer.parseInt(str_values[(j*3)+1]);
                int profit = Integer.parseInt(str_values[(j*3)+2]);
                Job job = new Job(id, deadline, profit);
                jobs.add(job);
            }
            Collections.sort(jobs);
            Collections.reverse(jobs);
            ArrayList<Integer> completed_jobs = new ArrayList<Integer>();
            int total_profit = 0;
            boolean[] slots = new boolean[num_jobs];
            for(Job job:jobs){
                int deadline = job.getDeadline();
                int id = job.getId();
                int profit = job.getProfit();
                for(int j=Math.min(deadline, num_jobs)-1; j>=0; j--){
                    if(slots[j]==false){
                        slots[j]=true;
                        completed_jobs.add(id);
                        total_profit = total_profit + profit;
                        break;
                    }
                }
            }
            System.out.println(completed_jobs.size() + " " + total_profit);
            System.out.print("");
        }
    }
}

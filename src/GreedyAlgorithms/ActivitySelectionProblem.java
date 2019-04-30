package GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Activity implements Comparable<Activity>{
    int id;
    int start;
    int finish;

    Activity(int id, int start, int finish){
        this.id = id;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compareTo(Activity o) {
        if(o.finish == this.finish)
            return 0;
        else if(o.finish>this.finish)
            return -1;
        else
            return 1;
    }

    int getStart(){
        return this.start;
    }
    int getFinish(){
        return this.finish;
    }
    int getId(){
        return this.id;
    }
}
public class ActivitySelectionProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(br.readLine());
        for(int i=0; i<test_cases; i++){
            int num_jobs = Integer.parseInt(br.readLine());
            String[] str_start_values = br.readLine().split(" ");
            String[] str_finish_values = br.readLine().split(" ");
            ArrayList<Activity> jobs = new ArrayList<Activity>();
            for(int j=0; j<num_jobs; j++){
                Activity activity = new Activity((j+1), Integer.parseInt(str_start_values[j]), Integer.parseInt(str_finish_values[j]));
                jobs.add(activity);
            }
            Collections.sort(jobs);
            ArrayList<Integer> activities = new ArrayList<Integer>();
            int count = 0;
            int start = 0;
            for(Activity activity:jobs){
                if(activity.getStart()>start){
                    activities.add(activity.getId());
                    start = activity.getFinish();
                }
            }
            for(Integer activity_number:activities){
                System.out.print(activity_number + " ");
            }
            System.out.println();
            System.out.print("");
        }
    }
}

package DP;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

public class WeightedJobScheduling {

	private static class Job{
		public int start;
		public int finish;
		public int profit;
		
		public Job(int start, int finish, int profit){
			this.start = start;
			this.finish = finish;
			this.profit = profit;
		}
		
		public static Comparator<Job> comp = new Comparator<WeightedJobScheduling.Job>() {
			
			@Override
			public int compare(Job o1, Job o2) {
				
				return o1.finish - o2.finish;
			}
		};
	}
	
	private static List<Job> getJobs(){
		List<Job> jobs = Lists.newArrayList();
		jobs.add(new Job(1,8,50));
		jobs.add(new Job(2,4,60));
		jobs.add(new Job(2,3,70));
		jobs.add(new Job(1,2,40));
		jobs.add(new Job(5,7,30));
		jobs.add(new Job(1,5,40));
		jobs.add(new Job(2,6,80));
		return jobs;
	}
	public static void main(String[] args) {
		List<Job> jobs = getJobs();
		System.out.println("Max Profit is "+getMaxProfit(jobs));
	}
	
	private static int getLastNoConfilctJob(int index, List<Job> jobs){
		
		int targetfinishTime = jobs.get(index).start;
		
		for(int j=index-1; j>=0; j--){
			Job tempJob = jobs.get(j);
			if(tempJob.finish <= targetfinishTime){
				return j;
			}
		}
		
		return -1;
	}
	
	private static int getMaxProfit(List<Job> jobs){
		
		if(jobs.size()==0)
			return -1;
		int[] profitTable = new int[jobs.size()+1];
		Collections.sort(jobs, Job.comp);
		profitTable[1] = jobs.get(0).profit;
		
		for(int i=2;i<=jobs.size(); i++){
			
			Job currentJob = jobs.get(i-1);
			
			/* Include the job*/
			int lastConflictingJobIndex = getLastNoConfilctJob(i-1, jobs);
			
			int incl_profit = currentJob.profit; 
			if(lastConflictingJobIndex != -1){
				incl_profit+=profitTable[lastConflictingJobIndex+1];
			}
			/*Exclusion*/
			int excl_profit = profitTable[i-1];
			
			profitTable[i] = Math.max(incl_profit, excl_profit);
		}
		
		
		return profitTable[jobs.size()];
	}

}

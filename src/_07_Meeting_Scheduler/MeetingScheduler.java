package _07_Meeting_Scheduler;

import java.util.ArrayList;

public class MeetingScheduler {
	//static ArrayList<Integer> sharedAva = new ArrayList<Integer>();
	//static String getDays = "";
    /*
     * Your task is to code a method to find a meeting time for two people
     * given their schedules.
     * 
     * Code the method below so that it returns a Schedule object that contains
     * all the times during the week that are in BOTH people's schedules. The
     * Schedule class is included in this package.
     * 
     * Example:
     * person1 availability - Monday at 9, Tuesday at 14, and Friday 10
     * person2 availability - Tuesday at 14, Friday 8, and Monday at 9
     * The returned HashMap should contain: Tuesday 14 and Monday 9
     * 
     * The returned Schedule object represents the times both people are
     * available for a meeting.
     * 
     * Time availability is always at the top of the hour, so 9:30 is not valid
     * Time availability always represents 1 hour
     * Assume both schedules are in the same time zones
     */
    public static Schedule getMutualAvailability(Schedule person1, Schedule person2) {
    	Schedule outPut = new Schedule();
        for (String day : person1.getSchedule().keySet()) {
        //	ArrayList<Integer> sharedAva = new ArrayList<Integer>();
    				for (Integer ints : person1.getSchedule().get(day)) {
    					for (Integer ints2 : person2.getSchedule().get(day)) {
						if(ints==ints2) {
							//sharedAva.add(ints);
		    				outPut.addAvailability(day, ints);
						}
    					}
					}
    				//getInts=person1.getSchedule().get(day);
    			}
        return outPut;
    }
}


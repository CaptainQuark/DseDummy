package dao;

import java.util.Calendar;

public class Log implements java.io.Serializable{

	/*
	 * TODO Implement missing variables.
	 */
	protected int logId, rideId;
	protected Calendar startTime, endTime;
	protected String fromPlace, toPlace;
	
	/**
	 * @param startTime
	 * 			Calendar object representing the time the ride started.
	 * @param fromPlace
	 * 			String representing the location where the ride started.
	 * @param toPlace
	 * 			String representing the location where the ride ended.
	 * @param logId
	 * 			Unique ID of the Log.
	 * @param rideId
	 * 			Unique ID of the ride which provides data to the log.
	 * @throws IllegalArgumentException
	 */
	public Log(Calendar startTime, Calendar endTime, String fromPlace, String toPlace, int logId, int rideId) throws IllegalArgumentException{
		
		/*
		 * Check for valid variables.
		 */
		if(fromPlace.isEmpty() || toPlace.isEmpty()){
			String msg = "At least one destination is empty.";
			throw new IllegalArgumentException(msg);
		}
		
		if(!startTime.equals(null) && startTime.after(Calendar.getInstance())){
			String msg = "Starting time is in future.";
			throw new IllegalArgumentException(msg);
		}
		
		if(!startTime.equals(null) && !endTime.equals(null) && startTime.after(endTime)){
			String msg = "Starting time is after end time.";
			throw new IllegalArgumentException(msg);
		}
		
		this.startTime = startTime;
		this.endTime = endTime;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		
		/*
		 * TODO Guarantee that provided ID is unique the list of logs.
		 */
		this.logId = logId;
		this.rideId = logId;
	}
		
	/*
	 * Getters.
	 */
	public Calendar getStartTime(){ return this.startTime; };
	public Calendar getEndTime(){ return this.endTime; };
	public String getFromPlace(){ return this.fromPlace; };
	public String getToPlace(){ return this.toPlace; };
	public Integer getLogId(){ return this.logId; }
	public Integer getRideId(){ return this.rideId; }
	
	/*
	 * Setters.
	 */
	
	// TODO Is it really necessary to modify a past log-entry?
	public void setEndTime(Calendar endTime){
		if(endTime.before(this.startTime)){
			String msg = "Finishing time is before starting time.";
			throw new IllegalArgumentException(msg);
		}
		else{
			this.endTime = endTime;
		}
	}
}

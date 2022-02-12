/**
 * 
 */
package com.assignment2;

/**
 * @author Abhinav
 * 
 * Date: Feb 12, 2022
 * 
 * Description: It is POJO class with the fields to store the information from the json files related to the marks of 5 subjects.
 *
 */
public class Scores {
	
	private String courseId;
	
	private String courseName;
	
	private long score;

	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the score
	 */
	public long getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(long score) {
		this.score = score;
	}
	
	

}

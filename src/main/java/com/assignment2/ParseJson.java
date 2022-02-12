package com.assignment2;

/**
 * @author Abhinav
 * Date: Feb 12, 2022
 * Description: This class handles the request coming to the /parsejson endpoint and redirect the use to the Result.jsp page,
 * with all the information of the student and area of rectangle and square by reading it from json files and performing actions on the data.
 * 
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class ParseJson
 */
public class ParseJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParseJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * Redirect the user to the Result.jsp page and set the data in the session by retrieving it from the json files.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);

		StudentDetails studentDetails = parseStudentDetailsFromJson();
		Long areaOfSquare = calculateAreaOfSquare();
		double areaOfRectangle = calculateAreaOfTraingle();

		// save information in session
		session.setAttribute("studentDetails", studentDetails);
		session.setAttribute("areaOfSquare", areaOfSquare);
		session.setAttribute("areaOfRectangle", areaOfRectangle);
		response.sendRedirect("Result.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * 
	 * It reads the information from the json file <b>student.json</b>
	 * and sets it in the <b>StudentDetails</b> object.
	 * 
	 * @return object of <b>StudentDetails</b> with all the information
	 */
	private StudentDetails parseStudentDetailsFromJson() {
		StudentDetails studentDetails = null;
		List<Address> addressList = new ArrayList<Address>();
		List<Scores> scoresList = new ArrayList<Scores>();
		try {
			JSONParser jsonParser = new JSONParser();
			ServletContext servletContext = getServletContext();
			String contextPath = servletContext.getRealPath(File.separator);

			FileReader fileReader = new FileReader(contextPath + "/jsonfiles/student.json");

			JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

			String firstName = (String) jsonObject.get("firstName");
			String lastName = (String) jsonObject.get("lastName");
			String email = (String) jsonObject.get("email");
			String phoneNumber = (String) jsonObject.get("phoneNumber");

			JSONArray addressJsonArray = (JSONArray) jsonObject.get("address");
			for (int i = 0; i < addressJsonArray.size(); i++) {
				JSONObject jsonObject2 = (JSONObject) addressJsonArray.get(i);

				String street = (String) jsonObject2.get("street");
				String city = (String) jsonObject2.get("city");
				String state = (String) jsonObject2.get("state");

				Address address = new Address();
				address.setStreet(street);
				address.setCity(city);
				address.setState(state);
				addressList.add(address);
			}

			JSONArray scoresJsonArray = (JSONArray) jsonObject.get("scores");
			for (int i = 0; i < scoresJsonArray.size(); i++) {
				JSONObject jsonObject2 = (JSONObject) scoresJsonArray.get(i);

				String courseId = (String) jsonObject2.get("courseId");
				String courseName = (String) jsonObject2.get("courseName");
				long score = (Long) jsonObject2.get("score");

				Scores scores = new Scores();
				scores.setCourseId(courseId);
				scores.setCourseName(courseName);
				scores.setScore(score);
				scoresList.add(scores);
			}

			studentDetails = new StudentDetails();
			studentDetails.setFirstName(firstName);
			studentDetails.setEmail(email);
			studentDetails.setLastName(lastName);
			studentDetails.setPhoneNumber(phoneNumber);
			studentDetails.setScoresList(scoresList);
			studentDetails.setAddressList(addressList);
		} catch (Exception e) {
			System.out.println("Exception occured while calculating area of square: " + e.getMessage());
		}
		return studentDetails;
	}

	/**
	 * 
	 * It read the <b>area.json</b> file and calculate the area of square.
	 * 
	 * @return Area of Square
	 */
	private Long calculateAreaOfSquare() {
		Long area = 0L;
		try {
			ServletContext servletContext = getServletContext();
			String contextPath = servletContext.getRealPath(File.separator);

			JSONParser jsonParser = new JSONParser();

			FileReader fileReader = new FileReader(contextPath + "/jsonfiles/area.json");

			JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

			Long side = (Long) jsonObject.get("side");

			area = side * side;
		} catch (Exception e) {
			System.out.println("Exception occured while calculating area of square: " + e.getMessage());
		}
		return area;
	}

	/**
	 * 
	 * It read the <b>area.json</b> file and calculate the area of rectangle.
	 * 
	 * @return Area of rectangle
	 */
	private double calculateAreaOfTraingle() {
		double area = 0;
		try {
			ServletContext servletContext = getServletContext();
			String contextPath = servletContext.getRealPath(File.separator);

			JSONParser jsonParser = new JSONParser();

			FileReader fileReader = new FileReader(contextPath + "/jsonfiles/area.json");

			JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

			Long height = (Long) jsonObject.get("height");
			Long base = (Long) jsonObject.get("base");

			area = (base * height) / 2;
		} catch (Exception e) {
			System.out.println("Exception occured while calculating area of triangle: " + e.getMessage());
		}
		return area;
	}

}

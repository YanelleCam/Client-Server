package server;

public class StudentComplaint {

	private int ComplaintID;
	private int StudentID;
	private int RepID;
	private String typeOfIssue;
	private String detailsOfIssue;
	private String service;
	private String response;
	private String dateOfLastResponse;

	public StudentComplaint() {}
	
	public StudentComplaint(int studentID, int repID, String typeOfIssue, String detailsOfIssue, String service) {
		super();
		StudentID = studentID;
		RepID = repID;
		this.typeOfIssue = typeOfIssue;
		this.detailsOfIssue = detailsOfIssue;
		this.service= service;
	}
		
	public void setResponse(String response) {
		this.response = response;
	}

	public void setDateOfLastResponse(String dateOfLastResponse) {
		this.dateOfLastResponse = dateOfLastResponse;
	}

	public String getResponse() {
		return response;
	}

	public String getDateOfLastResponse() {
		return dateOfLastResponse;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getComplaintID() {
		return ComplaintID;
	}

	public void setComplaintID(int complaintID) {
		ComplaintID = complaintID;
	}


	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public int getRepID() {
		return RepID;
	}

	public void setRepID(int repID) {
		RepID = repID;
	}

	public String getTypeOfIssue() {
		return typeOfIssue;
	}

	public void setTypeOfIssue(String typeOfIssue) {
		this.typeOfIssue = typeOfIssue;
	}

	public String getDetailsOfIssue() {
		return detailsOfIssue;
	}

	public void setDetailsOfIssue(String detailsOfIssue) {
		this.detailsOfIssue = detailsOfIssue;
	}
}

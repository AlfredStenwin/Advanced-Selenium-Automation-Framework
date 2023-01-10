package utilities.filereaders.models;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"testcaseid", "description", "ifrunneeded"})
public class RunSetupModel {

    private String testcaseid;  
	private String description;
    private Boolean runneeded;


    public RunSetupModel() {
    }


	public String getTestcaseid() {
		return testcaseid;
	}


	public void setTestcaseid(String testcaseid) {
		this.testcaseid = testcaseid;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Boolean getRunneeded() {
		return runneeded;
	}


	public void setRunneeded(Boolean runneeded) {
		this.runneeded = runneeded;
	}  

	
	
}
package CS225FinalProject.DataStructure;



import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Kevin Mee
 * 
 * the narratives that student sees for the patient previous record.
 */
public class Narrative  implements Serializable{
    /**
     */
    private String date, time, narrative, followUP, initials;
    private int painValue;
    
    private ArrayList<String> values;

    public Narrative(String date, String time, String narrative, String followUP, String initials) {
        this.date = date;
        this.time = time;
        this.narrative = narrative;
        this.followUP = followUP;
        this.initials = initials;
        this.values = new ArrayList<String>();
        for(int i = 0; i < 6; i++)
        {
            values.add(" ");
        }
        painValue = 5;
    }
    
    public void setPainValue(int v)
    {
        painValue = v;
    }
    
    public int getPainValue()
    {
        return painValue;
    }
    
    public void setValues(ArrayList<String> v)
    {
        values = v;
    }
    
    public ArrayList<String> getValues()
    {
        return values;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getFollowUP() {
        return followUP;
    }

    public void setFollowUP(String followUP) {
        this.followUP = followUP;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }
    /**
     * Returns the Narrative as an array of String. easy for setting up table in 
     * the scenario.
     */
    public String[] getNarrativeAsArrayStrings(){
        return new  String[]{date,time,narrative,followUP,initials};
    }
}


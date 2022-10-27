package program;

import td.api.Exceptions.TDException;
import td.api.Reports.Report;
import td.api.TeamDynamix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TdApiUtils {
    Map<String,String> appIds;

    public TdApiUtils() {
        appIds = getAppIds();
    }

    public ArrayList<Map<String, String>> getIDsFromReport(TeamDynamix td, int reportID) {
        Report report;
        try {
            report = td.getReport(reportID, true, "");
        } catch (TDException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(report.getDataRows());
    }



    private Map<String, String> getAppIds() {
        Map<String,String> ids = new HashMap<>();
        ids.put("(Advertising and Marketing)", "38");
        ids.put("(BSC) Employment", "30");
        ids.put("(BSC) Feedback", "50");
        ids.put("(BSC) One Form", "48");
        ids.put("(BSC) Operations", "42");
        ids.put("(BSC) Outreach", "39");
        ids.put("(BSC) Systems and Depts.", "31");
        ids.put("(BSC) Training", "63");
        ids.put("Accounting", "54");
        ids.put("Accounting Portal", "94");
        ids.put("Activities", "59");
        ids.put("Admission Employment", "61");
        ids.put("Admissions", "52");
        ids.put("Admissions Knowledge Base", "86");
        ids.put("Admissions Portal", "81");
        ids.put("Advising", "56");
        ids.put("Analysis", "2");
        ids.put("BSC Portal", "78");
        ids.put("BYUI Tickets", "40");
        ids.put("Centre Square Asset", "92");
        ids.put("Chat", "4");
        ids.put("Client Portal", "75");
        ids.put("Commit to Be Fit", "72");
        ids.put("Community", "6");
        ids.put("Complaints and Grievances", "96");
        ids.put("Concurrent Enrollment", "62");
        ids.put("Course Improvement", "47");
        ids.put("Course Improvement - Courses", "68");
        ids.put("Course Review", "51");
        ids.put("Course Support (Archive)", "32");
        ids.put("Curriculum Development (Inactive)", "46");
        ids.put("Faculty Technology Center", "73");
        ids.put("File Cabinet", "8");
        ids.put("Finance", "9");
        ids.put("Financial Aid", "53");
        ids.put("Financial Aid Portal", "97");
        ids.put("Health Center Portal", "82");
        ids.put("Housing", "57");
        ids.put("Housing Employment", "93");
        ids.put("Housing Portal", "84");
        ids.put("Human Resources Portal", "99");
        ids.put("I-Learn (Archive)", "44");
        ids.put("Information Security (Archive)", "74");
        ids.put("International Services", "69");
        ids.put("International Services Knowledge Base", "88");
        ids.put("Internship and Career Services", "71");
        ids.put("IT Assets/Products", "64");
        ids.put("IT Services", "79");
        ids.put("IT Tickets", "33");
        ids.put("Knowledge Base", "85");
        ids.put("Level 0 Client Portal", "89");
        ids.put("LMS Team", "58");
        ids.put("Lost and Found", "60");
        ids.put("Mail Services", "101");
        ids.put("My Work", "1");
        ids.put("News", "11");
        ids.put("OneStop Help Portal", "87");
        ids.put("Online Advising", "103");
        ids.put("Online Instruction", "41");
        ids.put("Pathway (Inactive)", "45");
        ids.put("Pathway Technical Support Portal", "98");
        ids.put("People", "13");
        ids.put("Portfolio Planning", "15");
        ids.put("Portfolios", "14");
        ids.put("Print Services", "70");
        ids.put("Project Requests", "16");
        ids.put("Project Templates", "22");
        ids.put("Projects / Workspaces", "17");
        ids.put("Public Affairs", "105");
        ids.put("Questions", "18");
        ids.put("Recreation Services", "104");
        ids.put("Resource Management", "20");
        ids.put("Risk and Safety", "43");
        ids.put("Ron's Test Portal", "83");
        ids.put("Services", "19");
        ids.put("SLC (Archive)", "36");
        ids.put("SRR", "55");
        ids.put("SRR Portal", "91");
        ids.put("SRR Projects", "34");
        ids.put("SRR Technology", "67");
        ids.put("Student Support", "37");
        ids.put("Student Well-Being", "90");
        ids.put("Surveys", "21");
        ids.put("TDNext", "12");
        ids.put("Ticket Requests", "23");
        ids.put("Tickets", "27");
        ids.put("Time & Expenses", "25");
        ids.put("University Cellular Portal", "100");
        ids.put("University Communications and MarCom", "35");
        ids.put("University Store", "102");
        ids.put("University Store Cellular", "49");
        ids.put("Workspaces", "26");
        return ids;
    }

    public String getAppId(String appName) {
        return appIds.get(appName);
    }
}

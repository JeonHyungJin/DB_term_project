package Term_project;

import java.util.ArrayList;

import member.memberdatabse;
import member.memberentity;

public class main_project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		memberdatabse memberdatabse = new memberdatabse();
		
		ArrayList<memberentity> t = new ArrayList<memberentity>();
		t = memberdatabse.getMemberList();
		System.out.println(t);
		
		memberdatabse.InsertMember("qwe1", "qwe2", "qwe3", "qwe4", "qwe5", "qwe6");
		System.out.println();
		t = memberdatabse.getMemberList();
		System.out.println(t);
	}

}

package club;

import java.util.ArrayList;

import member.Member;

public class Club {
	
	String name;
	Member member;
	ArrayList <Member> members = new ArrayList<Member>();
	
	public Club() {
		
	}
	
	public Club(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member=member;
	}
	
	public ArrayList<Member> getMembers(){
		return members;
	}
	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}
	
	public void out() {
		
		if(getMembers().size()<2) {
			System.out.println("수준미달 입니다.");
		}else {
			System.out.println("통과입니다.");
		}
	}
	
	
}

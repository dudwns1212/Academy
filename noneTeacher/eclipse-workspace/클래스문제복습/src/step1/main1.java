package step1;

import club.Club;
import member.Member;

public class main1 {
	public static void main(String[] args) {
		
		Member member1 = new Member("김민수", 25, "010-2853-0429");
		Member member2 = new Member("김형우", 26, "010-6577-5678");
		Member member3 = new Member("김형준", 28, "010-3927-6825");
		Member member4 = new Member("박재영", 32, "010-2783-9064");
		
		Club club1 = new Club("강남클럽");
		club1.getMembers().add(member1);
		club1.getMembers().add(member2);
		
		Club club2 = new Club("홍대클럽");
		club2.getMembers().add(member3);
		club2.getMembers().add(member4);
		
		System.out.println("강남클럽의 멤버 수는? : " + club1.getMembers().size());
		System.out.println("홍대클럽의 멤버 수는? : " + club2.getMembers().size());
		
		System.out.print("강남클럽 멤버들의 이름은? : ");
		for(int i=0;i<club1.getMembers().size();i++) {
			System.out.print(club1.getMembers().get(i).getName());
			if(i<club1.getMembers().size()-1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		
		System.out.print("홍대클럽 멤버들의 이름은? : ");
		for(int i=0;i<club2.getMembers().size();i++) {
			System.out.print(club2.getMembers().get(i).getName());
			if(i<club2.getMembers().size()-1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		
		String firstName = club1.getMembers().getFirst().getName();
		int firstAge = club1.getMembers().getFirst().getAge();
		String firstNumber = club1.getMembers().getFirst().getNumber();
		System.out.println("강남클럽 첫 번째 멤버의 신상 : " + firstName + ", " + firstAge + ", " + firstNumber);
		
		club1.out();
		club2.out();
		
	}
	
	
}

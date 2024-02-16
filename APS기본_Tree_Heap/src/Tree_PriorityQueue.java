import java.util.Comparator;
import java.util.PriorityQueue;

class Person implements Comparable<Person>{
	String name;
	int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		if(this.age == o.age) {
			return this.name.compareTo(o.name);
		}
		return this.age-o.age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}

public class Tree_PriorityQueue {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b-a;
			}
		});
	
		
		
		
		//우선순위 큐 : 기본 정렬 순서는 오름차순
		//내림차순으로 바꾸고 싶으면 
		//1. 음수
		//2. comparator
		
//		pq.add(12);
//		pq.add(23);
//		pq.add(8);
//		pq.offer(73);
//		
//		System.out.println(pq.poll());
//		System.out.println(pq.poll());
//		System.out.println(pq.poll());
//		System.out.println(pq.poll());
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b)-> {
			return b-a;
		});
		//들어갈 객체 1개
		//구현할 메소드 1개
		// -> 익명 클래스 사용 가능
		
//		pq2.add(12);
//		pq2.add(23);
//		pq2.add(8);
//		pq2.offer(73);
//		
//		System.out.println(pq2.poll());
//		System.out.println(pq2.poll());
//		System.out.println(pq2.poll());
//		System.out.println(pq2.poll());
		
		
		//1. comparator을 pq 생성자에 넣어준다 (람다식)
		//2. comparable을 person class가 구현한다. 
		PriorityQueue<Person> pq3 = new PriorityQueue<>();
		
		pq3.add(new Person("대전4반 김준철", 20));
		pq3.add(new Person("대전5반 김영원", 20));
		pq3.add(new Person("서울5반 양명균", 20));
		pq3.add(new Person("서울6반 이승재", 20));
		pq3.add(new Person("서울7반 오지혜", 20));
		
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
	}
}

# comparable & comparator & 람다식

## comparable 구현

```java
class Person implements Comparable<Person>{

@Override
	public int compareTo(Person o) {
		if(this.age == o.age) {
			return this.name.compareTo(o.name);
		}
		return this.age-o.age;
	}
}
```

## comparator 람다식

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b-a;
			}
		});

//들어갈 객체 1개
//구현할 메소드 1개
// -> 익명 클래스 사용 가능

PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b)-> {
			return b-a;
		});

```
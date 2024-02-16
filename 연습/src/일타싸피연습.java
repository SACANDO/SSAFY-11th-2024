
public class 일타싸피연습 {
	public static void main(String[] args) {
		float[] ball0 = {60f, 63.5f};
		float[] ball1 = {224f, 107f};
		
		float dx = ball1[0] - ball0[0];
		float dy = ball1[1] - ball0[1];
		
		double a = Math.atan(dx/dy);
		double b = Math.toDegrees(a);
		
		System.out.println(a);
		System.out.println(b);
		
	}
}

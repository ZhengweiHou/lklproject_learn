package com.hzw.java_learn.lambda;

// Eatable 接口
interface Eatable{
	void test();
}

// Flyable 接口
interface Flyable{
	void fly(String weather);
}

// Addable 接口
interface Addable{
	int add(int a, int b);
}

// LambdaQS类
public class LambdaQS {
	// 使用Eatable对象
	public void eat(Eatable e){
		System.out.println("Eatable:" + e);
		e.test();
	}
	
	// 使用Flyable对象
	public void driver(Flyable f){
		System.out.println("Flyable：" + f);
		f.fly("【晴朗的天空】");
	}
	
	// 使用Addable对象
	public void test(Addable add){
		System.out.println("Addable:" + add);
		System.out.println("计算 5+3=" + add.add(5, 3));
	}
	
	// 测试
	public static void main(String[] args) {
		LambdaQS lq = new LambdaQS();
		
		lq.eat(() -> System.out.println("小霸王吃芒果！"));
		
		lq.driver(weather -> {
			System.out.println("天气是：" + weather);
			System.out.println("小霸王上天了！");
		});
		
		lq.test((a, b) -> a + b);
		
	}
}


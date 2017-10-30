package com.practice.oct29;

/**
 * 
 * @author kavin
 * 泛型，用单个大写字母声明，通常用T，一般类的泛型成员不会超过两个，否则不容易控制。
 * @param <K>
 * @param <T>
 */
class Gen<K, T>{

	private T take;
	private K key;
	
	public T getTake() {
		return take;
	}
	public void setTake(T take) {
		this.take = take;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
}

class Info<T>{
	private T key;

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}
	
	@Override
	public String toString() {
		return this.getKey().toString();
	}
}

/**
 * 
 * @author kavin
 * 泛型接口，格式：interface 接口名称<泛型标识> {}
 */
interface GenInter<T>{
	public void say();
}

class Gin<T> implements GenInter<T>{
	
	private T info;
	public Gin(T info) {
		this.info = info;
	}
	
	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	@Override
	public void say() {
		System.out.println(this.getInfo());
	}
}

/**
 * 
 * @author kavin
 * 泛型方法
 */
class Gener{
	public<T>T tell(T t){//<T>： 指定返回的类型是一个泛型；T t：可以指定参数为泛型。
		return t;
	}
}

public class GenericDemo01 {
	
	/**
	 * 
	 * @param args
	 * 泛型数组
	 */
	
	public static <T>void tellarr(T arr[]){
		for(T t : arr) {
			System.out.println(t);
		}
	}

	public static void main(String[] args) {
		
		Info<String> i = new Info<String>();
		i.setKey("aiwufjn");
		tell(i);
		
		Gin<String> j = new Gin<String>("oenev");
		j.say();
		
		Gener g = new Gener();
		System.out.println(g.tell("qergoinqerig;er;gfh;o"));
		System.out.println(g.tell(3124908.123));
		
		Integer[] a = {1,2,3,4,5};
		tellarr(a);
		
		String[] s = {"pqiurf","epnib","nwej","rtib","vfmo"};
		tellarr(s);
	}
		
	
	
	/**
	 * 通配符：?
	 * @param i
	 */
	public static void tell(Info<?> i) {
		System.out.println(i);
	}
}

package com.classes.example;

public class InnerClassExamp {

	public void one() {
		System.out.println("This is Outer Class");
	}
	class inner {
		public void two() {
			System.out.println("This is Inner Class");
		}
		class inner1 {
			public void three() {
				System.out.println("This is Inner Inner Class");
			}
		}
	}
	public static void main(String[] args) {
      InnerClassExamp inc = new InnerClassExamp();
      new InnerClassExamp().new inner().new inner1().three();
      new InnerClassExamp().new inner().two();
      inc.one();
	}
}

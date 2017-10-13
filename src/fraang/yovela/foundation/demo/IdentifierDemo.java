package fraang.yovela.foundation.demo;

import fraang.yovela.foundation.Identifier;

public final class IdentifierDemo {
	public static void main(String[] args) {
		System.out.println(new Identifier().getUnique());
		System.out.println(new Identifier(Identifier::randomUniqueSupplier).getUnique());
		System.out.println(new Identifier("identifier1234567890").getUnique());
	}
}

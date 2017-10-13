package fraang.yovela.foundation;

import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

public final class Identifier {
	private static final Random RANDOM = new Random();

	public static interface Has {
		Identifier getIndentifier();
	}

	private static Supplier<String> uniqueSupplier = () -> {
		return UUID.randomUUID().toString();
	};
	private final String unique;

	public Identifier() {
		this.unique = uniqueSupplier.get();
	}

	public Identifier(final Supplier<String> uniqueSupplier) {
		this.unique = uniqueSupplier.get();
	}

	public Identifier(final String unique) {
		this.unique = unique;
	}

	public String getUnique() {
		return unique;
	}

	public static final String randomUniqueSupplier() {
		return Long.toHexString(RANDOM.nextLong());
	}
}

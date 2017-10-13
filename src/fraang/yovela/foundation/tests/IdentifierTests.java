package fraang.yovela.foundation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fraang.yovela.foundation.Identifier;

final class IdentifierTests {
	@Test
	public void createIdentifierFromRandomUuid() {
		Identifier identifier = new Identifier();
		UUID uniqueIdentifierUuid = UUID.fromString(identifier.getUnique());
		assertEquals(uniqueIdentifierUuid.toString(), identifier.getUnique());
	}

	@Test
	public void createIdentifierFromRandomUniqueSupplier() {
		String randomUniqueIdentifier = Identifier.randomUniqueSupplier();
		Identifier identifier = new Identifier(() -> randomUniqueIdentifier);
		assertEquals(randomUniqueIdentifier, identifier.getUnique());
	}

	@Test
	public void createIdentifierFromUnique() {
		String randomUniqueIdentifier = Identifier.randomUniqueSupplier();
		Identifier identifier = new Identifier(randomUniqueIdentifier);
		assertEquals(randomUniqueIdentifier, identifier.getUnique());
	}

	@Test
	public void ensureRandomUuidsAreSufficientlyRandom() {
		final int IDENTIFIER_AMOUNT = 10_000_000;
		Collection<Identifier> previousIdentifiers = new HashSet<>();
		for (int i = 0; i < IDENTIFIER_AMOUNT; i++) {
			Identifier identifier = new Identifier();
			Assertions.assertFalse(previousIdentifiers.contains(identifier));
			previousIdentifiers.add(identifier);
		}
	}

	@Test
	public void ensureRandomUniqueIdentifiersAreSufficientlyRandom() {
		final int IDENTIFIER_AMOUNT = 10_000_000;
		Collection<Identifier> previousIdentifiers = new HashSet<>();
		for (int i = 0; i < IDENTIFIER_AMOUNT; i++) {
			Identifier identifier = new Identifier(Identifier::randomUniqueSupplier);
			Assertions.assertFalse(previousIdentifiers.contains(identifier));
			previousIdentifiers.add(identifier);
		}
	}
}

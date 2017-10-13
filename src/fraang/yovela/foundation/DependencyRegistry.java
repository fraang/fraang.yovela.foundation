package fraang.yovela.foundation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DependencyRegistry {
	public interface Has {
		DependencyRegistry getDependencyRegistry();
	}

	private final Map<Identifier, List<Identifier>> dependencies = new HashMap<>();

	public void register(final Identifier dependent, final List<Identifier> dependencies) {
		this.dependencies.put(dependent, dependencies);
	}

	public void deregister(final Identifier dependent) {
		dependencies.remove(dependent);
	}

	public List<Identifier> getDependencies(final Identifier dependent) {
		return dependencies.get(dependent);
	}
}

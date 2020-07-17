package de.tum.in.ase.eist;

import java.util.Objects;

/**
 * The destination that the rider has set.
 * <p>
 * It has a name and a position.
 */
public final class Destination {

	private final int x;
	private final int y;
	private final String name;

	public Destination(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Destination)) {
			return false;
		}
		Destination other = (Destination) obj;
		return Objects.equals(name, other.name) && x == other.x && y == other.y;
	}
}

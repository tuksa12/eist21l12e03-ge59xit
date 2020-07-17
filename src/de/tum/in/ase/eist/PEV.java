package de.tum.in.ase.eist;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class PEV {

	private int chargeLevel;
	private final String licensePlate;
	private boolean available;
	protected int pricePerMinute;

	private final List<Rental> rentals;

	public PEV(int chargeLevel, String licensePlate) {
		this.chargeLevel = chargeLevel;
		this.licensePlate = licensePlate;
		available = true;
		rentals = new ArrayList<>();
	}

	@Override
	public abstract String toString();

	public String getLicensePlate() {
		return licensePlate;
	}

	public int getChargeLevel() {
		return chargeLevel;
	}

	public void setChargeLevel(int chargeLevel) {
		this.chargeLevel = chargeLevel;
	}

	public boolean isAvailable() {
		return available;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public int getPricePerMinute() {
		return pricePerMinute;
	}

	public void lock() {
		if (!available) {
			throw new IllegalStateException("Already locked");
		}
		available = false;
	}

	public void unlock() {
		if (available) {
			throw new IllegalStateException("Already unlocked");
		}
		available = true;
	}

	public Rental rent(LocalDateTime from, LocalDateTime to, Rider rider) {
		if (isBooked(from, to)) {
			throw new IllegalArgumentException("Already booked!");
		}
		Rental rental = new Rental(from, to, this, rider);
		rentals.add(rental);
		return rental;
	}

	private boolean isBooked(LocalDateTime from, LocalDateTime to) {
		return rentals.stream().anyMatch(rental -> from.isBefore(rental.getTo()) && rental.getFrom().isBefore(to));
	}

	public void ride() {
		System.out.println("Riding " + toString());
	}
}

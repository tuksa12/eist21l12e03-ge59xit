package de.tum.in.ase.eist;

public interface RealTimePositionService {

	int getX(PEV pev);

	int getY(PEV pev);

	Direction getDirection(PEV pev);
}

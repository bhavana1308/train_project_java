package trains;

import exception.InvalidPackageException;

public interface Cargo {

    int getPackageCount(int packageCount) throws InvalidPackageException;

    void loadCargo();

    void deliverCargo();

}

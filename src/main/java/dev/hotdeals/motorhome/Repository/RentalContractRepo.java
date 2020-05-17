package dev.hotdeals.motorhome.Repository;

import dev.hotdeals.motorhome.Model.RentalContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentalContractRepo
{

    @Autowired
    JdbcTemplate template;

    private static RentalContract fetchContractByID(int contractID)
    {
        RentalContract contractToReturn = new RentalContract();
        return contractToReturn;
    }

    private List<RentalContract> fetchAll()
    {
        List<RentalContract> listToReturn = null;
        return listToReturn;
    }

    private boolean addContract(RentalContract rentalContract)
    {
        boolean status = false;
        return status;
    }

    private boolean updateContract(RentalContract rentalContract)
    {
        boolean status = false;
        return status;
    }

    private boolean deleteContract(int contractID)
    {
        boolean status = false;
        return status;
    }
}

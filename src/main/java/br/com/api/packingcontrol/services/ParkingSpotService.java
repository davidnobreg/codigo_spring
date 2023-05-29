package br.com.api.packingcontrol.services;


import br.com.api.packingcontrol.models.ParkingSpotModel;
import br.com.api.packingcontrol.repositories.ParkingSpotRepositories;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService{

    final ParkingSpotRepositories parkingSpotRepositories;
    public ParkingSpotService(ParkingSpotRepositories parkingSpotRepositories){
        this.parkingSpotRepositories = parkingSpotRepositories;
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel){
        return parkingSpotRepositories.save(parkingSpotModel);
    }


    public boolean existsByLicensePlateCar(String licensePlateCar){
        return parkingSpotRepositories.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber){
        return parkingSpotRepositories.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment,String block){
        return parkingSpotRepositories.existsByApartmentAndBlock(apartment, block);
    }


    public Page<ParkingSpotModel> findAll(Pageable pageable){
        return parkingSpotRepositories.findAll(pageable);
    }

    public Optional<ParkingSpotModel> findById(UUID id) {
        return parkingSpotRepositories.findById(id);
    }

    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel) {
        parkingSpotRepositories.delete(parkingSpotModel);
    }

}

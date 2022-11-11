package com.api.parkingcontrol.service;

import com.api.parkingcontrol.model.ParkingSpotModel;
import com.api.parkingcontrol.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

    @Autowired
    ParkingSpotRepository repository;

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return repository.save(parkingSpotModel);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return repository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingNumber(String parkingSpotNumber) {
        return repository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartamentAndBlock(String apartament, String block) {
        return repository.existsByApartamentAndBlock(apartament, block);
    }

    public Page<ParkingSpotModel> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<ParkingSpotModel> findById(UUID id) {
        return repository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel) {
        repository.delete(parkingSpotModel);
    }
}

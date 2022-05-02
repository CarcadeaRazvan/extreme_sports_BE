package com.sports.backend.service;

import com.sports.backend.model.Location;
import com.sports.backend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    public void updateLocation(Location location) {
        locationRepository.save(location);
    }

    public Location getLocationById(Long id) {
        return locationRepository.findById(id).orElseThrow();
    }

    public List<Location> getLocationsByCounty(Long id) {
        return locationRepository.getLocationsByCounty(id);
    }

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}

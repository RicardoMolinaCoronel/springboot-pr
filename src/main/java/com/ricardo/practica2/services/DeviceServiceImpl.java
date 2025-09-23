package com.ricardo.practica2.services;


import com.ricardo.practica2.model.Device;
import com.ricardo.practica2.repository.DeviceRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    private DeviceRepository deviceRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @PostConstruct
    public void init() {
        System.out.println("Initializing device implementation...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Destroying device implementation...");

    }

    @Override
    public List<Device> findAllByName(String name, Pageable pageable) {

        return deviceRepository.findAllByName(name, pageable);
    }
}

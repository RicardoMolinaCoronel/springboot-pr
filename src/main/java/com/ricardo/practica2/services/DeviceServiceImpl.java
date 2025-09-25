package com.ricardo.practica2.services;


import com.ricardo.practica2.model.Device;
import com.ricardo.practica2.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
public class DeviceServiceImpl implements DeviceService {

    private DeviceRepository deviceRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }


    @Override
    public List<Device> findAllByName(String name, Pageable pageable) {

        return deviceRepository.findAllByName(name, pageable);
    }
}

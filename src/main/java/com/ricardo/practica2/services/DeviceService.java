package com.ricardo.practica2.services;

import com.ricardo.practica2.model.Device;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DeviceService {

List<Device> findAllByName(String name, Pageable pageable);

}

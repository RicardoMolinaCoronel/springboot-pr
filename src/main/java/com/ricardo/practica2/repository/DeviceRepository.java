package com.ricardo.practica2.repository;

import com.ricardo.practica2.model.Device;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DeviceRepository extends PagingAndSortingRepository<Device, Integer> {

    List<Device> findAllByName(String name, Pageable pageable);

}

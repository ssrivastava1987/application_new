package com.dyt.doyourthing.repositories;

import com.dyt.doyourthing.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

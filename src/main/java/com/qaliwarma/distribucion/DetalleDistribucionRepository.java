package com.qaliwarma.distribucion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleDistribucionRepository extends JpaRepository<DetalleDistribucionEntity, Integer> {
}

package com.devsuperior.work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.work.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}

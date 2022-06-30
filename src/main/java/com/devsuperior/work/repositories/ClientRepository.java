package com.devsuperior.work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.work.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

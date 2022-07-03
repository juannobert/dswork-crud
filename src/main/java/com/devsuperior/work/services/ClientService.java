package com.devsuperior.work.services;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.devsuperior.work.dto.ClientDTO;
import com.devsuperior.work.entities.Client;
import com.devsuperior.work.repositories.ClientRepository;
import com.devsuperior.work.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	private final String MSG = "Client with ID %d not found";

	@Autowired
	private ClientRepository repository;

	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}

	public ClientDTO findById(Long id) {
		Client entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format(MSG, id)));
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO save(ClientDTO dto) {
		Client entity = new Client();
		BeanUtils.copyProperties(dto, entity, "id");
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO update(ClientDTO dto, Long id) {
		try {
			Client entity = repository.getReferenceById(id);
			BeanUtils.copyProperties(dto, entity, "id");
			entity = repository.save(entity);
			return new ClientDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(String.format(MSG, id));
		}

	}

}

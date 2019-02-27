package mx.com.personal.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.com.personal.springboot.app.models.entity.Cliente;

public interface IClientService {
	List<Cliente> findAll();
	Page<Cliente> findAll(Pageable pageable);
	void save(Cliente cliente);
	Cliente findOne(Long id);
	void delete(Long id);
}

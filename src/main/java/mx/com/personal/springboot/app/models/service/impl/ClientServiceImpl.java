package mx.com.personal.springboot.app.models.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.personal.springboot.app.models.dao.IClientDAO;
import mx.com.personal.springboot.app.models.entity.Cliente;
import mx.com.personal.springboot.app.models.service.IClientService;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDAO clientDAO;
	
	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>)clientDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clientDAO.save(cliente);
	}

	@Override
	public Cliente findOne(Long id) {
		Optional<Cliente> optCliente = clientDAO.findById(id);
		return optCliente.orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clientDAO.deleteById(id);
	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		return clientDAO.findAll(pageable);
	}

}

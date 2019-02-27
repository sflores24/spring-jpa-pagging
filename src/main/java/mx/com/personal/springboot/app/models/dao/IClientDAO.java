package mx.com.personal.springboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import mx.com.personal.springboot.app.models.entity.Cliente;

public interface IClientDAO extends PagingAndSortingRepository<Cliente, Long> {
}

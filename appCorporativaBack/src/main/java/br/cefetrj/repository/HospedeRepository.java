package br.cefetrj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.cefetrj.model.Hospede;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long> {
}

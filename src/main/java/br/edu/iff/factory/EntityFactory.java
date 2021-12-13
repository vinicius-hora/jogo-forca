package br.edu.iff.factory;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.iff.repository.Repository;

public abstract class EntityFactory {
	  
	  private Repository repository;

	  protected EntityFactory(Repository repository) {
	    this.repository = repository;
	  }

	  protected Repository getRepository() {
	    return repository;
	  }

	  protected Long getProximoId() {
	    return repository.getProximoId();
	  }
	}

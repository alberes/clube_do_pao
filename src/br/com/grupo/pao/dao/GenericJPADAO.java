package br.com.grupo.pao.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericJPADAO<T, ID extends Serializable> implements
		GenericDAO<T, ID> {

	private final Class<T> persistentClass;

	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public GenericJPADAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public GenericJPADAO(final Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
	}

	public List<T> findAllWithNamedQuery(final String name) {
		Query query = getEntityManager().createNamedQuery(name, persistentClass);
		
		@SuppressWarnings("unchecked")
		final List<T> result = (List<T>) query.getResultList();
		
		return result;
	}

	public T findById(final ID id) {
		final T result = getEntityManager().find(persistentClass, id);
		return result;
	}

	public List<T> findByNamedQuery(final String name, Object... params) {
		javax.persistence.Query query = getEntityManager().createNamedQuery(name);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}

		@SuppressWarnings("unchecked")
		final List<T> result = (List<T>) query.getResultList();
		return result;
	}

	public List<T> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params) {
		Query query = getEntityManager().createNamedQuery(name, persistentClass);
		for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		@SuppressWarnings("unchecked")
		final List<T> result = (List<T>) query.getResultList();
		return result;
	}

	public Class<T> getEntityClass() {
		return persistentClass;
	}

	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void delete(T entity) {
		getEntityManager().remove(entity);
	}

	public T save(T entity) {
		EntityManager em = getEntityManager();
		em.persist(entity);
		return entity;
	}

	public T update(T entity) {
		EntityManager em = getEntityManager();
		em.merge(entity);
		return entity;
	}
}
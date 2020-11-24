package com.example.demo.dao;

import com.example.demo.DemorestApplication;
import com.example.demo.entity.Donor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

@Repository
public class DonorDaoImpl implements DonorDao {
    private static Logger logger = LoggerFactory.getLogger(DonorDaoImpl.class);

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void updateDonor(Donor donor,long id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaUpdate<Donor> update = criteriaBuilder.createCriteriaUpdate(Donor.class);
        Root<Donor> c = update.from(Donor.class);
        update.set(c.get("contact"),donor.getContact())
                .set(c.get("name"),donor.getName())
                .set(c.get("bloodGroup"),donor.getBloodGroup())
                .where(criteriaBuilder.equal(c.get("id"),id));
        em.createQuery(update).executeUpdate();
        em.close();
    }
}

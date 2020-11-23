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
import org.springframework.stereotype.Repository;

@Repository
public class DonorDaoImpl implements DonorDao {
    private static Logger logger = LoggerFactory.getLogger(DonorDaoImpl.class);

    @Override
    public void updateDonor(Donor donor,long id) {
        Session session = DemorestApplication.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Donor donor1 = (Donor) session.load(Donor.class,id);
        donor1.setName(donor.getName());
        donor1.setContact(donor.getContact());
        donor1.setBloodGroup(donor.getBloodGroup());
        logger.info(donor1.toString());

        //session.saveOrUpdate(donor1);
        transaction.commit();
    }
}

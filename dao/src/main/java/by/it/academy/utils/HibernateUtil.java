package by.it.academy.utils;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Utils to connect to database, get session.
 * Using Naming strategy for table and fields names.
 * Created by IPahomov on 16.04.2016.
 */
public class HibernateUtil {
    private static HibernateUtil util = null;
    private static Logger log = Logger.getLogger(HibernateUtil.class);
    private SessionFactory sessionFactory = null;
    private final ThreadLocal sessions = new ThreadLocal();

    private HibernateUtil() {
        try {
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            sessionFactory = configuration
                    .setNamingStrategy(new CostumNamingStrategy())
                    .buildSessionFactory(builder.build());
        } catch (Throwable e) {
            log.error("Initial SessionFactory creation failed. " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public Session getSession() {
        Session session = (Session) sessions.get();
        if (session == null) {
            session = sessionFactory.openSession();
            sessions.set(session);
        }

        return session;
    }

    public static synchronized HibernateUtil getHibernateUtil() {
        if (util == null) {
            util = new HibernateUtil();
        }
        return util;
    }
}

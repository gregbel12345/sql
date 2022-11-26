package pl.sda.hibernate.demo;

import org.hibernate.MappingException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.model.IdentifierGeneratorDefinition;
import org.hibernate.boot.model.TypeDefinition;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.boot.query.NamedHqlQueryDefinition;
import org.hibernate.boot.query.NamedNativeQueryDefinition;
import org.hibernate.boot.query.NamedProcedureCallDefinition;
import org.hibernate.boot.query.NamedResultSetMappingDescriptor;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.annotations.NamedEntityGraphDefinition;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.mapping.FetchProfile;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Table;
import org.hibernate.query.sqm.function.SqmFunctionDescriptor;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
public class HibernateUtil {
    public final static HibernateUtil INSTANCE = new HibernateUtil();
    private final SessionFactory sessionFactory;

    private HibernateUtil() {
        this.sessionFactory = loadConfigFile();
    }

    private SessionFactory loadConfigFile() {
        // Załaduj plik konfiguracyjny: hibernate.cfg.xml
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        // Metadane to dane które opisują dane
        Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

        // Na podstawie metadanych z pliku konfiguracyjnego tworzymy fabrykę sesji
        return metadata.getSessionFactoryBuilder().build();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

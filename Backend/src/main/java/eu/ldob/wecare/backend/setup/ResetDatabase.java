package eu.ldob.wecare.backend.setup;

import eu.ldob.wecare.backend.exception.InsertDatabaseException;
import eu.ldob.wecare.backend.persistence.IUserDao;
import eu.ldob.wecare.backend.persistence.impl.DatabaseConnection;
import eu.ldob.wecare.backend.persistence.impl.UserDao;
import eu.ldob.wecare.entity.user.AUser;
import eu.ldob.wecare.entity.user.Dispatcher;
import eu.ldob.wecare.entity.user.Doctor;
import eu.ldob.wecare.entity.user.Paramedic;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class ResetDatabase {

    private ResetDatabase() { }

    public static void execute() {
        resetDatabase();
        insertData();
    }

    private static void resetDatabase() {

        JdbcTemplate template = new JdbcTemplate(DatabaseConnection.getConnection());
        ISetupDao setupDao = new SetupDao(template);

        setupDao.createTableUser();
    }

    private static void insertData() {

        JdbcTemplate template = new JdbcTemplate(DatabaseConnection.getConnection());
        IUserDao userDao = new UserDao(template);

        List<AUser> users = new ArrayList<>();
        users.add(new Paramedic(-1, "Lucas", "Dobler"));
        users.add(new Doctor(-1, "Jacqueline", "Adlassnigg"));
        users.add(new Dispatcher(-1, "Daniel", "Gehrer"));

        try {
            for (AUser u : users) {
                userDao.insert(u);
            }
        } catch (InsertDatabaseException e) {
            //TODO error handling
            e.printStackTrace();
        }
    }
}

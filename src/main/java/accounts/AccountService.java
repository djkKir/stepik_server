package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountService {

    private DBService dbService;


    public AccountService() {
        dbService = new DBService();
    }

    public void addNewUser(String login, String pass) {
        try {
            long userID = dbService.addUser(login, pass);
           // System.out.println("Added user id: " + userID);
            UsersDataSet dataSet = dbService.getUser(userID);
          //  System.out.println("User data set: " + dataSet);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public UsersDataSet getUserByLogin(String login) {


        try {
            return dbService.getUserLog(login);
        } catch (DBException e) {
            e.printStackTrace();
        }
        return null;
    }
//
//    public UserProfile getUserBySessionId(String sessionId) {
//        return sessionIdToProfile.get(sessionId);
//    }
//
//    public void addSession(String sessionId, UserProfile userProfile) {
//        sessionIdToProfile.put(sessionId, userProfile);
//    }
//
//    public void deleteSession(String sessionId) {
//        sessionIdToProfile.remove(sessionId);
//    }
}

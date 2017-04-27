package dbService.dataSets;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
@SuppressWarnings("UnusedDeclaration")
public class UsersDataSet {
    private long id;
    private String login;
    private String pass;

    public UsersDataSet(long id, String login, String pass) {
        this.id = id;
        this.login = login;
        this.pass = pass;
    }



    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public String toString() {
        return "UsersDataSet{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

}

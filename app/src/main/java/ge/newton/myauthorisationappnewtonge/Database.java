package ge.newton.myauthorisationappnewtonge;

import android.content.SharedPreferences;

public class Database {

    private SharedPreferences sharedPreferences;

    public Database (SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }


    public void saveUser(UserModel userModel) {
        sharedPreferences.edit().putString(userModel.mail, userModel.password).apply();
    }

    public Boolean checkIfEmailExists(UserModel userModel) {
        String password = sharedPreferences.getString(userModel.mail, "");
        if (password.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public Boolean login(UserModel userModel) {
        String password = sharedPreferences.getString(userModel.mail, "");
        return password.equals(userModel.password);
    }
}

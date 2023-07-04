package ahmad.io.asa_corporation.data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import ahmad.io.asa_corporation.dao.UserDao;

/**
 * The type Database helper.
 */
public abstract class DatabaseHelper extends RoomDatabase {

    /**
     * The constant DATABASE_NAME.
     */
    private static final String DATABASE_NAME = "asa_corporation";

    /**
     * Gets db.
     *
     * @param context the context
     * @return the db
     */
    public static DatabaseHelper getDb(Context context) {
        return Room.databaseBuilder(context, DatabaseHelper.class, DATABASE_NAME)
                .allowMainThreadQueries().build();
    }

    /**
     * User dao user dao.
     *
     * @return the user dao
     */
    public abstract UserDao userDao();

}

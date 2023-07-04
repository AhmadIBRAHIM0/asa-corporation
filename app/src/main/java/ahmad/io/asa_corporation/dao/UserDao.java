package ahmad.io.asa_corporation.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ahmad.io.asa_corporation.pojos.User;

/**
 * The interface User dao.
 */
@Dao
public interface UserDao {

    /**
     * Find user.
     *
     * @param id the id
     * @return the user
     */
    @Query("SELECT * FROM users WHERE id = :id")
    User find(Long id);

    /**
     * Find by email user.
     *
     * @param email the email
     * @return the user
     */
    @Query("SELECT * FROM users WHERE email = :email")
    User findByEmail(String email);

    /**
     * Find all homeless list.
     *
     * @return the list
     */
    @Query("SELECT * FROM users WHERE role = 'homeless'")
    List<User> findAllHomeLess();

    /**
     * Check if user exists.
     *
     * @param email    the email
     * @param password the password
     * @return true if the user exists, false otherwise
     */
    @Query("SELECT EXISTS (SELECT 1 FROM users WHERE email = :email AND password = :password)")
    boolean checkUser(String email, String password);

    /**
     * Insert.
     *
     * @param users the users
     */
    @Insert
    void insert(User... users);

    /**
     * Update.
     *
     * @param users the users
     */
    @Update
    void update(User... users);

    /**
     * Delete.
     *
     * @param users the users
     */
    @Delete
    void delete(User... users);
}

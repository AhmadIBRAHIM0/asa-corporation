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
    public User find(Long id);

    /**
     * Find by email user.
     *
     * @param email the email
     * @return the user
     */
    @Query("SELECT * FROM users WHERE email = :email")
    public User findByEmail(String email);

    /**
     * Find all homeless list.
     *
     * @return the list
     */
    @Query("SELECT * FROM users WHERE role = 'homeless'")
    public List<User> findAllHomeLess();

    /**
     * Insert.
     *
     * @param users the users
     */
    @Insert
    public void insert(User ...users);

    /**
     * Update.
     *
     * @param users the users
     */
    @Update
    public void update(User ...users);

    /**
     * Delete.
     *
     * @param users the users
     */
    @Delete
    public void delete(User ...users);
}

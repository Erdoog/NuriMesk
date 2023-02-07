package com.example.nurimesk.data

import com.example.nurimesk.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    val users = mutableMapOf<String, LoggedInUser>("nuris@gmail.com" to LoggedInUser("1", "Nurislam", "123"))

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            if (username in users)
            {
                if (users[username]!!.pwd == password)
                {
                    val user: LoggedInUser = users[username]!!
                    return Result.Success(user)
                }
            }
            else
            {
                val user = LoggedInUser((users.size + 1).toString(), username, password)
                users[username] = user
                return Result.Reg(user)
            }
            return Result.Error(IOException("Invalid username or pwd"));
//            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
    }
}
package com.example.nurimesk.ui.login

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
    val success: LoggedInUserView? = null,
    val reg: LoggedInUserView? = null,
    val error: Int? = null
)
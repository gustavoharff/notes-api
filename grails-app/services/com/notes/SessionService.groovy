package com.notes

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import grails.transaction.Transactional
import org.springframework.http.HttpStatus

import org.mindrot.jbcrypt.BCrypt;

@Transactional
class SessionService {

    Map authorize(String email, String password) {
        if (!email | !password) {
            throw new ApiError(HttpStatus.NOT_ACCEPTABLE, 'invalid_params')
        }

        User user = User.createCriteria().list {
            eq("email", email)
        }[0]

        if (!user) {
            throw new ApiError(HttpStatus.NOT_FOUND, 'user_not_found')
        }

        if (!BCrypt.checkpw(password, user.password)) {
            throw new ApiError(HttpStatus.UNAUTHORIZED, 'password_does_not_match')
        }

        String token = JWT.create()
                .withClaim('id', user.id)
                .withExpiresAt(new Date() + 1)
                .sign(Algorithm.HMAC256('123456'))

        return [
                user: [
                        id: user.id,
                        name: user.name,
                        email: user.email,
                        avatar: user.avatar,
                        createdAt: user.createdAt,
                        updatedAt: user.updatedAt
                ],
                token: token
        ]
    }
}

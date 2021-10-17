package notes

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import grails.converters.JSON

class SessionController {

    def index() {
        String jwt = JWT.create().withClaim('id', '12345').sign(Algorithm.HMAC256('123456'))

        Map response = [jwt: jwt]

        render(contentType: 'text/json', text: response as JSON)
    }
}

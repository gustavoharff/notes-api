package com.notes

import grails.converters.JSON

class SessionController {

    SessionService sessionService

    static allowedMethods = [
            index: ["POST"],
    ]

    def index() {
        String email = request.JSON['email']
        String password = request.JSON['password']

        try {
            Map response = sessionService.authorize(email, password)

            render(contentType: 'text/json', text: response as JSON)
        } catch (ApiError error) {
            render(contentType: 'text/json', status: error.getStatus(), text: [message: error.getMessage()] as JSON)
        }
    }
}

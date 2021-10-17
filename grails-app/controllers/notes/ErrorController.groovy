package notes

import grails.converters.JSON

class ErrorController {

    def index() {
        Map response = [message: 'Endpoint not found']

        render(contentType: 'text/json', text: response as JSON)
    }
}

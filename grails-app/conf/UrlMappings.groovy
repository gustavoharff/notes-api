class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'Error', action: 'index')
        "404"(controller: 'Error', action: 'index')
        "500"(view:'/error')
	}
}

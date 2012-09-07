class UrlMappings {

	static mappings = {
		
		"/release/calendar"(controller: "relCalRest") {
			action = [GET: "list", POST: "save" ]
		}
		
		"/release/calendar/$releaseID"(controller: "relCalRest") {
			action = [GET: "listRel" ]
		}

		"/release/calendar/day/$calDate?"(controller: "relCalRest") {
			action = [GET: "listDay" ]
		}

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}

import grails.converters.JSON

class JSONRenderFilters {
	def filters = {
		all(controller: '(relcalrest)', action: 'listDay') {
			before = {
			}

			after = { model ->
				String resp = model as JSON
				if(params.callback) {
					resp = params.callback + "(" + resp + ")"
				}
				render (contentType: "application/json", text: resp)
				false
			}

			afterView = {
			}
		}
		
		all(controller: '*', action: '*') {
			before = {
			}

			after = {
			}

			afterView = {
			}
		}
	}
}
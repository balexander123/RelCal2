package com.gap.release.calendar

import org.springframework.dao.DataIntegrityViolationException

class DayController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [dayInstanceList: Day.list(params), dayInstanceTotal: Day.count()]
    }

    def create() {
        [dayInstance: new Day(params)]
    }

    def save() {
        def dayInstance = new Day(params)
        if (!dayInstance.save(flush: true)) {
            render(view: "create", model: [dayInstance: dayInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'day.label', default: 'Day'), dayInstance.id])
        redirect(action: "show", id: dayInstance.id)
    }

    def show() {
        def dayInstance = Day.get(params.id)
        if (!dayInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'day.label', default: 'Day'), params.id])
            redirect(action: "list")
            return
        }

        [dayInstance: dayInstance]
    }

    def edit() {
        def dayInstance = Day.get(params.id)
        if (!dayInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'day.label', default: 'Day'), params.id])
            redirect(action: "list")
            return
        }

        [dayInstance: dayInstance]
    }

    def update() {
        def dayInstance = Day.get(params.id)
        if (!dayInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'day.label', default: 'Day'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (dayInstance.version > version) {
                dayInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'day.label', default: 'Day')] as Object[],
                          "Another user has updated this Day while you were editing")
                render(view: "edit", model: [dayInstance: dayInstance])
                return
            }
        }

        dayInstance.properties = params

        if (!dayInstance.save(flush: true)) {
            render(view: "edit", model: [dayInstance: dayInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'day.label', default: 'Day'), dayInstance.id])
        redirect(action: "show", id: dayInstance.id)
    }

    def delete() {
        def dayInstance = Day.get(params.id)
        if (!dayInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'day.label', default: 'Day'), params.id])
            redirect(action: "list")
            return
        }

        try {
            dayInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'day.label', default: 'Day'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'day.label', default: 'Day'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
